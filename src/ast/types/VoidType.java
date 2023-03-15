package ast.types;

import visitor.Visitor;

public class VoidType extends AbstractType{
    @Override
    public Type getType() {
        return new VoidType();
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public int numberOfBytes(){
        return 0;
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
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
