package ast.statements;

import ast.ASTNode;
import ast.FunctionDefinition;
import codegenerator.ExecuteCGVisitor;

public interface Statement extends ASTNode {

    void accept(ExecuteCGVisitor executeCGVisitor, FunctionDefinition ast);
}
