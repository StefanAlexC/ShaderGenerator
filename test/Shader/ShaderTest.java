package Shader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;

import Shapes.CircleBuilder;
import org.junit.Test;

public class ShaderTest {

  private final Shader shader = new Shader();

  @Test
  public void hasHeaderTest() {
    assertThat(shader.toString(), startsWith("#version 300 es\n"
        + "//Stefan Cuturela\n"
        + "\n"
        + "precision mediump float;\n"
        + "\n"
        + "out vec4 _GLF_color;\n"
        + "uniform vec2 resolution;\n"
        + "\n"));
  }

  @Test
  public void hasRadiusMethodTest() {
    assertThat(shader.toString().substring(108), startsWith("float radius(vec2 center_circle) {\n"
        + "  return sqrt((center_circle.x - gl_FragCoord.x) * (center_circle.x - gl_FragCoord.x) + "
        + "(center_circle.y - gl_FragCoord.y) * (center_circle.y - gl_FragCoord.y)) / 5.0;\n"
        + "}\n"
        + "\n"));
  }

  @Test
  public void variablesAreDeclaredTest() {
    assertThat(shader.toString().substring(314), startsWith("void main(void) {\n"
        + "  int circle_radius;\n"
        + "  int circle_index;\n"
        + "  vec2 imgCenter = vec2(resolution.x / 2.0, resolution.y / 2.0);\n"
        + "\n"));
  }

  @Test
  public void declareCircles() {
    Shader circleShader = new Shader();

    circleShader.addCircle(CircleBuilder.aCircle().withSize(10).build());
    circleShader.addCircle(CircleBuilder.aCircle().withCenterOffset(-75.0, -75.0)
        .withSize(20).build());
    circleShader.addCircle(CircleBuilder.aCircle().withCenterOffset(50.0, -50.0)
        .withSize(30).build());

    assertThat(circleShader.toString().substring(439), startsWith("  vec2 points[3];\n"
        + "  points[0] = imgCenter + vec2(0.0, 0.0);\n"
        + "  points[1] = imgCenter + vec2(-75.0, -75.0);\n"
        + "  points[2] = imgCenter + vec2(50.0, -50.0);\n"
        + "\n"
        + "  int sizes[3];\n"
        + "  sizes[0] = 10;\n"
        + "  sizes[1] = 20;\n"
        + "  sizes[2] = 30;\n"
        + "\n"
        + "  vec3 color_modifiers[3];\n"
        + "  color_modifiers[0] = vec3(1.4, 1.8, 1.2);\n"
        + "  color_modifiers[1] = vec3(1.4, 1.8, 1.2);\n"
        + "  color_modifiers[2] = vec3(1.4, 1.8, 1.2);\n"
        + "\n"
        + "  for (int i = 0; i < 3; i++) {\n"
        + "    if (int(radius(points[i])) < sizes[i]) {\n"
        + "      circle_index = i;\n"
        + "      circle_radius = int(radius(points[i]));\n"
        + "      break;\n"
        + "    }\n"
        + "  }\n"
        + "\n"));
  }

  @Test
  public void sortedCirclesTest() {
    Shader circleShader = new Shader();

    circleShader.addCircle(CircleBuilder.aCircle().withSize(15).build());
    circleShader.addCircle(CircleBuilder.aCircle().withCenterOffset(-75.0, -75.0)
        .withSize(20).build());
    circleShader.addCircle(CircleBuilder.aCircle().withCenterOffset(50.0, -50.0)
        .withSize(10).build());

    circleShader.sortCircles();

    assertThat(circleShader.toString().substring(439), startsWith("  vec2 points[3];\n"
        + "  points[0] = imgCenter + vec2(50.0, -50.0);\n"
        + "  points[1] = imgCenter + vec2(0.0, 0.0);\n"
        + "  points[2] = imgCenter + vec2(-75.0, -75.0);\n"
        + "\n"
        + "  int sizes[3];\n"
        + "  sizes[0] = 10;\n"
        + "  sizes[1] = 15;\n"
        + "  sizes[2] = 20;\n"
        + "\n"
        + "  vec3 color_modifiers[3];\n"
        + "  color_modifiers[0] = vec3(1.4, 1.8, 1.2);\n"
        + "  color_modifiers[1] = vec3(1.4, 1.8, 1.2);\n"
        + "  color_modifiers[2] = vec3(1.4, 1.8, 1.2);\n"
        + "\n"
        + "  for (int i = 0; i < 3; i++) {\n"
        + "    if (int(radius(points[i])) < sizes[i]) {\n"
        + "      circle_index = i;\n"
        + "      circle_radius = int(radius(points[i]));\n"
        + "      break;\n"
        + "    }\n"
        + "  }\n"
        + "\n"));
  }

  @Test
  public void calculatePixelValueTest() {
    Shader circleShader = new Shader();

    circleShader.addCircle(CircleBuilder.aCircle().withSize(10).build());
    circleShader.addCircle(CircleBuilder.aCircle().withCenterOffset(-75.0, -75.0)
        .withSize(20).build());
    circleShader.addCircle(CircleBuilder.aCircle().withCenterOffset(50.0, -50.0)
        .withSize(30).build());

    assertThat(circleShader.toString().substring(990), startsWith("  if (circle_radius != 0 && "
        + "circle_radius < "
        + "sizes[circle_index]) {\n"
        + "    float red = mod(float(circle_radius), color_modifiers[circle_index].x);\n"
        + "    float green = mod(float(circle_radius), color_modifiers[circle_index].y);\n"
        + "    float blue = mod(float(circle_radius), color_modifiers[circle_index].z);\n"
        + "    _GLF_color = vec4(red, green, blue, 1.0);\n"
        + "  } else {\n"
        + "    _GLF_color = vec4(0.0, 0.0, 0.0, 1.0);\n"
        + "  }\n"
        + "}"));
  }
}
