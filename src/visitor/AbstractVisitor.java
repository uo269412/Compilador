package visitor;

import ast.*;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.literals.RealLiteral;
import ast.statements.*;
import ast.types.*;

public class AbstractVisitor<TP, TR> extends Visitor<TP, TR>{
    @Override
    public TR visit(FunctionDefinition ast, TP param) {
        ast.type.accept(this, param);
        for (VariableDefinition lv : ast.localVariables) {
            lv.accept(this, param);
        }
        for (Statement st : ast.statements) {
            st.accept(this, param);
        }
        return null;
    }


    @Override
    public TR visit(VariableDefinition ast, TP param) {
        ast.type.accept(this,param);
        return null;
    }

    @Override
    public TR visit(CharLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(RealLiteral ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic ast, TP param) {
        ast.expression1.accept(this, param);
        ast.expression2.accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayIndexing ast, TP param) {
        ast.expression1.accept(this, param);
        ast.expression2.accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast ast, TP param) {
        ast.expression.accept(this, param);
        ast.type.accept(this,param);
        return null;
    }

    @Override
    public TR visit(Comparison ast, TP param) {
        ast.expression1.accept(this, param);
        ast.expression2.accept(this, param);
        return null;
    }

    @Override
    public TR visit(FieldAccess ast, TP param) {
        ast.expression.accept(this, param);
        return null;
    }

    @Override
    public TR visit(LogicalOperation ast, TP param) {
        ast.expression1.accept(this, param);
        ast.expression2.accept(this,param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus ast, TP param) {
        ast.expression.accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNot ast, TP param) {
        ast.expression.accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment ast, TP param) {
        ast.expression1.accept(this, param);
        ast.expression2.accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation ast, TP param) {
        ast.variable.accept(this, param);
        for (Expression expr : ast.expressions) {
            expr.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(If ast, TP param) {
        ast.expression.accept(this,param);
        for (Statement st : ast.statementsIf) {
            st.accept(this, param);
        }
        for (Statement st2 : ast.statementsElse) {
            st2.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Input ast, TP param) {
        ast.exp.accept(this,param);
        return null;
    }

    @Override
    public TR visit(Print ast, TP param) {
        ast.exp.accept(this,param);
        return null;
    }

    @Override
    public TR visit(Return ast, TP param) {
        ast.exp.accept(this, param);
        return null;
    }

    @Override
    public TR visit(While ast, TP param) {
        ast.expression.accept(this,param);
        for (Statement st : ast.statements) {
            st.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(ArrayType ast, TP param) {
        ast.type.accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharType ast, TP param) {
        return null;
    }


    @Override
    public TR visit(FunctionType ast, TP param) {
        ast.returned.accept(this, param);
        for (VariableDefinition var : ast.parameters) {
            var.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(IntType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(RealType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField ast, TP param) {
        ast.type.accept(this, param);
        return null;
    }

    @Override
    public TR visit(StructType ast, TP param) {
        for (RecordField record : ast.records) {
            record.accept(this,param);
        }
        return null;
    }

    @Override
    public TR visit(VoidType ast, TP param) {
        return null;
    }

    @Override
    public TR visit(Program ast, TP param) {
        for (Definition def : ast.definitions) {
            def.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(ErrorType ast, TP param) {
        ast.accept(this, param);
        return null;
    }
}
