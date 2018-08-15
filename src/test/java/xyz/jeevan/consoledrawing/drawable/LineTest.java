package xyz.jeevan.consoledrawing.drawable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineTest {

  @Test
  public void shouldDrawHorizontalLine() {
    int x1 = 1, y1 = 3, x2 = 7, y2 = 3;
    verifyLineDrawing(x1, y1, x2, y2);
  }

  @Test
  public void shouldDrawVerticalLine() {
    int x1 = 2, y1 = 3, x2 = 2, y2 = 4;
    verifyLineDrawing(x1, y1, x2, y2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailInCaseInsufficientParameters() {
    int x1 = 2, y1 = 3, x2 = 2;
    Line line = new Line(x1, y1, x2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailIfNegativeParameterValue() {
    int x1 = 2, y1 = 3, x2 = -2, y2 = 4;
    Line line = new Line(x1, y1, x2, y2);
  }

  private void verifyLineDrawing(int x1, int y1, int x2, int y2) {
    Canvas canvas = new Canvas(20, 10);
    Line line = new Line(x1, y1, x2, y2);
    line.draw(canvas);

    for (int row = (x1 - 1); row < (x2); row++) {
      for (int col = (y1 - 1); col < (y2); col++) {
        assertEquals(canvas.getDrawingChar(), canvas.getPixels()[col][row]);
      }
    }
  }
}
