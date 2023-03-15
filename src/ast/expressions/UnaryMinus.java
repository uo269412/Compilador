package ast.expressions;

import visitor.Visitor;

public class UnaryMinus extends AbstractExpression{
    public Expression expression;

    public UnaryMinus(int line, int column, Expression expression) {
        super(line,column);
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
