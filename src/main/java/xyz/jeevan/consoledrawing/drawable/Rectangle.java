package xyz.jeevan.consoledrawing.drawable;

import xyz.jeevan.consoledrawing.util.NumberUtil;

public class Rectangle implements Drawable {

  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Rectangle(int... parameters) {
    validateParameters(parameters);
    this.x1 = parameters[0];
    this.y1 = parameters[1];
    this.x2 = parameters[2];
    this.y2 = parameters[3];
  }

  public void draw(Canvas canvas) {
    // draw upper horizontal line
    canvas.markLine(x1, y1, x2, y1);

    // draw lowe horizontal line
    canvas.markLine(x1, y2, x2, y2);

    // draw right vertical line
    canvas.markLine(x2, y1, x2, y2);

    // draw left vertical line
    canvas.markLine(x1, y1, x1, y2);
  }

  private void validateParameters(int... parameters) {
    if (parameters.length < 4) {
      throw new IllegalArgumentException(
          "4 arguments should be passed to draw a line. Use this command - L x1 y1 x2 y2");
    }

    NumberUtil.validateParameters(parameters);
  }
}
