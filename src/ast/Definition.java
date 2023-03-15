package ast;

import ast.ASTNode;
import ast.types.Type;

public interface Definition extends ASTNode {

     Type getType();
     String getName();
     int getScope();
     void setScope(int number);
     int getOffset();
}
