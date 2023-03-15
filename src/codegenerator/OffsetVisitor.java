package codegenerator;

import ast.Definition;
import ast.FunctionDefinition;
import ast.Program;
import ast.VariableDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.StructType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Integer, Integer> {

    @Override
    public Integer visit(VariableDefinition ast, Integer param) {
        ast.type.accept(this, param);
        if (ast.getScope() == 0) { //VARIABLES GLOBALES
            ast.setOffset(param);
            param += ast.type.numberOfBytes();
        } else { //VARIABLES LOCALES Y PARÁMETROS
            if (param > 0) { //PARÁMETROS
                ast.setOffset(param);
                param += ast.type.numberOfBytes();
            } else { //LOCAL VARIABLES
                param -= ast.type.numberOfBytes();
                ast.setOffset(param);
            }
        }
        return param;
    }

    @Override
    public Integer visit(FunctionDefinition ast, Integer param) {
        int localNumberOfBytes = 0;
        ast.type.accept(this, localNumberOfBytes);
        for (VariableDefinition lv : ast.localVariables) {
            localNumberOfBytes = lv.accept(this, localNumberOfBytes);
        }
        for (Statement st : ast.statements) {
            st.accept(this, localNumberOfBytes);
        }
        return localNumberOfBytes;
    }

    @Override
    public Integer visit(FunctionType ast, Integer param) {
        ast.returned.accept(this, param);
        int previousSumOfParameters = 4;
        for (int i = ast.parameters.size()-1; i >= 0; i--) {
            previousSumOfParameters = ast.parameters.get(i).accept(this, previousSumOfParameters);
        }
        return previousSumOfParameters;
    }

    @Override
    public Integer visit(Program ast, Integer param) {
        int globalNumberOfBytes = 0;
        for (Definition def : ast.definitions) {
            globalNumberOfBytes = def.accept(this, globalNumberOfBytes);
        }
        return globalNumberOfBytes;
    }


    @Override
    public Integer visit(StructType ast, Integer param) {
        int numberOfBytesStruct = 0;
        for (RecordField record : ast.records) {
            numberOfBytesStruct = record.accept(this,numberOfBytesStruct);
        }
        return numberOfBytesStruct;
    }


    @Override
    public Integer visit(RecordField ast, Integer param) {
        ast.type.accept(this, param);
        ast.setOffset(param);
        param += ast.numberOfBytes();
        return param;
    }



}
