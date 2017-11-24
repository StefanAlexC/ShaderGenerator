package Shader;

import Utils.Types;

public class Function {
  private Types returnType;
  private Integer numberParams;
  private String name;
  private String body;


  public Function(Types returnType, Integer numberParams, String name, String body) {
    this.returnType = returnType;
    this.numberParams = numberParams;
    this.name = name;
    this.body = body;
  }

  public String getName() {
    return name;
  }

  public Integer getNumberParams() {
    return numberParams;
  }

  @Override
  public String toString() {
    return returnType + name + "(" + returnType + " x, " + returnType + "y) {\n" + body + "}\n\n";
  }
}
