package ast.types;

import ast.ASTNode;
import visitor.Visitor;

public class IntType extends AbstractType{
    public Type getType() {
        return new IntType();
    }

    public static Type getTypeInt() {
        return new IntType();
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
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public String suffix() {
        return "i";
    }


    @Override
    public Type isLogical(ASTNode ast) {
        return this;
    }

    @Override
    public Type arithmetic(ASTNode ast, Type type) {
        //type.acceptOperation(arithmeticOperationVisitor, this);
         if (type.equals(IntType.getTypeInt()) || type instanceof ErrorType) {

            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "The types of the expressions that are part of the arithmetic are not valid");
    }

    @Override
    public Type comparison(ASTNode ast, Type type) {
        if (type.equals(IntType.getTypeInt()) || type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "You can't compare an int to a different type");
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public Type logic(ASTNode ast, Type type) {
        if (type.equals(IntType.getTypeInt()) || type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "You can't use an int and a different type in a logical operation");
    }

    @Override
    public Type logic(ASTNode node) {
        return IntType.getTypeInt();
    }

    @Override
    public Type isBuiltInType(ASTNode node) {
        return this;
    }

    @Override
    public Type canBeCastTo(ASTNode ast, Type type) {
        if (type.isBuiltInType(ast) instanceof ErrorType) {
            return new ErrorType(ast.getLine(), ast.getColumn(), "You can't use cast from an int to this type");
        } else {
            return type;
        }
    }

    @Override
    public Type promotesTo(ASTNode ast, Type type) {
        if (type.equals(IntType.getTypeInt()) || type.equals(RealType.getTypeReal()) || type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType(ast.getLine(), ast.getColumn(), "You can't assign to this type an int");
        }
    }

    @Override
    public Type arithmetic(ASTNode node) {
        return this;
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
