package visitor;

import ast.Program;
import ast.FunctionDefinition;
import ast.VariableDefinition;
import ast.expressions.*;
import ast.expressions.literals.*;
import ast.statements.*;
import ast.types.*;
import ast.types.ErrorType;

public abstract class Visitor<TP, TR> {
    public abstract TR visit(FunctionDefinition ast, TP param);
    public abstract TR visit(VariableDefinition ast, TP param);
    public abstract TR visit(CharLiteral ast, TP param);
    public abstract TR visit(IntLiteral ast, TP param);
    public abstract TR visit(RealLiteral ast, TP param);
    public abstract TR visit(Arithmetic ast, TP param);
    public abstract TR visit(ArrayIndexing ast, TP param);
    public abstract TR visit(Cast ast, TP param);
    public abstract TR visit(Comparison ast, TP param);
    public abstract TR visit(FieldAccess ast, TP param);
    public abstract TR visit(LogicalOperation ast, TP param);
    public abstract TR visit(UnaryMinus ast, TP param);
    public abstract TR visit(UnaryNot ast, TP param);
    public abstract TR visit(Variable ast, TP param);
    public abstract TR visit(Assignment ast, TP param);
    public abstract TR visit(FunctionInvocation ast, TP param);
    public abstract TR visit(If ast, TP param);
    public abstract TR visit(Input ast, TP param);
    public abstract TR visit(Print ast, TP param);
    public abstract TR visit(Return ast, TP param);
    public abstract TR visit(While ast, TP param);
    public abstract TR visit(ArrayType ast, TP param);
    public abstract TR visit(CharType ast, TP param);
    public abstract TR visit(FunctionType ast, TP param);
    public abstract TR visit(IntType ast, TP param);
    public abstract TR visit(RealType ast, TP param);
    public abstract TR visit(RecordField ast, TP param);
    public abstract TR visit(StructType ast, TP param);
    public abstract TR visit(VoidType ast, TP param);
    public abstract TR visit(Program ast, TP param);
    public abstract TR visit(ErrorType ast, TP param);








}
