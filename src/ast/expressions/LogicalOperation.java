package ast.expressions;

import visitor.Visitor;

public class LogicalOperation extends AbstractExpression{

    String operator;
    public Expression expression1;
    public Expression expression2;

    public LogicalOperation(int line, int column, Expression expression1,  String operator, Expression expression2) {
        super(line, column);
        this.operator = operator;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
