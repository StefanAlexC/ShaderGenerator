package InstructionGenerators;

import Nodes.ConstantNode;
import Nodes.ExpressionNode;
import Nodes.FunctionNode;
import Nodes.FunctionNodeBuilder;
import Nodes.VariableNode;
import Shader.Function;
import Shader.Instruction;
import Shader.Shader;
import Shader.SymbolTable;
import java.util.Random;
import java.util.Set;

public class BasicFloatInstructionGenerator implements InstructionGenerator {

  private final Random randomizer = new Random(1021032132);
  private final SymbolTable symbolTable;
  private final Set<Function> functions;

  public BasicFloatInstructionGenerator(Shader shader) {
    this.symbolTable = shader.getSymbolTable();
    this.functions = shader.getFunctions();
  }

  @Override
  public Instruction generateInstruction() {
    Instruction instruction = new Instruction(chooseAssignee());

    for (int i = 0; i < 1 + randomizer.nextInt(5); i++) {
      instruction.addExpression(selectARandomExpressionNode());
    }

    return instruction;
  }

  private boolean shouldBeFunction() {
    return randomizer.nextDouble() < 0.3;
  }

  private VariableNode chooseAssignee() {
    return new VariableNode(symbolTable.getModifiableEntry(randomizer.nextInt(symbolTable
        .getModifiableFloatsLength())));
  }

  private VariableNode chooseARandomVariable() {
    return new VariableNode(symbolTable.getAEntry(randomizer.nextInt(symbolTable
        .getAllFloatsLength())));
  }

  private FunctionNode generateFunctionNode() {
    Function function = selectAFunction();
    FunctionNodeBuilder builder = FunctionNodeBuilder.aFunctionNode(function.getName());

    for (int i = 0; i < function.getNumberParams(); i++) {
      builder.withParam(selectARandomArgumentNode());
    }

    return builder.build();
  }

  private Function selectAFunction() {
    return functions.toArray(new Function[0])[randomizer.nextInt(functions.size())];
  }

  private ExpressionNode selectARandomArgumentNode() {
    double random = randomizer.nextDouble();

    return chooseARandomVariable();
  }

  private ExpressionNode selectARandomExpressionNode() {
    double random = randomizer.nextDouble();

    if (random < 0.4) {
      return generateFunctionNode();
    } else {
      return chooseARandomVariable();
    }
  }
}
