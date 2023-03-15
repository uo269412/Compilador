package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.Expression;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

public class Return extends AbstractStatement{

   public Expression exp;

    public Return(int line, int column, Expression toReturn) {
        super(line, column);
        this.exp = toReturn;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
