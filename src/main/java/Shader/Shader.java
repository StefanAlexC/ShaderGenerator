package Shader;

import Shapes.Circle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shader {

  //TODO: Add sorting by size
  private List<Circle> circles = new ArrayList<Circle>();
  private double innerCircleFrequencyCoefficient = 5.0;
  private double[] backgroundColor = {0.0, 0.0, 0.0};


  public void addCircle(Circle circle) {
    circles.add(circle);
  }

  public void sortCircles() {/*
    circles.sort(Comparator.comparingInt(Circle::getSize));*/
  }

  public void setInnerCircleFrequencyCoeficient(double innerCircleFrequencyCoefficient) {
    this.innerCircleFrequencyCoefficient = innerCircleFrequencyCoefficient;
  }

  public void setBackgroundColor(double red, double green, double blue) {
    backgroundColor = new double[]{red, green, blue};
  }

  private String generateHeader() {
    return "#version 300 es\n"
        + "//Stefan Cuturela\n"
        + "\n"
        + "precision mediump float;\n"
        + "\n"
        + "out vec4 _GLF_color;\n"
        + "uniform vec2 resolution;\n"
        + "\n";
  }

  //TODO: Rename parameter
  private String generateRadiusMethod(double coefficient) {
    return "float radius(vec2 center_circle) {\n"
        + "  return sqrt((center_circle.x - gl_FragCoord.x) * (center_circle.x - gl_FragCoord.x) "
        + "+ (center_circle.y - gl_FragCoord.y) * (center_circle.y - gl_FragCoord.y)) "
        + "/ " + coefficient + ";\n"
        + "}\n"
        + "\n";
  }

  private String declareVariables() {
    return "  int circle_radius;\n"
        + "  int circle_index;\n"
        + "  vec2 imgCenter = vec2(resolution.x / 2.0, resolution.y / 2.0);\n"
        + "\n";
  }

  private String declareCircles() {
    String circleDeclaration = "  vec2 points[" + circles.size() + "];\n";

    int index = 0;
    for (Circle circle : circles) {
      circleDeclaration += "  points[" + index++ + "] = imgCenter + vec2"
          + circle.getCenterOffset() + ";\n";
    }

    circleDeclaration += "\n  int sizes[" + circles.size() + "];\n";
    index = 0;
    for (Circle circle : circles) {
      circleDeclaration += "  sizes[" + index++ + "] = " + circle.getSize() + ";\n";
    }

    circleDeclaration += "\n  vec3 color_modifiers[" + circles.size() + "];\n";
    index = 0;
    for (Circle circle : circles) {
      circleDeclaration += "  color_modifiers[" + index++ + "] = vec3" + circle.getModifiers() + ";\n";
    }

    return circleDeclaration + "\n"
        + "  for (int i = 0; i < " + circles.size() + "; i++) {\n"
        + "    if (int(radius(points[i])) < sizes[i]) {\n"
        + "      circle_index = i;\n"
        + "      circle_radius = int(radius(points[i]));\n"
        + "      break;\n"
        + "    }\n"
        + "  }\n"
        + "\n";
  }

  private String calculatePixelValue() {
    return "  if (circle_radius != 0 && circle_radius < sizes[circle_index]) {\n"
        + "    float red = mod(float(circle_radius), color_modifiers[circle_index].x);\n"
        + "    float green = mod(float(circle_radius), color_modifiers[circle_index].y);\n"
        + "    float blue = mod(float(circle_radius), color_modifiers[circle_index].z);\n"
        + "    _GLF_color = vec4(red, green, blue, 1.0);\n"
        + "  } else {\n"
        + "    _GLF_color = vec4(" + backgroundColor[0] + ", " + backgroundColor[1] + ", " +
        backgroundColor[2] + ", 1.0);\n"
        + "  }\n";
  }

  public String getShader() {
    return toString();
  }

  public String getInpusJson() {
    return null;
  }

  @Override
  public String toString() {
    return generateHeader()
        + generateRadiusMethod(innerCircleFrequencyCoefficient)
        + "void main(void) {\n"
        + declareVariables()
        + declareCircles()
        + calculatePixelValue()
        + "}";
  }
}
