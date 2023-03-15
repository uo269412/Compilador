package ast.types;

import ast.ASTNode;
import ast.VariableDefinition;
import ast.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {

    public List<VariableDefinition> parameters;
    public Type returned;

    public FunctionType(List<VariableDefinition> parameters, Type returned) {
        this.parameters = parameters;
        this.returned = returned;
    }

    public FunctionType(Type returned) {
        this.returned = returned;
    }

    @Override
    public Type parenthesis(ASTNode node, List<Expression> expressions) {
        if (expressions.size() != parameters.size()) {
            new ErrorType(getLine(), getColumn(), "Unexpected parameters in the function invocation");
        }
        for (int i = 0; i < expressions.size(); i++) {
            if (!expressions.get(i).getType().equals(parameters.get(i).getType())) {
                new ErrorType(getLine(), getColumn(), "Unexpected parameter type in the function invocation");
            }
        }
        return returned;
    }

    @Override
    public String toString() {
        return "function";
    }

    @Override
    public Type getType() {
        return new FunctionType(this.parameters, this.returned);
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }
}
