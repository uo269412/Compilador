package ast.expressions;

import visitor.Visitor;

import java.util.Collection;

public class FieldAccess extends AbstractExpression{
    public String fieldName;
    public Expression expression;

    public FieldAccess(int line, int column, Expression expression, String fieldName) {
        super(line, column);
        this.fieldName = fieldName;
        this.expression = expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }


}
