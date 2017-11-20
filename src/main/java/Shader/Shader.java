package Shader;

import Shapes.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shader {

  //TODO: Add sorting by size
  private List<Circle> circles = new ArrayList<Circle>();
  private double innerCircleFrequencyCoefficient = 5.0;
  private double[] backgroundColor = {0.0, 0.0, 0.0};
  private Set<Function> functions = new HashSet<Function>();


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

  public Shader addFunctionFactory(Function function) {
    functions.add(function);
    return this;
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

  private String generateMainBody() {
    return "void main(void) { \n}";
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

  public String getInputJson() {
    return null;
  }

  @Override
  public String toString() {
    return generateHeader()
        + functions.stream().map(x -> x.toString()).reduce(String::concat).orElse("")
        + generateMainBody();
  }
}
