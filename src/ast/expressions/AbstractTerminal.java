package ast.expressions;

import ast.types.Type;

public abstract class AbstractTerminal extends AbstractExpression{

    int line;
    int charPositionInLine;

    public AbstractTerminal(int line, int charPositionInLine) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }

    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    public void setCharPositionInLine(char charPositionInLine) {
        this.charPositionInLine = charPositionInLine;
    }
}
