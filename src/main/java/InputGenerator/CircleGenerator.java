package InputGenerator;

import Json.GLTypes;
import Json.InputArg;
import Json.InputArg.Values;
import Utils.Types;
import java.util.ArrayList;
import java.util.Random;

public class CircleGenerator implements InputGenerator{

  private static final Random random = new Random();
  private final int resolution = 256;
  private final int radiusCap = 50;

  @Override
  public InputArg generateArgument(String name, Types type) {
    return new InputArg(name, new Values(GLTypes.glUniform3f, new ArrayList<Double>(){{
      add(random.nextDouble() * 256);
      add(random.nextDouble() * 256);
      add(random.nextDouble() * random.nextInt());
    }}));
  }
}
