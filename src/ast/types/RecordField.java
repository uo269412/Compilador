package ast.types;

import ast.ASTNode;
import visitor.Visitor;

import java.util.Collection;

public class RecordField extends AbstractType {
    int line;
    int column;
    String name;
    public Type type;
    int offset;

    public RecordField(int line, int column,String name, Type type) {
        this.line = line;
        this.column = column;
        this.name = name;
        this.type = type;
    }

    public RecordField() {
    }

    @Override
    public Type getType() {
        return new RecordField(this.line, this.column, this.name, this.type);
    }

    @Override
    public String toString() {
        return "record";
    }

    @Override
    public int numberOfBytes(){
        return type.numberOfBytes();
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

    public String getName() {
        return name;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
