package Nodes;

public class FunctionNodeBuilder {

  private static int argumentIndex = 0;
  private static ExpressionNode[] arguments = new ExpressionNode[]{new ConstantNode(0), new
      ConstantNode(0), new ConstantNode(0), new ConstantNode(0)};
  private final String functionName;

  private FunctionNodeBuilder(String functionName) {
    this.functionName = functionName;
  }

  public static FunctionNodeBuilder aFunctionNode(String functionName) {
    return new FunctionNodeBuilder(functionName);
  }

  public FunctionNode build() {
    return new FunctionNode(functionName, arguments);
  }

  public FunctionNodeBuilder withParam(ExpressionNode expressionNode) {
    arguments[argumentIndex++ % 4] = expressionNode;
    return this;
  }

}
