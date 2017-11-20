package Nodes;

public class VariableNode extends ExpressionNode {

  String name;

  public VariableNode(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
