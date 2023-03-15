package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.Expression;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

public class Assignment extends AbstractStatement {
    public Expression expression1;
    public Expression expression2;

    public Assignment(int line, int column, Expression expression1, Expression expression2) {
        super(line, column);
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
