package xyz.jeevan.consoledrawing.drawable;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

  @Test
  public void shouldDrawRectangle() {
    Canvas canvas = new Canvas(20, 10);
    int x1 = 5, y1 = 3, x2 = 15, y2 = 6;
    Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
    rectangle.draw(canvas);

    // we can calculate number of drawing characters we found on the canvas and use it for assertion
    int noOfCharactersOnHorizontalLine = (x2 - x1) + 1; // +1 because the x1 index is exclusive

    int totalNoOfCharactersOnBothHorizontalLines = noOfCharactersOnHorizontalLine * 2;

    int noOfCharsOnRightVerticalLine = ((y2 - y1) + 1)
        - 2; // -2 because 2 characters have been calculated in horizontal lines already

    int totalNoOfCharsOnVerticalLines = noOfCharsOnRightVerticalLine * 2;

    int actualCount = 0;
    for (int row = y1 - 1; row <= y2 - 1; row++) {
      for (int col = x1 - 1; col <= x2 - 1; col++) {
        if (canvas.getPixels()[row][col] == canvas.getDrawingChar()) {
          actualCount++;
        }
      }
    }

    Assert.assertEquals((totalNoOfCharactersOnBothHorizontalLines + totalNoOfCharsOnVerticalLines),
        actualCount);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailInCaseInsufficientParameters() {
    int x1 = 2, y1 = 3, x2 = 2;
    Rectangle rectangle = new Rectangle(x1, y1, x2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailIfNegativeParameterValue() {
    int x1 = 2, y1 = 3, x2 = -2, y2 = 4;
    Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
  }

}
