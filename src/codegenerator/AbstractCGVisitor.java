package codegenerator;

import ast.Definition;
import ast.FunctionDefinition;
import ast.Program;
import ast.VariableDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.literals.RealLiteral;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public class AbstractCGVisitor<TP, TR> extends Visitor<TP, TR> {

    CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public TR visit(FunctionDefinition ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (FuncDefinition)");
    }

    @Override
    public TR visit(VariableDefinition ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (VariableDefinition)");
    }

    @Override
    public TR visit(CharLiteral ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (CharLiteral)");
    }

    @Override
    public TR visit(IntLiteral ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (IntLiteral)");
    }

    @Override
    public TR visit(RealLiteral ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (RealLiteral)");
    }

    @Override
    public TR visit(Arithmetic ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Arithmetic)");
    }

    @Override
    public TR visit(ArrayIndexing ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (ArrayIndexing)");
    }

    @Override
    public TR visit(Cast ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Cast)");
    }

    @Override
    public TR visit(Comparison ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Comparison)");
    }

    @Override
    public TR visit(FieldAccess ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (FieldAccess)");
    }

    @Override
    public TR visit(LogicalOperation ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (LogicalOperation)");
    }

    @Override
    public TR visit(UnaryMinus ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (UnaryMinus)");
    }

    @Override
    public TR visit(UnaryNot ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (UnaryNot)");
    }

    @Override
    public TR visit(Variable ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Variable)");
    }

    @Override
    public TR visit(Assignment ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Assignment)");
    }

    @Override
    public TR visit(FunctionInvocation ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (FunctionInvocation)");
    }

    @Override
    public TR visit(If ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (If)");
    }

    @Override
    public TR visit(Input ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Input)");
    }

    @Override
    public TR visit(Print ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Print)");
    }

    @Override
    public TR visit(Return ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Return)");
    }

    @Override
    public TR visit(While ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (While)");
    }

    @Override
    public TR visit(ArrayType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (ArrayType)");
    }

    @Override
    public TR visit(CharType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (CharType)");
    }


    @Override
    public TR visit(FunctionType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (FunctionType)");
    }

    @Override
    public TR visit(IntType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (IntType)");
    }

    @Override
    public TR visit(RealType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (RealType)");
    }

    @Override
    public TR visit(RecordField ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (RecordField)");
    }

    @Override
    public TR visit(StructType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (StructType)");
    }

    @Override
    public TR visit(VoidType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (VoidType)");
    }

    @Override
    public TR visit(Program ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (Program)");
    }

    @Override
    public TR visit(ErrorType ast, TP param) {
        throw new IllegalArgumentException("Error calling a code generation visitor (ErrorType)");
    }
}
