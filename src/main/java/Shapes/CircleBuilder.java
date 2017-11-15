package Shapes;

import Utils.Pair;

public class CircleBuilder {

  private CircleBuilder() {}

  private Pair<Double, Double> centerOffset = new Pair<Double, Double>(0.0, 0.0);
  private int size = 0;
  private double redModifier = 1.40;
  private double greenModifier = 1.80;
  private double blueModifier = 1.20;

  public static CircleBuilder aCircle() {
    return new CircleBuilder();
  }

  public Circle build() {
    return new Circle(centerOffset, size, redModifier, greenModifier, blueModifier);
  }

  public CircleBuilder withCenterOffset(Double x, Double y) {
    centerOffset.setFirst(x);
    centerOffset.setSecond(y);
    return this;
  }

  public CircleBuilder withSize(int size) {
    this.size = size;
    return this;
  }

  public CircleBuilder withRedModifier(double redModifier) {
    this.redModifier = redModifier;
    return this;
  }

  public CircleBuilder withGreenModifier(double greenModifier) {
    this.greenModifier = greenModifier;
    return this;
  }

  public CircleBuilder withBlueModifier(double blueModifier) {
    this.blueModifier = blueModifier;
    return this;
  }
}
