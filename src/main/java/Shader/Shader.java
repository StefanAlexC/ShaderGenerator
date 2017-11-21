package Shader;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Shader {

  private Set<Function> functions = new HashSet<Function>();
  private List<Instruction> instructions = new LinkedList<>();
  private SymbolTable symbolTable;

  public Shader(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  public Shader addFunctionFactory(Function function) {
    functions.add(function);
    return this;
  }

  public Shader addInstructionFactory(Instruction instruction) {
    instructions.add(instruction);
    return this;
  }

  public String generateHeader() {
    return "#version 300 es\n"
        + "//Stefan Cuturela\n"
        + "\n"
        + "precision mediump float;\n"
        + "\n"
        + "out vec4 _GLF_color;\n"
        + "\n"
        + symbolTable.declareInputParameters()
        + "\n";
  }

  private String generateMainBody() {
    return "void main(void) { \n}";
  }


  private String calculatePixelValue() {
    return null;
  }

  public String getInputJson() {
    return null;
  }

  @Override
  public String toString() {
    return generateHeader()
        + functions.stream().map(x -> x.toString()).reduce(String::concat).orElse("")
        + generateMainBody();
  }
}
