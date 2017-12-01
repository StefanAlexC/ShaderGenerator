package InputGenerator;

import Json.InputArg;
import Utils.Types;

public interface InputGenerator {
  InputArg generateArgument(String name, Types type);
}
