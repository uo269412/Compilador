package semantic;

import ast.ASTNode;
import ast.Definition;
import ast.Program;
import ast.FunctionDefinition;
import ast.VariableDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.literals.RealLiteral;
import ast.statements.*;
import ast.types.*;
import ast.types.ErrorType;
import visitor.AbstractVisitor;
import visitor.Visitor;

public class LValueVisitor extends AbstractVisitor<Object, ASTNode> {

    @Override
    public FunctionDefinition visit(FunctionDefinition ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public VariableDefinition visit(VariableDefinition ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public CharLiteral visit(CharLiteral ast, Object param) {
        super.visit(ast, param);
        ast.setType(CharType.getTypeChar());
        return null;
    }

    @Override
    public IntLiteral visit(IntLiteral ast, Object param) {
        super.visit(ast, param);
        ast.setType(IntType.getTypeInt());
        return null;
    }

    @Override
    public RealLiteral visit(RealLiteral ast, Object param) {
        super.visit(ast, param);
        ast.setType(RealType.getTypeReal());
        return null;
    }

    @Override
    public Arithmetic visit(Arithmetic ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.expression1.getType().arithmetic(ast, ast.expression2.getType()));
        return null;
    }

    @Override
    public ArrayIndexing visit(ArrayIndexing ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(ast.expression1.islValue());
        return null;
    }

    @Override
    public Cast visit(Cast ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(ast.expression.islValue());
        return null;
    }

    @Override
    public Comparison visit(Comparison ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        return null;
    }

    @Override
    public FieldAccess visit(FieldAccess ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(ast.expression.islValue());
        return null;
    }

    @Override
    public LogicalOperation visit(LogicalOperation ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        return null;
    }

    @Override
    public UnaryMinus visit(UnaryMinus ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.getType().arithmetic(ast.expression));
        return null;
    }

    @Override
    public UnaryNot visit(UnaryNot ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        return null;
    }

    @Override
    public Variable visit(Variable ast, Object param) {
        ast.setLValue(true);
        ast.setType(ast.getDefinition().getType());
        return null;
    }

    @Override
    public Assignment visit(Assignment ast, Object param) {
        super.visit(ast, param);
        if (!ast.expression1.islValue()) {
            new ErrorType(ast.expression1.getLine(), ast.expression1.getColumn(), "The left side expression is not a lvalue");
        }
        return null;
    }

    @Override
    public FunctionInvocation visit(FunctionInvocation ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public If visit(If ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public Input visit(Input ast, Object param) {
        super.visit(ast, param);
        if (!ast.exp.islValue()) {
            ast.exp.setType(new ErrorType(ast.exp.getLine(), ast.exp.getColumn(), "The input we want to introduce is not a lvalue"));
        }
        return null;
    }

    @Override
    public Print visit(Print ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public Return visit(Return ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public While visit(While ast, Object param) {
        super.visit(ast, param);
        ast.setType(ast.expression.getType().isLogical(ast.expression));
        return null;
    }

    @Override
    public ArrayType visit(ArrayType ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public CharType visit(CharType ast, Object param) {
        return null;
    }

    @Override
    public DoubleType visit(DoubleType ast, Object param) {
        return null;
    }

    @Override
    public FunctionType visit(FunctionType ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public IntType visit(IntType ast, Object param) {
        return null;
    }

    @Override
    public RealType visit(RealType ast, Object param) {
        return null;
    }

    @Override
    public RecordField visit(RecordField ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public StructType visit(StructType ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public VoidType visit(VoidType ast, Object param) {
        return null;
    }

    @Override
    public Program visit(Program ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public ErrorType visit(ErrorType ast, Object param) {
        super.visit(ast, param);
        return null;
    }
}
