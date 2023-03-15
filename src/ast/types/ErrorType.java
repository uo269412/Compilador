package ast.types;

import ast.ASTNode;
import ast.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType implements ASTNode{
	String message;
	int line;
	int column;

    @Override
    public Type getType() {
        return new ErrorType(line, column, message);
    }

	@Override
	public int numberOfBytes(){
		try {
			throw new Exception("Can't compute offset of an error type");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return -1;
	}

	public ErrorType(int line, int column, String message) {
		this.line = line;
		this.column = column;
		this.message = message;
		ErrorHandler.getInstance().addError(this);
	}
	
	public String toString() {
		return "In line " + line + " at column " + column + " an error has occured: " + message;
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
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameters) {
		return visitor.visit(this, parameters);
	}
}