package ast.types;

import visitor.Visitor;

public class DoubleType extends AbstractType{
    @Override
    public Type getType() {
        return new DoubleType();
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    public static Type getTypeDouble() {
        return new DoubleType();
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
