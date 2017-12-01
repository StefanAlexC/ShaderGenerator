package Nodes;

import java.beans.Expression;
import java.util.Arrays;

public class FunctionNode extends ExpressionNode{

  private ExpressionNode[] parameters = new ExpressionNode[4];
  private String functionName;


  public FunctionNode(String functionName, ExpressionNode[] parameters) {
    this.functionName = functionName;
    this.parameters = parameters;
  }

  @Override
  public String toString() {
    String result = functionName + "("
        + parameters[0].toString() + ", "
        + parameters[1].toString() + ", "
        + parameters[2].toString() + ", "
        + parameters[3].toString() + ")";
/*    return functionName + "(" + Arrays.stream(parameters).map(Object::toString).reduce((x, y) ->
        x + ", " + y).orElse("") + ")";*/
    return result;
  }
}
