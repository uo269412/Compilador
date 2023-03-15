package ast.statements;

import ast.FunctionDefinition;
import ast.expressions.Expression;
import codegenerator.ExecuteCGVisitor;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class If extends AbstractStatement{
    public Expression expression;
    public List<Statement> statementsIf;
    public List<Statement> statementsElse;

    public If(int line, int column, Expression expression, List<Statement> statementsIf, List<Statement> statementsElse) {
        super(line, column);
        this.expression = expression;
        this.statementsIf = statementsIf;
        this.statementsElse = statementsElse;
    }

    public If(int line, int column, Expression expression, List<Statement> statementsIf) {
        this(line, column, expression, statementsIf, new ArrayList<Statement>());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

}
