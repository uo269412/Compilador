package ast.expressions;

import visitor.Visitor;

public class UnaryNot extends AbstractExpression{
    public Expression expression;

    public UnaryNot(int line, int column, Expression expression) {
        super(line,column);
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
