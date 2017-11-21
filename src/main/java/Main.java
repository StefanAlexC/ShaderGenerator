import Shader.PredefinedFunctions;
import Shader.Shader;
import Shader.SymbolTable;
import java.io.IOException;


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

    System.out.println(shader.toString());
  }
}
