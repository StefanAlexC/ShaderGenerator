import Shader.Shader;
import Shapes.CircleBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Main {

  public static double randomOffset(double number) {
    return (number - 0.5) * 200.0;
  }

  public static void main(String[] args) throws IOException {


    for (int k = 0; k < 1; k++) {
      Shader shader = new Shader();
      Random generator = new Random(k * 1203982123 % 213144123);

      for (int i = 0; i < 600; i++) {
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
    }
  }
}
