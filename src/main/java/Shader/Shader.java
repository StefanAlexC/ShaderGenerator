package Shader;

import InputGenerator.BasicInputGenerator;
import InputGenerator.InputGenerator;
import Json.GLTypes;
import Json.InputArg;
import Json.InputArg.Values;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Shader {

  private Set<Function> functions = new HashSet<Function>();
  private List<Instruction> instructions = new LinkedList<>();
  private List<InputArg> inputArgs;
  private SymbolTable symbolTable;

  public Set<Function> getFunctions() {
    return functions;
  }

  public SymbolTable getSymbolTable() {
    return symbolTable;
  }

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
    return "void main(void) {\n"
        + instructions.stream().map(x -> "  " + x.toString() + "\n").reduce(String::concat)
        .orElse("")
        + "}";
  }

  private String calculatePixelValue() {
    return null;
  }

  public String getInputJson() {
    InputGenerator inputGenerator = new BasicInputGenerator();
    InputArg resolution = new InputArg("resolution", new Values(GLTypes.glUniform2f, new
        ArrayList<Double>() {{
          add(256.0);
          add(256.0);
        }}));

    return InputArg.toStringListJson(symbolTable.getModifiableList().map(x ->
        x.getKey().equals("resolution") ? resolution :
        inputGenerator.generateArgument(x.getKey(), x.getValue())).collect(Collectors.toList()));
  }

  @Override
  public String toString() {
    return generateHeader()
        + functions.stream().map(x -> x.toString()).reduce(String::concat).orElse("")
        + generateMainBody();
  }
}
