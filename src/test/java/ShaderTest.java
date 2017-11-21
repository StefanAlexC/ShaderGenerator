import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import Shader.Shader;
import Shader.SymbolTable;
import Utils.Types;
import org.junit.Test;

public class ShaderTest {

  private SymbolTable symbolTable = new SymbolTable();
  private Shader shader = new Shader(symbolTable);

  @Test
  public void newShaderHasOnlyResolutionDeclared() throws Exception {
    assertThat(shader.generateHeader(), is("#version 300 es\n"
        + "//Stefan Cuturela\n"
        + "\n"
        + "precision mediump float;\n"
        + "\n"
        + "out vec4 _GLF_color;\n"
        + "\n"
        + "uniform vec2 resolution;\n"
        + "\n"));
  }

  @Test
  public void shaderHeaderWithMultipleInputParams() throws Exception {
    symbolTable.addUnmodifiableEntry("size", Types.INT);
    symbolTable.addUnmodifiableEntry("radius", Types.FLOAT);
    symbolTable.addUnmodifiableEntry("vector2", Types.VEC2);
    symbolTable.addModifiableEntry("hello", Types.INT);

    assertThat(shader.generateHeader(), is("#version 300 es\n"
        + "//Stefan Cuturela\n"
        + "\n"
        + "precision mediump float;\n"
        + "\n"
        + "out vec4 _GLF_color;\n"
        + "\n"
        + "uniform float radius;\n"
        + "uniform vec2 resolution;\n"
        + "uniform int size;\n"
        + "uniform vec2 vector2;\n"
        + "\n"));
  }
}
