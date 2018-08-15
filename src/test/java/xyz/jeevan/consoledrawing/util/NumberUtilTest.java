package xyz.jeevan.consoledrawing.util;

import org.junit.Test;

public class NumberUtilTest {

  @Test
  public void validateParameters() {
    int[] parameters = {3, 2, 1, 5};
    NumberUtil.validateParameters(parameters);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailIfNegativeParameter() {
    int[] parameters = {3, 2, -1, 5};
    NumberUtil.validateParameters(parameters);
  }

}
