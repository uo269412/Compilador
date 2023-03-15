package ast.types;

import ast.ASTNode;
import visitor.Visitor;

public class ArrayType extends AbstractType{

    int line;
    int column;
    int size;
    public Type type;

    public ArrayType(int line, int column, int size, Type type) {
        this.line = line;
        this.column = column;
        this.size = size;
        this.type = type;
    }


    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public Type squareBrackets(Type other) {
        if (other instanceof IntType) {
            return type;
        }
        return null;
    }

    @Override
    public Type squareBrackets(ASTNode node, Type type) {
        if (type.equals(IntType.getTypeInt())) {
            return this.type;
        } else if (type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(node.getLine(), node.getColumn(), "You are trying to index an array with a type that is not an integer");
    }

    @Override
    public String toString() {
        return "array";
    }


    @Override
    public int numberOfBytes(){
        return size * type.numberOfBytes();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
        return visitor.visit(this, parameters);
    }

    @Override
    public Type getType() {
        return type;
    }
}
