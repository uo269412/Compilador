package ast;

import visitor.Visitor;

import java.util.List;

public class Program implements ASTNode {
    int line;
    int column;
    //List<Expression> expressions;
    //List<Statement> statements;
    public List<Definition> definitions;


    public Program(int line, int column, List<Definition> definitions) {
        this.line = line;
        this.column = column;
        this.definitions = definitions;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public Program accept(Visitor visitor, Object parameters) {
        visitor.visit(this, parameters); return null;
    }


}
