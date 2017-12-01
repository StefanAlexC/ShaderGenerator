import InstructionGenerators.BasicFloatInstructionGenerator;
import Shader.PredefinedFunctions;
import Shader.Shader;
import Shader.SymbolTable;
import Utils.Types;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;


public class Main {

  private static Types randomType(int x) {
    switch (x) {
      case 0: return Types.FLOAT;
      case 1: return Types.VEC2;
      case 2: return Types.VEC3;
      case 3: return Types.VEC4;
    }
    //TODO: Update for other types
    return Types.FLOAT;
  }

  public static void main(String[] args) throws IOException {
    SymbolTable symbolTable = new SymbolTable();
    String modifiable = "modifiable";
    String unmodifiable = "unmodifiable";
    Random random = new Random();

    Shader shader = new Shader(symbolTable).addFunctionFactory(PredefinedFunctions.distanceX)
        .addFunctionFactory(PredefinedFunctions.distanceY)
        .addFunctionFactory(PredefinedFunctions.getColorFromX)
        .addFunctionFactory(PredefinedFunctions.modulo)
        .addFunctionFactory(PredefinedFunctions.distanceY);

    for (int i = 0; i < 4; i++) {
      symbolTable.addUnmodifiableEntry(unmodifiable + i, randomType(random.nextInt(4)));
    }

    for (int i = 0; i < 3; i++) {
      symbolTable.addModifiableEntry(modifiable + i, randomType(random.nextInt(4)));
    }

    BasicFloatInstructionGenerator generator = new BasicFloatInstructionGenerator(shader);

    for (int i = 0; i < 30 + random.nextInt(20); i++) {
      shader.addInstructionFactory(generator.generateInstruction());
    }

    System.out.println(shader.toString());
    System.out.println("-------------------------------------------------------------");
    System.out.println(shader.getInputJson());

  }
}
