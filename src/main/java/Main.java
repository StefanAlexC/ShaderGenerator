import java.io.IOException;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

public class Main {

  public static double randomOffset(double number) {
    return (number - 0.5) * 200.0;
  }

  public static void main(String[] args) throws IOException {


/*    for (int x;k = 0; k < 1; k++) {
      Shader shader = new Shader();
      Random generator = new Random(k * 1203982123 % 213144123);

      for (int i = 0; i < 4; i++) {
        shader.addCircle(CircleBuilder.aCircle().withSize(generator.nextInt(30)).withCenterOffset
            (randomOffset(generator.nextDouble()), randomOffset(generator.nextDouble()))
            .withGreenModifier(generator.nextDouble() - 0.3).withBlueModifier(generator
                .nextDouble())
            .withRedModifier(generator.nextDouble() + 0.20).build());
      }

      shader.setInnerCircleFrequencyCoeficient(generator.nextDouble() * 5.0);
      shader.setBackgroundColor(generator.nextDouble(), generator.nextDouble(),
          generator.nextDouble());
      shader.sortCircles();

      Files.write(Paths.get("./shaders/output" + k + ".txt"), shader.toString().getBytes());
    }*/

    JsonObject jsonObject;
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
        .build());
  }
}