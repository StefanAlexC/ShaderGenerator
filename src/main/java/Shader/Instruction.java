package Shader;

import Nodes.ExpressionNode;
import Nodes.VariableNode;
import java.util.LinkedList;
import java.util.List;

public class Instruction {

  private final VariableNode lhs_label;
  private final List<ExpressionNode> expressions;

  public Instruction(VariableNode lhs_label) {
    this.lhs_label = lhs_label;
    expressions = new LinkedList<ExpressionNode>();
  }

  public void addExpression(ExpressionNode expression) {
    expressions.add(expression);
  }

  public VariableNode getLhs_label() {
    return lhs_label;
  }

  @Override
  public String toString() {
    if (expressions.isEmpty()) {
      return lhs_label + " = 0.0;";
    } else {
      return lhs_label + " = " + expressions.stream().map(Object::toString).reduce((x, y) -> x +
          " + " + y).orElse("") + ";" ;
    }
  }
}
