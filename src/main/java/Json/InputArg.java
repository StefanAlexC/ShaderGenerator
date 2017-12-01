package Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.List;

public class InputArg {

  //TODO: Extend to Arrays

  /**
   * resolution : {"func":"glUniform2f","args":[256,256]}
   */

  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final String name;
  private final Values value;

  public InputArg(String name, Values value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Values getValue() {
    return value;
  }

  public String toJsonString() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add(name, gson.toJsonTree(value));
    String string = gson.toJson(jsonObject);
    return string.substring(2, string.length() - 2);
  }

  public static String toStringListJson(List<InputArg> objects) {
    return "{\n" + objects.stream().map(InputArg::toJsonString).reduce((x, y) -> x + ",\n" + y)
        .orElse
        ("") + "\n}";
  }

  public static class Values {

    public Values(GLTypes func, List<Double> args) {
      this.func = func;
      this.args = args;
    }

    /**
     * func : glUniform2f args : [256,256]
     */

    private GLTypes func;
    private List<Double> args;

    public GLTypes getFunc() {
      return func;
    }

    public void setFunc(GLTypes func) {
      this.func = func;
    }

    public List<Double> getArgs() {
      return args;
    }

    public void setArgs(List<Double> args) {
      this.args = args;
    }
  }
}
