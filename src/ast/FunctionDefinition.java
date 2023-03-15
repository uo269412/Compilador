package ast;

import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {
    public List<VariableDefinition> localVariables;
    public List<Statement> statements;
    int bytesLocal;
    int bytesParam;

    public FunctionDefinition(int line, int column, String name, Type returnType, List<VariableDefinition> variables, List<Statement> statements) {
        super(line,column, name, returnType);
        this.localVariables = variables;
        this.statements = statements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

    @Override
    public int getOffset() {
        return -1;
    }

    public void setBytesLocal(int bytesLocal) {
        this.bytesLocal = bytesLocal;
    }

    public void setBytesParam(int bytesParam) {
        this.bytesParam = bytesParam;
    }

    public int getBytesLocal() {
        return bytesLocal;
    }

    public int getBytesParam() {
        return bytesParam;
    }
}
