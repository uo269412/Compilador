package ast.types;

import ast.ASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class RealType extends AbstractType{
    @Override
    public Type getType() {
        return new RealType();
    }

    public static Type getTypeReal() {
        return new RealType();
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public Type arithmetic(ASTNode ast, Type type) {
        //type.acceptOperation(arithmeticOperationVisitor, this);
        if (type.equals(RealType.getTypeReal()) || type instanceof ErrorType) {
            return this;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "The types of the expressions that are part of the arithmetic are not valid");
    }

    @Override
    public Type arithmetic(ASTNode node) {
        return this;
    }

    @Override
    public Type comparison(ASTNode ast, Type type) {
        if (type.equals(RealType.getTypeReal()) || type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "You can't compare a real to a different type");
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public String suffix() {
        return "f";
    }

    @Override
    public Type logic(ASTNode ast, Type type) {
        if (type.equals(RealType.getTypeReal()) || type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "You can't use a real and a different type in a logical operation");
    }

    @Override
    public Type isBuiltInType(ASTNode node) {
        return this;
    }

    @Override
    public Type canBeCastTo(ASTNode ast, Type type) {
        if (type.equals(IntType.getTypeInt()) || type.equals(RealType.getTypeReal()) || type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType(ast.getLine(), ast.getColumn(), "You can't use cast from a real to this type");
        }
    }

    @Override
    public Type promotesTo(ASTNode ast, Type type) {
        if (type.equals(RealType.getTypeReal()) || type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType(ast.getLine(), ast.getColumn(), "You can't assign to this type a real");
        }
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
