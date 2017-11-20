import Shader.PredefinedFunctions;
import Shader.Shader;
import java.io.IOException;


public class Main {

  public static double randomOffset(double number) {
    return (number - 0.5) * 200.0;
  }

  /*JsonObject jsonObject;
  JsonBuilderFactory jsonBuilderFactory = Json.createBuilderFactory(null);
  System.out.println(jsonBuilderFactory.createObjectBuilder()
      .add("resolution", jsonBuilderFactory.createObjectBuilder()
          .add("func", "glUniform2f")
          .add("args", jsonBuilderFactory.createArrayBuilder().add(256.0).add(256.0)))
      .add("sizes", jsonBuilderFactory.createObjectBuilder()
          .add("func", "glUniform1iv")
          .add("args", jsonBuilderFactory.createArrayBuilder().add(0.2).add
              (14.3).add(17.6).add(17.2))
          .add("count", 4))
      .add("centers", jsonBuilderFactory.createObjectBuilder()
          .add("func", "glUniform3fv")
          .add("args", jsonBuilderFactory.createArrayBuilder().add(152.32)
              .add(67.3).add(123.54).add(35.32).add(90.23).add(200.13).add
                  (201.321).add(56.2).add(217.312))
          .add("count", 4))
      .build());*/

  public static void main(String[] args) throws IOException {
    Shader shader = new Shader().addFunctionFactory(PredefinedFunctions.distanceX)
        .addFunctionFactory(PredefinedFunctions.distanceY)
        .addFunctionFactory(PredefinedFunctions.getColorFromX)
        .addFunctionFactory(PredefinedFunctions.modulo)
        .addFunctionFactory(PredefinedFunctions.distanceY);

    System.out.println(shader.toString());
  }
}
