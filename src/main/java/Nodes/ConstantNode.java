package Nodes;

public class ConstantNode extends ExpressionNode {

  private float value;

  public ConstantNode(float value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
  }
}
