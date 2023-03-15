package ast.statements;

import ast.expressions.Expression;
import ast.types.Type;

public abstract class AbstractStatement implements Statement {

    int line;
    int column;
    Type type;


    public AbstractStatement(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public AbstractStatement(int line, int column, Type type) {
        this.line = line;
        this.column = column;
        this.type = type;
    }

    public AbstractStatement() {

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

    public void setType(Type type) {
        this.type = type;
    }
}
