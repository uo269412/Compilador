package codegenerator;

import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.literals.RealLiteral;
import ast.statements.FunctionInvocation;
import ast.types.IntType;
import ast.types.RealType;
import ast.types.StructType;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    AddressCGVisitor address;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
        this.address = new AddressCGVisitor(cg, this);
    }

    /*
     value[[IntLiteral : expression -> INT_CONSTANT]] () =
         <pushi>
  */
    @Override
    public Void visit(IntLiteral ast, Void param) {
        cg.pushi(ast.getText());
        return null;
    }

    /*
      value[[IntLiteral : expression -> INT_CONSTANT]] () =
        <pushb>
    */
    @Override
    public Void visit(CharLiteral ast, Void param) {
        cg.pushb(ast.getText());
        return null;
    }

    /*
      value[[IntLiteral : expression -> INT_CONSTANT]] () =
        <pushf>
    */
    @Override
    public Void visit(RealLiteral ast, Void param) {
        //ast.accept(address, param);
        cg.pushf(ast.getText());
        return null;
    }

    /*
        [[Arithmetic: expression -> expression1 operand expression2]] () =
            value[[expression1]]
            <promote>expression1.type, expression.type
            value[[expression2]]
            <promote>expression2.type, expression.type
            if (operand == "+") {
                <add>expression.type
            } else if (operand == "-") {
                <sub>expression.type
            } else if (operand == "*") {
                <mul>expression.type
            } else if (operand == "/") {
                <div>expression.type
            } else if (operand == "%) {
                <mod>expression.type
            }
    */
    @Override
    public Void visit(Arithmetic ast, Void param) {
        ast.expression1.accept(this, param);
        cg.convert(ast.expression1.getType(), ast.getType());
        ast.expression2.accept(this, param);
        cg.convert(ast.expression2.getType(), ast.getType());
        switch (ast.getOperator()) {
            case "+":
                cg.add(ast.getType());
                break;
            case "-":
                cg.sub(ast.getType());
                break;
            case "*":
                cg.mul(ast.getType());
                break;
            case "/":
                cg.div(ast.getType());
                break;
            case "%":
                cg.mod(ast.getType());
                break;
        }
        return null;
    }

    /*
        value[[ArrayIndexing : expression -> expression1 expression2]] () =
            address[[expression]]
            <load>expression.suffix();
     */
    @Override
    public Void visit(ArrayIndexing ast, Void param) {
        ast.accept(address, param);
        cg.load(ast.getType());
        return null;
    }

    /*
     value[[Cast : expression -> type expression1]] () =
        value[[expression1]]
       <promote>expression1.type type
   */
    @Override
    public Void visit(Cast ast, Void param) {
        ast.expression.accept(this, param);
        cg.convert(ast.expression.getType(), ast.getType());
        return null;
    }

    /*
     value[[Comparison : expression -> expression1 operator expression2]] () =
       value[[expression1]] ()
       <promote>expression1.type, expression.type
       value[[expression2]] ()
       <promote>expression2.type, expression.type
       if (operator == ">") {
          <gt>expression1.type.suffix()
       } else if (operator == "<") {
          <lt>expression1.type.suffix()
       } else if (operator == ">=") {
          <ge>expression1.type.suffix()
       } else if (operator == "<=") {
          <le>expression1.type.suffix()
       } else if (operator == "!=") {
          <ne>expression1.type.suffix()
       } else if (operator == "==") {
          <eq>expression1.type.suffix()
       }
   */
    @Override
    public Void visit(Comparison ast, Void param) {
        ast.expression1.accept(this, param);
        cg.convert(ast.expression1.getType(), ast.getType());
        ast.expression2.accept(this, param);
        cg.convert(ast.expression2.getType(), ast.getType());
        switch (ast.getOperator()) {
            case ">":
                cg.gt(ast.getType());
                break;
            case "<":
                cg.lt(ast.getType());
                break;
            case ">=":
                cg.ge(ast.getType());
                break;
            case "<=":
                cg.le(ast.getType());
                break;
            case "!=":
                cg.ne(ast.getType());
                break;
            case "==":
                cg.eq(ast.getType());
                break;
        }
        return null;
    }

    /*
      value[[FieldAccess: expression -> expression1 ID]] () =
        address[[expression]]
        <load>expression.type.suffix()
     */
    @Override
    public Void visit(FieldAccess ast, Void param) {
        ast.accept(address, param);
        cg.load(ast.getType());
        return null;
    }


    /*
     value[[LogicalOperation : expression -> expression1 operator expression2]] () =
       value[[expression1]] ()
       <promote>expression1.type, expression.type
       value[[expression2]] ()
       <promote>expression2.type, expression.type
       if (operator == "&&") {
          <and>
       } else if (operator == "||") {
          <or>
       }
   */
    @Override
    public Void visit(LogicalOperation ast, Void param) {
        ast.expression1.accept(this, param);
        cg.convert(ast.expression1.getType(), ast.getType());
        ast.expression2.accept(this, param);
        cg.convert(ast.expression2.getType(), ast.getType());
        switch (ast.getOperator()) {
            case "&&":
                cg.and();
                break;
            case "||":
                cg.or();
                break;
        }
        return null;
    }

    /*
     value[[UnaryNot : expression -> expression1]] () =
       value[[expression1]] ()
       <not>
   */
    @Override
    public Void visit(UnaryNot ast, Void param) {
        ast.expression.accept(this, param);
        cg.not();
        return null;
    }


    /*
     value[[UnaryMinus : expression -> expression1]] () =
       if (expression1.getType() instanceof RealType) {
            <pushf>-1.0
       } else if (expression1.getType() instanceof IntType) {
            <pushi>-1
       }
       value[[expression1]] ()
       <mul>expression1.type.suffix
   */
    @Override
    public Void visit(UnaryMinus ast, Void param) {
        if (ast.expression.getType().equals(RealType.getTypeReal())) {
            cg.pushf(-1.0);
        } else if (ast.expression.getType().equals(IntType.getTypeInt())) {
            cg.pushi(-1);
        }
        ast.expression.accept(this, param);
        cg.mul(ast.expression.getType());
        return null;
    }

    /*
        value[[Variable : expression -> ID]] () =
            address[[expression]] ()
            <load>expression.type.suffix()
     */
    @Override
    public Void visit(Variable ast, Void param) {
        ast.accept(address, param);
        cg.load(ast.getType());
        return null;
    }

    /*
        [[FunctionInvocation: expression -> expression1 expression2*] () =
        expression2.forEach(exp -> value[[exp]]);
        <call>expression1.name;
    */
    @Override
    public Void visit(FunctionInvocation ast, Void param) {
        cg.comment("Function Invocation [Expression] (" + ast.getLine() + ")");
        for (Expression exp : ast.expressions) {
            exp.accept(this, param);
        }
        return null;
    }

}
