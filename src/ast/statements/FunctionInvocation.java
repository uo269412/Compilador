package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import ast.expressions.Variable;
import ast.statements.Statement;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {
    public Variable variable;
    public List<Expression> expressions;

    public FunctionInvocation(int line, int column, Variable variable, List<Expression> expressions) {
        super(line, column);
        this.variable = variable;
        this.expressions = expressions;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
