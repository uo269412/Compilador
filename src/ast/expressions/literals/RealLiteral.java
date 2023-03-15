package ast.expressions.literals;

import ast.expressions.AbstractTerminal;
import visitor.Visitor;

public class RealLiteral extends AbstractTerminal {
    double text;

    public RealLiteral(int line, int lastchar, double value) {
        super(line, lastchar);
        this.text = value;
    }

    public double getText() {
        return text;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
