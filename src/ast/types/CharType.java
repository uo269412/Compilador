package ast.types;

import ast.ASTNode;
import visitor.Visitor;

public class CharType extends AbstractType {
    @Override
    public  Type getType() {
        return new CharType();
    }
    public static Type getTypeChar() {
        return new CharType();
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
        return 1;
    }

    @Override
    public String suffix() {
        return "b";
    }

    @Override
    public Type arithmetic(ASTNode ast, Type type) {
        if (type.equals(CharType.getTypeChar())) {
            return IntType.getTypeInt();
        } else if (type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "The types of the expressions that are part of the arithmetic are not valid");
    }

    @Override
    public Type comparison(ASTNode ast, Type type) {
        if (type.equals(CharType.getTypeChar())) {
            return IntType.getTypeInt();
        } else if (type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "You can't compare a char to a different type");
    }

    @Override
    public String toString() {
        return "char";
    }


    @Override
    public Type logic(ASTNode ast, Type type) {
        if (type.equals(CharType.getTypeChar())) {
            return IntType.getTypeInt();
        } else if (type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(ast.getLine(), ast.getColumn(), "You can't use a char and a different type in a logical operation");
    }

    @Override
    public Type isBuiltInType(ASTNode node) {
        return this;
    }

    @Override
    public Type canBeCastTo(ASTNode ast, Type type) {
        if (type.equals(CharType.getTypeChar()) || type.equals(RealType.getTypeReal()) || type.equals(IntType.getTypeInt()) || type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType(ast.getLine(), ast.getColumn(), "You can't use cast from a char to this type");
        }
    }

    @Override
    public Type promotesTo(ASTNode ast, Type type) {
        if (type.equals(CharType.getTypeChar()) || type instanceof ErrorType) {
            return type;
        } else {
            return new ErrorType(ast.getLine(), ast.getColumn(), "You can't assign to this type a char");
        }
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
