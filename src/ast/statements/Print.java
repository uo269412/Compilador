package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.Expression;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

public class Print extends AbstractStatement{

    public Expression exp;

    public Print(int line, int column, Expression toPrint) {
        super(line, column);
        this.exp = toPrint;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
