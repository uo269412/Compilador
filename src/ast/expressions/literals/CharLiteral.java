package ast.expressions.literals;

import ast.expressions.AbstractTerminal;
import visitor.Visitor;

public class CharLiteral extends AbstractTerminal {
    char text;

    public CharLiteral(int line, int lastchar, char value) {
        super(line,lastchar);
        this.text = value;
    }

    public char getText() {
        return text;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
