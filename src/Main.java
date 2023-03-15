import ast.ErrorHandler;
import codegenerator.CodeGenerator;
import codegenerator.ExecuteCGVisitor;
import codegenerator.OffsetVisitor;
import parser.*;

import org.antlr.v4.runtime.*;

import ast.Program;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;
import visitor.Visitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		PmmParser parser = new PmmParser(tokens);	
		Program ast = parser.program().ast;

		Visitor identificationVisitor = new IdentificationVisitor();
		ast.accept(identificationVisitor, null);

		Visitor typeCheckingVisitor = new TypeCheckingVisitor();
		ast.accept(typeCheckingVisitor, null);
		
		// * Check errors 
		if(ErrorHandler.getInstance().anyError()){
			// * Show errors
			ErrorHandler.getInstance().showErrors(System.err);
		}
		else{
			// Code generation
			Visitor offsetVisitor = new OffsetVisitor();
			ast.accept(offsetVisitor, null);

			Visitor executeVisitor = new ExecuteCGVisitor(new CodeGenerator(args[1], args[0]));
			ast.accept(executeVisitor, null);

			// * The AST is shown
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorTree("Introspector", model);
		}		
	}
}
