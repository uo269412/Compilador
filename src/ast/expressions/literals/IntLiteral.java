package ast.expressions.literals;

import ast.expressions.AbstractTerminal;
import visitor.Visitor;

public class IntLiteral extends AbstractTerminal {
    int text;

    public IntLiteral(int line, int lastchar, int value) {
        super(line, lastchar);
        this.text = value;
    }

    public int getText() {
        return text;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
