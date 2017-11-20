package Nodes;

public class ConstantNode extends ExpressionNode {

  public static ConstantNode ConstantNodeZero = new ConstantNode(0);

  private float value;

  public ConstantNode(float value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
  }
}
