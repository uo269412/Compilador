package codegenerator;

import ast.expressions.ArrayIndexing;
import ast.expressions.FieldAccess;
import ast.expressions.Variable;
import ast.types.IntType;
import ast.types.StructType;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void>{

    ValueCGVisitor value;

    public AddressCGVisitor(CodeGenerator cg, ValueCGVisitor value) {
        super(cg);
        this.value = value;
    }

    /*
    address[[Variable : expression -> ID]] () =
        if (expression.definition.scope == 0) {
            <pushi> expression.definition.offset
        } else {
            <push bp>
            <pushi> expression.definition.offset
            <addi>
        }
     */
    @Override
    public Void visit(Variable ast, Void param) {
        if (ast.getDefinition().getScope() == 0) { //GLOBAL
            cg.pushi(ast.getDefinition().getOffset());
        } else { //LOCAL
            cg.push_bp();
            cg.pushi(ast.getDefinition().getOffset());
            cg.add(IntType.getTypeInt());
        }
        return null;
    }

    /*
         address[[ArrayIndexing : expression -> expression1 expression2]] () =
             address[[expression1]]
             value[[expression2]]
             <pushi>expression.type.numberOfBytes();
             <muli>
             <addi>
      */
    @Override
    public Void visit(ArrayIndexing ast, Void param) {
        ast.expression1.accept(this, param);
        ast.expression2.accept(value, param);
        cg.pushi(ast.getType().numberOfBytes());
        cg.mul(IntType.getTypeInt());
        cg.add(IntType.getTypeInt());
        return null;
    }

    /*
        address[[FieldAccess: expression -> expression1 ID]] () =
            address[[expression1]]
            <pushi>expression1.type.getRecord(expression1.name).offset
            <addi>
     */
    @Override
    public Void visit(FieldAccess ast, Void param) {
        ast.expression.accept(this, param);
        cg.pushi(((StructType) ast.expression.getType()).getRecord(ast.fieldName).getOffset());
        cg.add(IntType.getTypeInt());
        return null;
    }
}
