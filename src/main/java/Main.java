import InstructionGenerators.BasicFloatInstructionGenerator;
import Shader.PredefinedFunctions;
import Shader.Shader;
import Shader.SymbolTable;
import Utils.Types;
import java.io.IOException;
import java.util.PriorityQueue;


public class Main {

  public static double randomOffset(double number) {
    return (number - 0.5) * 200.0;
  }

  public static void main(String[] args) throws IOException {
    SymbolTable symbolTable = new SymbolTable();

    Shader shader = new Shader(symbolTable).addFunctionFactory(PredefinedFunctions.distanceX)
        .addFunctionFactory(PredefinedFunctions.distanceY)
        .addFunctionFactory(PredefinedFunctions.getColorFromX)
        .addFunctionFactory(PredefinedFunctions.modulo)
        .addFunctionFactory(PredefinedFunctions.distanceY);

    symbolTable.addUnmodifiableEntry("hello", Types.FLOAT);
    symbolTable.addUnmodifiableEntry("point", Types.VEC2);
    symbolTable.addUnmodifiableEntry("circle", Types.VEC3);
    symbolTable.addUnmodifiableEntry("square", Types.VEC4);

    BasicFloatInstructionGenerator generator = new BasicFloatInstructionGenerator(shader);

    for (int i = 0; i < 6; i++) {
      shader.addInstructionFactory(generator.generateInstruction());
    }

    System.out.println(shader.toString());
    System.out.println("-------------------------------------------------------------");
    System.out.println(shader.getInputJson());

  }
}
