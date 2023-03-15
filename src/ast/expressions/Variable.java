package ast.expressions;

import ast.Definition;
import visitor.Visitor;

public class Variable extends AbstractExpression{
    String text;
    Definition definition;

    public Variable(String name) {
        super();
        this.text = name;
    }

    public Variable(int line, int column, String name) {
        super(line, column);
        this.text = name;
    }

    public Variable(int line, int column, String name, Definition definition) {
        this(line, column, name);
        this.definition = definition;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
