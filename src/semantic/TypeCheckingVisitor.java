package semantic;

import ast.ASTNode;
import ast.Definition;
import ast.Program;
import ast.FunctionDefinition;
import ast.VariableDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.literals.RealLiteral;
import ast.statements.*;
import ast.types.*;
import ast.types.ErrorType;
import visitor.AbstractVisitor;
import visitor.Visitor;

public class TypeCheckingVisitor extends AbstractVisitor<Object, ASTNode> {

    private FieldAccess ast;

    @Override
    public FunctionDefinition visit(FunctionDefinition ast, Object param) {
        ast.getType().accept(this, param);
        Type returnType = ((FunctionType) ast.getType()).returned;
        for (Statement st : ast.statements) {
            st.accept(this, returnType);
        }
        return null;
    }

    @Override
    public VariableDefinition visit(VariableDefinition ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public CharLiteral visit(CharLiteral ast, Object param) {
        super.visit(ast, param);
        ast.setType(CharType.getTypeChar());
        return null;
    }

    @Override
    public IntLiteral visit(IntLiteral ast, Object param) {
        super.visit(ast, param);
        ast.setType(IntType.getTypeInt());
        return null;
    }

    @Override
    public RealLiteral visit(RealLiteral ast, Object param) {
        super.visit(ast, param);
        ast.setType(RealType.getTypeReal());
        return null;
    }

    @Override
    public Arithmetic visit(Arithmetic ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.expression1.getType().arithmetic(ast, ast.expression2.getType()));
        return null;
    }

    @Override
    public ArrayIndexing visit(ArrayIndexing ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(ast.expression1.islValue());
        ast.setType(ast.expression1.getType().squareBrackets(ast, ast.expression2.getType()));
        return null;
    }

    @Override
    public Cast visit(Cast ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(ast.expression.islValue());
        ast.setType(ast.expression.getType().canBeCastTo(ast, ast.type));
        return null;
    }

    @Override
    public Comparison visit(Comparison ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.expression1.getType().comparison(ast, ast.expression2.getType()));
        return null;
    }

    @Override
    public FieldAccess visit(FieldAccess ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(ast.expression.islValue());
        ast.setType(ast.expression.getType().dot(ast, ast.fieldName));
        return null;
    }

    @Override
    public LogicalOperation visit(LogicalOperation ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.expression1.getType().logic(ast.expression2, ast.expression2.getType()));
        return null;
    }

    @Override
    public UnaryMinus visit(UnaryMinus ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.expression.getType().arithmetic(ast.expression));
        return null;
    }

    @Override
    public UnaryNot visit(UnaryNot ast, Object param) {
        super.visit(ast, param);
        ast.setLValue(false);
        ast.setType(ast.expression.getType().logic(ast.expression));
        return null;
    }

    @Override
    public Variable visit(Variable ast, Object param) {
        ast.setLValue(true);
        ast.setType(ast.getDefinition().getType());
        return null;
    }

    @Override
    public Assignment visit(Assignment ast, Object param) {
        super.visit(ast, param);
        if (!ast.expression1.islValue()) {
            ast.expression1.setType(new ErrorType(ast.expression1.getLine(), ast.expression1.getColumn(), "The left side expression is not a lvalue"));
        }
        ast.setType(ast.expression2.getType().promotesTo(ast, ast.expression1.getType()));
        return null;
    }

    @Override
    public FunctionInvocation visit(FunctionInvocation ast, Object param) {
        super.visit(ast, param);
        ast.setType(ast.variable.getType().parenthesis(ast, ast.expressions));
        return null;
    }

    @Override
    public If visit(If ast, Object param) {
        super.visit(ast, param);
        ast.setType(ast.expression.getType().isLogical(ast.expression));
        return null;
    }

    @Override
    public Input visit(Input ast, Object param) {
        super.visit(ast, param);
        if (!ast.exp.islValue()) {
            ast.exp.setType(new ErrorType(ast.exp.getLine(), ast.exp.getColumn(), "The input we want to introduce is not a lvalue"));
        }
        return null;
    }

    @Override
    public Print visit(Print ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public Return visit(Return ast, Object param) {
        super.visit(ast, param);
        if (ast.exp.getType().promotesTo(ast.exp, (Type) param) == null) {
            ast.exp.setType(new ErrorType(ast.exp.getLine(), ast.exp.getColumn(), "A return statement with the especified return type was expected"));
        }
        return null;
    }

    @Override
    public While visit(While ast, Object param) {
        super.visit(ast, param);
        ast.setType(ast.expression.getType().isLogical(ast.expression));
        return null;
    }

    @Override
    public ArrayType visit(ArrayType ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public CharType visit(CharType ast, Object param) {
        return null;
    }


    @Override
    public FunctionType visit(FunctionType ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public IntType visit(IntType ast, Object param) {
        return null;
    }

    @Override
    public RealType visit(RealType ast, Object param) {
        return null;
    }

    @Override
    public RecordField visit(RecordField ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public StructType visit(StructType ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public VoidType visit(VoidType ast, Object param) {
        return null;
    }

    @Override
    public Program visit(Program ast, Object param) {
        super.visit(ast, param);
        return null;
    }

    @Override
    public ErrorType visit(ErrorType ast, Object param) {
        super.visit(ast, param);
        return null;
    }
}
