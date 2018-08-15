package xyz.jeevan.consoledrawing.util;

public final class NumberUtil {

  private NumberUtil() {
  }

  public static void validateParameters(final int... parameters) {
    if (!allPositive(parameters)) {
      throw new IllegalArgumentException("All the parameters should be positive.");
    }
  }

  private static boolean allPositive(final int... numbers) {
    for (int num : numbers) {
      if (num < 0) {
        return false;
      }
    }

    return true;
  }

}
