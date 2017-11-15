package Utils;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PairTest {

  @Test
  public void PairTest() {
    Pair<Double, Double> pair = new Pair<Double, Double>(75.0, -75.0);
    assertTrue(pair.toString().equals("(75.0, -75.0)"));

    pair.setFirst(50.0);
    assertTrue(pair.toString().equals("(50.0, -75.0)"));

    pair.setSecond(-2.0);
    assertThat(pair.getSecond(), is(-2.0));
  }
}
