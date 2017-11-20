import static Nodes.ConstantNode.ConstantNodeZero;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import Nodes.ConstantNode;
import Nodes.ExpressionNode;
import Nodes.FunctionNode;
import Nodes.VariableNode;
import Shader.Instruction;
import org.junit.Test;

public class InstructionTests {

  private Instruction instruction = new Instruction(new VariableNode("x"));
  private FunctionNode function = new FunctionNode("sin", new ExpressionNode[]{instruction.getLhs_label(), ConstantNodeZero,
      ConstantNodeZero, ConstantNodeZero});

  @Test
  public void newInstructionEqualToZero() throws Exception {
    assertThat(instruction.toString(), is("x = 0.0;"));
  }

  @Test
  public void addInstructionTest() throws Exception {
    instruction.addExpression(function);

    assertThat(instruction.toString(), is("x = sin(x, 0.0, 0.0, 0.0);"));
  }

  @Test
  public void addMultipleExpressionsTest() throws Exception {
    instruction.addExpression(function);
    instruction.addExpression(instruction.getLhs_label());
    instruction.addExpression(ConstantNodeZero);

    assertThat(instruction.toString(), is("x = sin(x, 0.0, 0.0, 0.0) + x + 0.0;"));
  }
}
