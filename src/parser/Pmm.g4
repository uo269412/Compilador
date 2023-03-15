grammar Pmm;
@header{
import ast.*;
import ast.expressions.*;
import ast.expressions.literals.*;
import ast.statements.*;
import ast.types.*;
}

program returns [Program ast] locals [List<Definition> definitions = new ArrayList<Definition>()]:
    (def=definition { $definitions.addAll($def.ast); })* { $ast = new Program(0 ,0 , $definitions); }
    EOF
    ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]:
    fun=function_definition { $ast.add($fun.ast); }
    | var=variable_definition { $ast.addAll($var.ast); }
    ;

expression returns [Expression ast]:
      INT_CONSTANT { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
    | REAL_CONSTANT { $ast = new RealLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine() + 1 , LexerHelper.lexemeToReal($REAL_CONSTANT.text)); }
    | CHAR_CONSTANT { $ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine() + 1 , LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
    | ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1 ,$ID.text); }
    |   '(' exp=expression ')'{ $ast = $exp.ast; }
    | '[' exp=expression ']' { $ast = $exp.ast; }
    | exp1=expression '[' exp2=expression ']' { $ast = new ArrayIndexing($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast); }
    | exp=expression '.' ID { $ast = new FieldAccess($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $ID.text); }
    | '(' typ=type ')' exp=expression { $ast = new Cast($exp.ast.getLine(), $exp.ast.getColumn(), $typ.ast, $exp.ast); }
    | '-' exp=expression { $ast = new UnaryMinus($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
    | '!' exp=expression { $ast = new UnaryNot($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }
    | exp1=expression OP=('*'|'/'|'%') exp2=expression { $ast = new Arithmetic($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $OP.text, $exp2.ast); }
    | exp1=expression OP=('+'|'-') exp2=expression { $ast = new Arithmetic($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $OP.text, $exp2.ast); }
    | exp1=expression OP=('>'|'<'|'>='|'<='|'!='|'==') exp2=expression { $ast = new Comparison($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $OP.text, $exp2.ast); }
    | exp1=expression OP=('&&'|'||') exp2=expression { $ast = new LogicalOperation($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $OP.text, $exp2.ast); }
    | fu=function_invocation { $ast = $fu.ast; }
    ;


statement returns [List<Statement> ast = new ArrayList<Statement>()] locals [List<Statement> statementsElse = new ArrayList<Statement>()]:
      <assoc = right> exp1=expression '=' exp2=expression ';' { $ast.add(new Assignment($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast)); }
    | 'while' exp=expression ':' bl=block { $ast.add(new While($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $bl.ast)); }
    |  'if'  exp=expression ':' bl1=block ('else' bl2=block { $statementsElse = $bl2.ast; } )? { $ast.add(new If($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $bl1.ast, $statementsElse)); }
    | fu=function_invocation ';' { $ast.add($fu.ast); }
    | 'return' exp=expression ';' { $ast.add(new Return($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast)); }
    | 'input' exp1=expression { $ast.add(new Input($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast)); } (',' exp2=expression { $ast.add(new Input($exp2.ast.getLine(), $exp2.ast.getColumn(), $exp2.ast)); })* ';'
    | 'print' exp1=expression { $ast.add(new Print($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast)); } (',' exp2=expression { $ast.add(new Print($exp2.ast.getLine(), $exp2.ast.getColumn(), $exp2.ast)); })* ';'
    ;

block returns [List<Statement> ast = new ArrayList<Statement>()]:
    (st1=statement { $ast.addAll($st1.ast); } ) | '{' (st2=statement { $ast.addAll($st2.ast); } )* '}'
    ;

function_invocation returns [FunctionInvocation ast] locals [List<Expression> expressions = new ArrayList<Expression>()]:
        id=ID '(' ( exp1=expression { $expressions.add($exp1.ast); } (',' exp2=expression { $expressions.add($exp2.ast); } )* )? ')' { $ast = new FunctionInvocation($id.getLine(), $id.getCharPositionInLine() + 1, new Variable($id.getLine(), $id.getCharPositionInLine() + 1 ,$id.text), $expressions); }
    ;

variable_definition returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
       (identifiers=multiple_ids_definitions ':' ty=type ';' { for (String identifier : $identifiers.ast) { $ast.add(new VariableDefinition($identifiers.start.getLine(), $identifiers.start.getCharPositionInLine(), identifier, $type.ast)); } } )
    ;

multiple_ids_definitions returns [List<String> ast = new ArrayList<String>()]:
       id1=ID { $ast.add($id1.text); } (',' id2=ID {
	   if (!$ast.contains($id2.text)) {
	        $ast.add($id2.text);
	   } else {
		    ErrorType et = new ErrorType($id2.getLine(), $id2.getCharPositionInLine() + 1, "ID with text " + $id2.text + " has already been defined.");
	   }
	   })*
    ;

// function_definition returns [FunctionDefinition ast] locals [List<VariableDefinition> parametersp = new ArrayList<VariableDefinition>(), Type return_typep = new VoidType(), List<VariableDefinition> variablesp = new ArrayList<VariableDefinition>(), List<Statement> statementsp = new ArrayList<Statement>()]:
//      'def' id=ID '(' (id1=ID ':' typ1=type  { $variablesp.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine(), $id1.text, $typ1.ast)); }
//      (',' id2=ID ':' typ2=type  { $parametersp.add(new VariableDefinition($id2.getLine(), $id2.getCharPositionInLine(), $id2.text, $typ2.ast)); })* )? ')' ':'
//      (return_type=type {$return_typep = $return_type.ast;})?
//      '{' (var=variable_definition { $variablesp.addAll($var.ast); } )* (st=statement { $statementsp.addAll($st.ast); })* '}'
//      { $ast = new FunctionDefinition($id.getLine(), $id.getCharPositionInLine() + 1 ,$id.text, new FunctionType($return_typep), $variablesp, $statementsp); }
//    ;


function_definition returns [FunctionDefinition ast] locals [List<VariableDefinition> parametersp = new ArrayList<VariableDefinition>(), Type return_typep = new VoidType(), List<VariableDefinition> variablesp = new ArrayList<VariableDefinition>(), List<Statement> statementsp = new ArrayList<Statement>()]:
      'def' id=ID '(' (id1=ID ':' typ1=type  { $parametersp.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine(), $id1.text, $typ1.ast)); }
      (',' id2=ID ':' typ2=type  { $parametersp.add(new VariableDefinition($id2.getLine(), $id2.getCharPositionInLine(), $id2.text, $typ2.ast)); })* )? ')' ':'
      (return_type=type {$return_typep = $return_type.ast;})?
      '{' (var=variable_definition { $variablesp.addAll($var.ast); } )* (st=statement { $statementsp.addAll($st.ast); })* '}'
      { $ast = new FunctionDefinition($id.getLine(), $id.getCharPositionInLine() + 1 ,$id.text, new FunctionType($parametersp, $return_typep), $variablesp, $statementsp); }
    ;

type returns [Type ast]:
      terminal=terminal_types { $ast = $terminal.ast; }
    | (struct_start='struct' '{' record=record_field '}') { $ast = new StructType($struct_start.getLine(), $struct_start.getCharPositionInLine()+1, $record.ast); }
    | ('[' i_c=INT_CONSTANT ']') type { $ast = new ArrayType( $i_c.getLine(), $i_c.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($i_c.text), $type.ast); }
    ;

terminal_types returns [Type ast]:
      int_type = 'int' { $ast = IntType.getTypeInt(); }
    | real_type = 'double' { $ast = RealType.getTypeReal(); }
    | char_type = 'char' { $ast = CharType.getTypeChar(); }
    ;

record_field returns [List<RecordField> ast = new ArrayList<RecordField>(), RecordField rf = new RecordField()]:
    (identifiers=multiple_ids_definitions ':' terminal=terminal_types ';' {
    for (String identifier : $identifiers.ast) {
        $rf = new RecordField($identifiers.start.getLine(), $identifiers.start.getCharPositionInLine(), identifier, $terminal.ast);
        boolean isInTheList = false;
        for (RecordField aux : $ast) {
        	if (aux.getName().equals($rf.getName())) {
        		isInTheList = true;
        	}
        }
        if (isInTheList) {
        	ErrorType et = new ErrorType($rf.getLine(), $rf.getColumn(), "Record field with name " + $rf.getName() + " has already been defined in this struct.");
        } else {
        	$ast.add($rf);
        }
    }
    })*
    ;


//record_field returns [List<RecordField> ast = new ArrayList<RecordField>()]:
//    (identifiers=multiple_ids_definitions ':' terminal=terminal_types ';' {for (String identifier : $identifiers.ast) { $ast.add(new RecordField($identifiers.start.getLine(), $identifiers.start.getCharPositionInLine(), identifier, $terminal.ast)); } })*
//    ;

//struct_definition returns [Type ast]: ID ':' 'struct' '{' record_field'}' { $ast = new VariableDefinition($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text, $record_field.ast); }
//    ;

//array_definition returns [Type ast]: ID ':' type { $ast = new VariableDefinition($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text, $type.ast); }
//    ;

//array_access returns [List<Expression> ast = new ArrayList<Expression>()]: ('['(exp=expression) ']' { $ast.add($exp.ast); } )*
//    ;


//multiple_variable_definition returns [List<Variable> ast = new ArrayList<Variable>()]: (ID  (',' ID)* ':' type)
//    ;

//function_definition: ('def' ID '(' (multiple_variable_definition (',' multiple_variable_definition)*)* ')' ':' (array_access* TYPE)? block)
//    ;

//multiple_variable_definition returns [List<Variable> ast = new ArrayList<Variable>()]: (ID  (',' ID)* ':' array_access TYPE)
//    ;

//multiple_variable_definition returns [List<Variable> ast = new ArrayList<Variable>()]: (ID  (',' ID)* ':' type)
//    ;

//function_definition: ('def' ID '(' multiple_variable_definition? ')' ':' (array_access TYPE)? ((statement|variable_definition) | '{' (statement|variable_definition)* '}'))
//    ;

//function_definition returns [FunctionDefinition ast] locals [List<VariableDefinition> parametersp = new ArrayList<VariableDefinition>(), Type return_typep = new VoidType(), List<VariableDefinition> variablesp = new ArrayList<VariableDefinition>(), List<Statement> statementsp = new ArrayList<Statement>()]:
//      'def' id=ID '(' (id1=ID ':' typ1=type  { $parametersp.add(new VariableDefinition($id1.getLine(), $id1.getCharPositionInLine(), $id1.text, $typ1.ast)); } (',' id2=ID ':' typ2=type  { $parametersp.add(new VariableDefinition($id2.getLine(), $id2.getCharPositionInLine(), $id2.text, $typ2.ast)); })* )? ')' ':' (return_type=type {$return_typep = $return_type.ast;})?  '{' (var=variable_definition { $variablesp.addAll($var.ast); } )* (st=statement { $statementsp.addAll($st.ast); })* '}' { $ast = new FunctionDefinition($id.getLine(), $id.getCharPositionInLine() + 1 ,$id.text, $parametersp, $return_typep, $variablesp, $statementsp); }
//    ;


TRASH: (' ' | COMMENT | [\t\r\n]) -> skip
    ;

INT_CONSTANT: DIGIT+
    ;

fragment
DIGIT: [0-9]
    ;

fragment
LETTER: [a-zA-Z]
    ;

fragment
COMMENT: ('"""' .*? '"""') | ('#' .*? ( '\n' | EOF ))
    ;

TYPE: 'int'
    |'double'
    |'char'
    ;

REAL_CONSTANT: DIGIT* (( '.' DIGIT* ('E' ('+'|'-') DIGIT+ )? ) | ( 'e' DIGIT ))
    ;


ID: (LETTER| '_' ) (LETTER | DIGIT | '_' )*
    ;

CHAR_CONSTANT: QUOTATION.QUOTATION
            | QUOTATION'\\'INT_CONSTANT QUOTATION
            | QUOTATION'\\' [nt] QUOTATION
            ;

fragment QUOTATION: '\''
            ;