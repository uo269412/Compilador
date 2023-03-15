package ast.expressions;

import visitor.Visitor;

public class ArrayIndexing extends AbstractExpression{
    public Expression expression1;
    public Expression expression2;

    public ArrayIndexing(int line, int column, Expression expression1, Expression expression2) {
        super(line, column);
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
