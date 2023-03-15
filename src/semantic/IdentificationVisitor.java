package semantic;

import ast.ASTNode;
import ast.FunctionDefinition;
import ast.Program;
import ast.VariableDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.literals.RealLiteral;
import ast.statements.*;
import ast.types.*;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(FunctionDefinition ast, Void param) {
        if (st.find(ast.getName()) != null) {
            new ErrorType(ast.getLine(), ast.getColumn(), "Function " + ast.getName() + " is already defined");
        } else {
            st.insert(ast);
        }
        st.set();
        super.visit(ast, null);
        st.reset();
        return null;
    }

    @Override
    public Void visit(VariableDefinition ast, Void param) {
        if (!st.insert(ast)) {
            new ErrorType(ast.getLine(), ast.getColumn(), "Variable " + ast.getName() + " is already defined in the scope");
        }
        return null;
    }

    @Override
    public Void visit(Variable ast, Void param) {
        if (st.find(ast.getText()) != null) {
            ast.setDefinition(st.find(ast.getText()));
        } else {
            new ErrorType(ast.getLine(), ast.getColumn(), "Variable " + ast.getText() + " is not defined");
        }
        return null;
    }

}
