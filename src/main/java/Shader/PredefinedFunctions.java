package Shader;

import Utils.Types;

public class PredefinedFunctions {

  public static Function distanceX = new Function(Types.FLOAT, 1,"distanceX", new StringBuilder
      ().append("  float temp = x - gl_FragCoord.x;\n").append("  float tempSq = temp * temp;\n")
      .append("  return sqrt(tempSq);\n").toString());

  public static Function distanceY = new Function(Types.FLOAT, 1,"distanceY", new StringBuilder
      ().append("  float temp = x - gl_FragCoord.y;\n").append("  float tempSq = temp * temp;\n")
      .append("  return sqrt(tempSq);\n").toString());

  public static Function getColorFromX = new Function(Types.FLOAT, 2,"colorFromX", new
      StringBuilder
      ().append("  float temp = x - gl_FragCoord.x;\n").append("  float tempSq = temp * temp;\n")
      .append("  return sqrt(tempSq);\n").toString());

  public static Function modulo1 = new Function(Types.FLOAT, 2, "modulo1",
      new StringBuilder().append("  return mod(x, y);\n").toString());

  public static Function modulo2 = new Function(Types.FLOAT, 3, "modulo2",
      new StringBuilder().append("  return mod(x + z, y);\n").toString());

  public static Function modulo3 = new Function(Types.FLOAT, 4, "modulo3",
      new StringBuilder().append("  return mod(x + w + y, y / z);\n").toString());

  public static Function function1 = new Function(Types.FLOAT, 4, "function1",
      new StringBuilder().append("  return (x * z + y * w) / (x / y * z);\n").toString());

  public static Function function2 = new Function(Types.FLOAT, 4, "function2",
      new StringBuilder().append("  return (x * z * x + y * w) / (x / w / y * z);\n").toString());

  public static Function function3 = new Function(Types.FLOAT, 4, "function3",
      new StringBuilder().append("  return (y * z + y * w) / (w / z * x);\n").toString());

  public static Function function4 = new Function(Types.FLOAT, 4, "function4",
      new StringBuilder().append("  return (x + z + y + w - x - x) * (x / y * z);\n").toString());

  public static Function function5 = new Function(Types.FLOAT, 4, "function5",
      new StringBuilder().append("  return (x * z * y * w) / (x / y * z / x / x / x);\n").toString
          ());
}
