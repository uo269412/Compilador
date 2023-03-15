package ast.expressions;

import ast.types.Type;
import visitor.Visitor;

public abstract class AbstractExpression implements Expression {

    int line;
    int column;
    Type type;
    boolean lValue;


    public AbstractExpression(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public AbstractExpression(int line, int column, Type type) {
        this.line = line;
        this.column = column;
        this.type = type;
    }

    public AbstractExpression() {

    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    public boolean islValue() {
        return lValue;
    }
    public void setLValue(boolean b) {
        this.lValue = b;
    }
}
