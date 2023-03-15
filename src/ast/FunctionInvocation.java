package ast;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import ast.expressions.Variable;
import ast.statements.Statement;

import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {
    Variable variable;
    List<Expression> expressions;

    public FunctionInvocation(int line, int column, Variable variable, List<Expression> expressions) {
        super(line, column);
        this.variable = variable;
        this.expressions = expressions;
    }
}
