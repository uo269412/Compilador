package ast;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
	List<ErrorType> errors;
	static ErrorHandler errorHandler = new ErrorHandler();
	
	public static ErrorHandler getInstance() {
		return errorHandler;
	}

	private ErrorHandler() {
		this.errors = new ArrayList<ErrorType>();
	}
	
	public boolean anyError() {
		return !errors.isEmpty();
	}
	
	public void addError(ErrorType error) {
			errors.add(error);
	}
	
	public void showErrors(PrintStream out) {
		for (ErrorType error: errors) {
			out.println(error.toString());
		}
	}
	

}