package Shapes;

import Utils.Pair;

public class Circle {

  private final Pair<Double, Double> centerOffset;
  private final int size;
  private final double redModifier;
  private final double greenModifier;
  private final double blueModifier;

  public Circle(Pair<Double, Double> centerOffset, int size, double redModifier,
      double greenModifier,
      double blueModifier) {
    this.centerOffset = centerOffset;
    this.size = size;
    this.redModifier = redModifier;
    this.greenModifier = greenModifier;
    this.blueModifier = blueModifier;
  }

  public double getRedModifier() {
    return redModifier;
  }

  public double getGreenModifier() {
    return greenModifier;
  }

  public double getBlueModifier() {
    return blueModifier;
  }

  public String getModifiers() {
    return "(" + redModifier + ", " + greenModifier + ", " + blueModifier + ")";
  }

  public Pair<Double, Double> getCenterOffset() {
    return centerOffset;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "Circle with center offset " + centerOffset + ", size " + size + " and color modifiers"
        + " (" + redModifier + ", " + greenModifier + ", " + blueModifier + ")";
  }
}
