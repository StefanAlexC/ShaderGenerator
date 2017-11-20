package Shader;

import Nodes.ExpressionNode;
import java.util.List;

public class Instruction {

  String lhs_label;
  List<ExpressionNode> expressions;

  public Instruction(String lhs_label, List<ExpressionNode> expressions) {
    this.lhs_label = lhs_label;
    this.expressions = expressions;
  }

  @Override
  public String toString() {
    return lhs_label + " = " + expressions.stream().map(Object::toString).reduce((x, y) -> x +
        " + ").orElse("") + ";";
  }
}
