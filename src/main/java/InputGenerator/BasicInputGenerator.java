package InputGenerator;

import Json.GLTypes;
import Json.InputArg;
import Json.InputArg.Values;
import Utils.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicInputGenerator implements InputGenerator {

  private static final int doubleSoftCap = 30;

  @Override
  public InputArg generateArgument(String name, Types type) {
    Values value = new Values(typeToGLType(type), generateValue(type));

    switch (type) {
      case FLOAT:
    }

    return new InputArg(name, value);
  }

  private static GLTypes typeToGLType(Types type) {
    //TODO: Add new types
    switch (type) {
      case FLOAT:
        return GLTypes.glUniform1f;
      case VEC2:
        return GLTypes.glUniform2f;
      case VEC3:
        return GLTypes.glUniform3f;
      case VEC4:
        return GLTypes.glUniform4f;
      default:
        System.err.println("Type not supported yet");
        return null;
    }
  }

  private static List<Double> generateValue(Types type) {
    int numberArguments = numberOfFields(type);
    List<Double> result = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < numberArguments; i++) {
      result.add(random.nextDouble() * random.nextInt(30));
    }

    return result;
  }

  private static int numberOfFields(Types type) {
    switch (type) {

      case FLOAT:
        return 1;
      case VEC2:
        return 2;
      case VEC3:
        return 3;
      case VEC4:
        return 4;
      default:
        System.err.println("Type not supported yet");
        return -1;
    }
  }
}
