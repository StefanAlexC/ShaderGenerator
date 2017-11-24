package InstructionGenerators;

import Shader.Function;
import Shader.Instruction;
import Shader.SymbolTable;
import java.util.Set;

public interface InstructionGenerator {

  Instruction generateInstruction();
}
