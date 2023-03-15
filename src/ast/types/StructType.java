package ast.types;

import ast.ASTNode;
import visitor.Visitor;

import java.util.Collection;
import java.util.List;

public class StructType extends AbstractType {

    public List<RecordField> records;
    int line;
    int column;

    public StructType(int line, int column, List<RecordField> records) {
        this.line = line;
        this.column = column;
        this.records = records;
    }


    @Override
    public Type getType() {
        return new StructType(this.line, this.column, this.records);
    }

    @Override
    public int numberOfBytes() {
        int sum = 0;
        for (RecordField rf : records) {
            sum += rf.numberOfBytes();
        }
        return sum;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public RecordField getRecord(String name) {
        for (RecordField rf : records) {
            if (rf.getName().equals(name)) {
                return rf;
            }
        }
        throw new IllegalStateException("The record is not present in the struct");
    }

    @Override
    public Type dot(ASTNode node, String string) {
        for (RecordField rf : records) {
            if (rf.getName().equals(string)) {
                return rf.type;
            }
        }
        return new ErrorType(getLine(), getColumn(), "The record is not present in the struct");
    }

    @Override
    public String toString() {
        return "struct";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
