package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.Expression;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

public class Input extends AbstractStatement{

    public Expression exp;

    public Input(int line, int column, Expression toInput) {
        super(line, column);
        this.exp = toInput;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
