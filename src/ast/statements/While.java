package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.Expression;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

import java.util.Collection;
import java.util.List;

public class While extends AbstractStatement{

    public Expression expression;
    public List<Statement> statements;


    public While(int line, int column, Expression expression, List<Statement> statements) {
        super(line, column);
        this.expression = expression;
        this.statements = statements;

    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
