package ast.expressions;

import ast.types.Type;
import visitor.Visitor;

import java.util.Collection;

public class Cast extends AbstractExpression{
    public Expression expression;
    public Type type;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.type = type;
        this.expression = expression;
    }

    public Cast(int line, int column, Integer integer, Expression ast) {
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
