package ast.types;

import ast.ASTNode;
import ast.expressions.Expression;

import java.util.List;

public abstract class AbstractType implements Type{
    @Override
    public abstract Type getType();

    @Override
    public String suffix() {
        throw new IllegalArgumentException("This type doesn't have a suffix for code generator");
    }

    @Override
    public Type isBuiltInType(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "The chosen type is not a built-in type");
    }

    @Override
    public Type isLogical(ASTNode ast) {
        return new ErrorType(ast.getLine(), ast.getColumn(), "The condition given to the statement is not logical");
    }

    @Override
    public Type arithmetic(ASTNode node, Type type) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't use these types to compute an arithmetic operation");
    }

    @Override
    public Type arithmetic(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't do an unary minus with this type");
    }

    @Override
    public Type logic(ASTNode node, Type type) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't use this type in a logic operation");
    }

    @Override
    public Type logic(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't use this type in a unary not operation");
    }

    @Override
    public Type promotesTo(ASTNode node, Type type) {
        return new ErrorType(node.getLine(), node.getColumn(), "This type can't be promoted");
    }

    @Override
    public Type canBeCastTo(ASTNode node, Type type) {
        return new ErrorType(node.getLine(), node.getColumn(), "This type cannot be casted to the chosen type");
    }

    @Override
    public Type comparison(ASTNode node, Type type) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't compare these expressions");
    }

    @Override
    public Type squareBrackets(ASTNode node, Type type) {
        return new ErrorType(node.getLine(), node.getColumn(), "The type doesn't accept square brackets");
    }

    @Override
    public Type dot(ASTNode node, String string) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't use field access with this type");
    }

    @Override
    public Type parenthesis(ASTNode node, List<Expression> expressions) {
        return new ErrorType(node.getLine(), node.getColumn(), "You can't invoke this function this way");
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(this.getClass());
    }

    @Override
    public abstract String toString();


}
