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

  public static Function modulo = new Function(Types.FLOAT, 2, "modulo",
      new StringBuilder().append("  return mod(x, y);\n").toString());
}
