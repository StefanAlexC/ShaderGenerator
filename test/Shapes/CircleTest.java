package Shapes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CircleTest {

  @Test
  public void CircleTest() {
    assertThat(CircleBuilder.aCircle().build().toString(),
        is("Circle with center offset (0.0, 0.0), size 0 and color modifiers (1.4, 1.8, 1.2)"));

    assertThat(CircleBuilder.aCircle().withSize(10).build().toString(),
        is("Circle with center offset (0.0, 0.0), size 10 and color modifiers (1.4, 1.8, 1.2)"
            + ""));

    assertThat(CircleBuilder.aCircle().withCenterOffset(75.0, -75.0).build().toString(),
        is("Circle with center offset (75.0, -75.0), size 0 and color modifiers (1.4, 1.8, 1.2)"));

    assertThat(CircleBuilder.aCircle().withCenterOffset(-50.0, -50.0).withSize(30).build()
        .toString(), is("Circle with center offset (-50.0, -50.0), size 30 and color "
        + "modifiers (1.4, 1.8, 1.2)"));

    assertThat(CircleBuilder.aCircle().withCenterOffset(50.0, 50.0).withCenterOffset(-50.0, -50.0)
            .withSize(15).withSize(30).build().toString(),
        is("Circle with center offset (-50.0, -50.0), size 30 and color modifiers (1.4, 1.8, "
            + "1.2)"));

    assertThat(CircleBuilder.aCircle().withRedModifier(1.0).withGreenModifier(1.0)
            .withBlueModifier(1.0).build().toString(),
        is("Circle with center offset (0.0, 0.0), size 0 and color modifiers (1.0, 1.0, 1.0)"));
  }
}
