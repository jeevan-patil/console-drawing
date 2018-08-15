package xyz.jeevan.consoledrawing.drawable;

import org.junit.Assert;
import org.junit.Test;

public class AreaFillTest {

  @Test
  public void shouldFillTheArea() {
    Canvas canvas = new Canvas(20, 4);

    // draw a rectangle
    Rectangle rectangle = new Rectangle(14, 1, 18, 3);
    rectangle.draw(canvas);

    // fill area inside the rectangle
    final char filler = 'J';
    AreaFill areaFill = new AreaFill(15, 2, filler);
    areaFill.draw(canvas);

    int numberOfPlacesFilled = 0;
    char[][] pixels = canvas.getPixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        if (pixels[row][col] == filler) {
          numberOfPlacesFilled++;
        }
      }
    }

    Assert.assertEquals(3, numberOfPlacesFilled);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotFillInCaseOfWrongParameters() {
    Canvas canvas = new Canvas(20, 4);

    // draw a rectangle
    Rectangle rectangle = new Rectangle(14, 1, 18, 3);
    rectangle.draw(canvas);

    AreaFill areaFill = new AreaFill(15, -2, 'J');
  }

}
