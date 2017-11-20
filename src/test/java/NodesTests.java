import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import Nodes.ConstantNode;
import Nodes.ExpressionNode;
import Nodes.FunctionNode;
import Nodes.VariableNode;
import org.junit.Test;

public class NodesTests {

  @Test
  public void createVariableNodeTest() {
    VariableNode variable = new VariableNode("variable");

    assertThat(variable.toString(), is("variable"));
  }

  @Test
  public void createConstantNodeTest() {
    ConstantNode constant = new ConstantNode(0);

    assertThat(constant.toString(), is("0.0"));
  }

  @Test
  public void createFunctionNodeTest() {
    FunctionNode function = new FunctionNode("sin", new ExpressionNode[]{new VariableNode("x"),
    new VariableNode("y"), new ConstantNode(0), new ConstantNode(1)});

    assertThat(function.toString(), is("sin(x, y, 0.0, 1.0)"));
  }
}
