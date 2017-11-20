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
    return functionName + "(" + Arrays.stream(parameters).map(Object::toString).reduce((x, y) ->
        x + ", " + y).orElse("") + ")";
  }
}
