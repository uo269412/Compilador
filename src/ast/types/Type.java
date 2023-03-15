package ast.types;

import ast.ASTNode;
import ast.expressions.Expression;

import java.util.List;

public interface Type extends ASTNode {

    Type getType();

    //Type checking
    Type isBuiltInType(ASTNode node);
    Type isLogical(ASTNode node);
    Type arithmetic(ASTNode node, Type type);
    Type arithmetic(ASTNode node);
    Type logic(ASTNode node, Type type);
    Type logic(ASTNode node);
    Type promotesTo(ASTNode node, Type type);
    Type canBeCastTo(ASTNode node, Type type);
    Type comparison(ASTNode node, Type type);
    Type squareBrackets(ASTNode node, Type type);
    Type dot(ASTNode node, String string);
    Type parenthesis(ASTNode node, List<Expression> expressions);

    String toString();

    //Code generation
    int numberOfBytes();
    String suffix();



}
