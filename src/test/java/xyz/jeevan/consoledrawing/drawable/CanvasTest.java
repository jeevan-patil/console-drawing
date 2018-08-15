package xyz.jeevan.consoledrawing.drawable;

import org.junit.Assert;
import org.junit.Test;

public class CanvasTest {

  /**
   * To check if the canvas is drawn successfully, calculate number of empty spaces inside it.
   */
  @Test
  public void shouldDrawACanvas() {
    Canvas canvas = new Canvas(20, 4);

    int expectedPixelCount = canvas.getHeight() * canvas.getWidth();
    int actualPixelCount = 0;

    char[][] pixels = canvas.getPixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        if (pixels[row][col] == ' ') {
          actualPixelCount++;
        }
      }
    }

    Assert.assertEquals(expectedPixelCount, actualPixelCount);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotDrawCanvasIfInvalidParameters() {
    Canvas canvas = new Canvas(10, -1);
  }

}
