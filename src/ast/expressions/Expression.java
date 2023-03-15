package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {

    public boolean islValue();
    public Type getType();
    public void setType(Type type);

}
