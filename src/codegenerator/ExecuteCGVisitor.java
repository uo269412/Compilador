package codegenerator;

import ast.Definition;
import ast.FunctionDefinition;
import ast.Program;
import ast.VariableDefinition;
import ast.expressions.Expression;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<Object, Void> {

    AddressCGVisitor address;
    ValueCGVisitor value;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.value = new ValueCGVisitor(cg);
        this.address = new AddressCGVisitor(cg, this.value);
    }

    /*
        [[Assignment: statement -> expression1 expression2]] () =
        address[[expression1]]
        value[[exp2]]
        <store>expression1.type.suffix()
    */
    @Override
    public Void visit(Assignment ast, Object param) {
        cg.comment("Assignment (" + ast.getLine() + ")");
        ast.expression1.accept(address, null);
        ast.expression2.accept(value, null);
        cg.store(ast.expression1.getType());
        cg.printNewLine();
        return null;
    }

    /*
        [[Input: statement -> expression]] () =
        address[[expression]]()
        <in>expression.type.suffix()
        <store>expression.type.suffix()
     */
    @Override
    public Void visit(Input ast, Object param) {
        cg.comment("Read (" + ast.getLine() + ")");
        ast.exp.accept(address, null);
        cg.in(ast.exp.getType());
        cg.store(ast.exp.getType());
        cg.printNewLine();
        return null;
    }


    /*
       [[Print: statement -> expression]] () =
       value[[expression]]()
       <out>expression.type.suffix()
    */
    @Override
    public Void visit(Print ast, Object param) {
        cg.comment("Write (" + ast.getLine() + ")");
        ast.exp.accept(value, null);
        cg.out(ast.exp.getType());
        cg.printNewLine();
        return null;
    }

    /*
        [[Program: program -> definition*]] () =
        for (Definition vdef : definition*) {
            if (vdef instance of VariableDefinition) {
                execute[[vdef]]
            }
        }
        <call main>
        <halt>
        for (FuncDefinition fdef : definition*) {
             if (fdef instance of FuncDefinition) {
                execute[[fdef]]
            }
        }
     */
    @Override
    public Void visit(Program ast, Object param) {
        cg.comment("Global variables");
        for (Definition vdef : ast.definitions) {
            if (vdef instanceof VariableDefinition) {
                vdef.accept(this, null);
            }
        }
        cg.call("main");
        cg.halt();
        cg.printNewLine();
        for (Definition fdef : ast.definitions) {
            if (fdef instanceof FunctionDefinition) {
                fdef.accept(this, null);
            }
        }
        return null;
    }

    /*
        [[VariableDefinition: definition -> type ID]] () =
        <'*>type.toString() ID <(offset> vardefinition.offset <)>

     */
    @Override
    public Void visit(VariableDefinition ast, Object param) {
        cg.varDefinition(ast);
        return null;
    }


    /*
        [[FuncDefinition: definition -> ID type -> (variabledefinition* statement*)]] () =
        ID<:>
        <' * Parameters:>
        for(VariableDefinition parameter : ast.getType().parameters) {
            execute[[parameter]]
        }
        <' * Local variables:>
           for(VariableDefinition vdef : ast.localVariables) {
             execute[[vdef]]
        }
        if (ast.localVariables.size > 0) {
            <enter>-ast.localVariables.get(ast.localVariables.size()-1).offset
        }
        for (Statement st : statement) {
            if (!st instanceOf VariableDefinition) {
                execute[[st]];
            }
        }
        if (type.returnType instanceof VoidType) {
            <ret> 0 <,> definition.bytesLocalSum <,> type.bytesParameters
        }
     }
  */
    @Override
    public Void visit(FunctionDefinition ast, Object param) {
        cg.print(ast.getName() + ":");
        cg.comment("Parameters:");
        for (VariableDefinition parameters : ((FunctionType) ast.getType()).parameters) {
            parameters.accept(this, null);
        }
        cg.comment("Local variables:");
        for (VariableDefinition vdef : ast.localVariables) {
            vdef.accept(this, null);
        }
        int bytesLocal = 0;
        if (ast.localVariables.size() > 0) {
            bytesLocal = -ast.localVariables.get(ast.localVariables.size() - 1).getOffset();
            ast.setBytesLocal(bytesLocal);
            cg.enter(bytesLocal);
        }
        int bytesParam = ((FunctionType) ast.getType()).parameters.stream().mapToInt( paramf -> paramf.type.numberOfBytes()).sum();
        ast.setBytesParam(bytesParam);
        cg.printNewLine();
        for (Statement st : ast.statements) {
            st.accept(this, ast);
        }
        if (ast.getType() instanceof VoidType) {
            cg.ret(0, bytesLocal, bytesParam);
        }
        return null;
    }

    /*
        [[While: statement -> expression statement1*] () =
            int condition = cg.getLabel();
            int exitLoop = cg.getLabel();
            <label> condition:
                value[[expression]]
                <jz label> exit
                statement1*.foreach(stmt-> execute[[stmt]])
                <jmp> condition
            <label> exit:
        }
    */
    @Override
    public Void visit(While ast, Object param) {
        cg.comment("While (" + ast.getLine() + ")");
        int condition = cg.getLabel();
        int exitLoop = cg.getLabel();
        cg.label(condition);
        ast.expression.accept(value, null);
        cg.jz(exitLoop);
        for (Statement st : ast.statements) {
            st.accept(this, param);
        }
        cg.jmp(condition);
        cg.label(exitLoop);
        return null;
    }

    /*
     [[If: statement -> expression statement1* statement2*] () =
         int elseLabel = cg.getLabel();
         int exitStatement = cg.getLabel();
         value[[expression]]
         <jz label> elseLabel
         statement1*.foreach(stmt-> execute[[stmt]])
         <jmp> exitStatement
         <label> elseLabel:
         statement2*.foreach(stmt-> execute[[stmt]])
         <label> exitStatement:
     }
 */
    @Override
    public Void visit(If ast, Object param) {
        cg.comment("If (" + ast.getLine() + ")");
        int elseLabel = cg.getLabel();
        int exitStatement = cg.getLabel();

        ast.expression.accept(value, null);
        cg.jz(elseLabel);
        for (Statement st : ast.statementsIf) {
            st.accept(this, param);
        }
        cg.jmp(exitStatement);
        cg.label(elseLabel);
        for (Statement st : ast.statementsElse) {
            st.accept(this, param);
        }
        cg.label(elseLabel);
        return null;
    }

    /*
    [[FunctionInvocation: statement -> expression1 expression2*] () =
     value[[(Expression) statement]]
     if (!(((Expression)statement).getType() instanceof VoidType)) {
            <pop>((Expression)statement).getType();
        }
    */
    @Override
    public Void visit(FunctionInvocation ast, Object param) {
        cg.comment("Function Invocation [Statement] (" + ast.getLine() + ")");
        ast.accept(value, null);
        if (!(ast.getType() instanceof VoidType)) {
            cg.pop(ast.getType());
        }
        return null;
    }

    /*
        [[Return: statement -> expression1] (funcDefinition) =
        value[[(Expression) statement]]
        if (!(((Expression)statement).getType() instanceof VoidType)) {
            <pop>((Expression)statement).getType();
         }
*/
    @Override
    public Void visit(Return ast, Object param) {
        cg.comment("Return (" + ast.getLine() + ")");
        ast.accept(value, null);
        cg.ret(ast.exp.getType().numberOfBytes(), ((FunctionDefinition)param).getBytesLocal(), ((FunctionDefinition)param).getBytesParam());
        return null;
    }

}
