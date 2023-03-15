package ast;

import ast.types.Type;
import visitor.Visitor;

public class VariableDefinition extends AbstractDefinition {

    int offset;


    public VariableDefinition(int line, int column, String name, Type type) {
        super(line,column, name, type);

    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offSet) {
        this.offset = offSet;
    }
}
