package codegenerator;

import ast.VariableDefinition;
import ast.types.CharType;
import ast.types.IntType;
import ast.types.RealType;
import ast.types.Type;

import java.io.IOException;
import java.io.PrintWriter;

public class CodeGenerator {
    private PrintWriter out;
    private int startingLabel = 0;

    public CodeGenerator (String output, String input) {
        try {
            this.out = new PrintWriter(output);
            this.print("#source " + input);
        } catch (IOException ex) {
            System.exit(-1);
        }
    }

    public int getLabel() {
        return startingLabel++;
    }


    public void pushb(char constant) {
        out.println("\t" + "pushb" + "\t" + (int)constant);
        out.flush();
    }

    public void pushi(int constant) {
        out.println("\t" + "pushi" + "\t" + constant);
        out.flush();
    }

    public void pushf(double constant) {
        out.println("\t" + "pushf" + "\t" + constant);
        out.flush();
    }

    public void push_bp() {
        out.println("\t" + "push" + "\t" + "bp");
        out.flush();
    }

    public void load(Type type) {
        out.println("\t" + "load" + type.suffix());
        out.flush();
    }

    public void store(Type type) {
        out.println("\t" + "store" + type.suffix());
        out.flush();
    }

    public void pop(Type type) {
        out.println("\t" + "pop" + type.suffix());
        out.flush();
    }

    public void dup(Type type) {
        out.println("\t" + "dup" + type.suffix());
        out.flush();
    }

    public void add(Type type) {
        out.println("\t" + "add" + type.suffix());
        out.flush();
    }

    public void sub(Type type) {
        out.println("\t" + "sub" + type.suffix());
        out.flush();
    }

    public void mul(Type type) {
        out.println("\t" + "mul" + type.suffix());
        out.flush();
    }

    public void div(Type type) {
        out.println("\t" + "div" + type.suffix());
        out.flush();
    }

    public void mod(Type type) {
        out.println("\t" + "mod" + type.suffix());
        out.flush();
    }

    public void gt(Type type) {
        out.println("\t" + "gt" + type.suffix());
        out.flush();
    }

    public void lt(Type type) {
        out.println("\t" + "lt" + type.suffix());
        out.flush();
    }

    public void ge(Type type) {
        out.println("\t" + "ge" + type.suffix());
        out.flush();
    }

    public void le(Type type) {
        out.println("\t" + "le" + type.suffix());
        out.flush();
    }

    public void eq(Type type) {
        out.println("\t" + "eq" + type.suffix());
        out.flush();
    }

    public void ne(Type type) {
        out.println("\t" + "ne" + type.suffix());
        out.flush();
    }

    public void and() {
        out.println("\t" + "and");
        out.flush();
    }

    public void or() {
        out.println("\t" + "or");
        out.flush();
    }

    public void not() {
        out.println("\t" + "not");
        out.flush();
    }

    public void out(Type type) {
        out.println("\t" + "out" + type.suffix());
        out.flush();
    }

    public void in(Type type) {
        out.println("\t" + "in" + type.suffix());
        out.flush();
    }

    public void b2i() {
        out.println("\t" + "b2i");
        out.flush();
    }

    public void i2f() {
        out.println("\t" + "i2f");
        out.flush();
    }

    public void f2i() {
        out.println("\t" + "f2i");
        out.flush();
    }

    public void i2b() {
        out.println("\t" + "i2b");
        out.flush();
    }

    //JUMPS

    public void label(int labelNumber) {
        out.println("\t" + "label" + labelNumber + ":");
        out.flush();
    }

    public void jmp(int labelNumber) {
        out.println("\t" + "jmp " + "label" + labelNumber);
        out.flush();
    }

    public void jz(int labelNumber) {
        out.println("\t" + "jz " + "label" + labelNumber);
        out.flush();
    }

    public void jnz(int labelNumber) {
        out.println("\t" + "jnz " + "label" + labelNumber);
        out.flush();
    }

    //FUNCTIONS

    public void enter(int constant) {
        out.println("\t" + "enter" + "\t" + constant);
        out.flush();
    }

    public void ret(int bytesToReturn, int bytesLocalVariables, int bytesAllArguments) {
        out.println("\t" + "ret" + "\t" + bytesToReturn + "," + bytesLocalVariables + "," + bytesAllArguments);
        out.flush();
    }

    public void call(String function){
        out.println("\t" + "call" + "\t" + function);
        out.flush();
    }

    public void halt() {
        out.println("\t" + "halt");
        out.flush();
    }

    public void varDefinition(VariableDefinition definition) {
        out.println("\t" + "' * " + definition.getType().toString() + " " + definition.getName() + " (offset " + definition.getOffset() + ")");
    }

    public void comment(String toBePrinted) {
        out.println("' * " + toBePrinted);
    }

    public void print(String toBePrinted) {
        out.println(toBePrinted);
    }
    public void printNewLine() {
        out.println();
    }

    public void convert(Type wantsToPromote, Type promotedType) {
        if ((wantsToPromote instanceof RealType && promotedType instanceof CharType) || (wantsToPromote instanceof  CharType && promotedType instanceof RealType)) {
            this.b2i();
            this.i2f();
        } else if (wantsToPromote instanceof IntType && promotedType instanceof RealType) {
            this.i2f();
        }  else if (wantsToPromote instanceof RealType && promotedType instanceof IntType) {
            this.f2i();
        }  else if (wantsToPromote instanceof IntType && promotedType instanceof CharType) {
            this.i2b();
        } else if (wantsToPromote instanceof CharType && promotedType instanceof IntType) {
            this.b2i();
        }
    }
}
