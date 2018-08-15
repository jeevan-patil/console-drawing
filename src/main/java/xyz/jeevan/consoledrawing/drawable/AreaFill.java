package xyz.jeevan.consoledrawing.drawable;

import java.util.Stack;
import xyz.jeevan.consoledrawing.model.Point;
import xyz.jeevan.consoledrawing.util.NumberUtil;

public class AreaFill implements Drawable {

  private int x;
  private int y;
  private char filler;

  public AreaFill(int x, int y, char filler) {
    NumberUtil.validateParameters(x, y);
    this.x = x;
    this.y = y;
    this.filler = filler;
  }

  public void draw(Canvas canvas) {
    char[][] pixels = canvas.getPixels();
    char originalChar = pixels[y - 1][x - 1];
    Stack<Point> stack = new Stack<>();
    stack.add(new Point(y - 1, x - 1));

    while (!stack.isEmpty()) {
      Point pop = stack.pop();
      if (pixels[pop.getX()][pop.getY()] == originalChar) {
        pixels[pop.getX()][pop.getY()] = filler;
      }
      if (pop.getX() - 1 >= 0 && pixels[pop.getX() - 1][pop.getY()] == originalChar) {
        stack.add(new Point(pop.getX() - 1, pop.getY()));
      }
      if (pop.getX() + 1 < canvas.getHeight()
          && pixels[pop.getX() + 1][pop.getY()] == originalChar) {
        stack.add(new Point(pop.getX() + 1, pop.getY()));
      }
      if (pop.getY() - 1 >= 0 && pixels[pop.getX()][pop.getY() - 1] == originalChar) {
        stack.add(new Point(pop.getX(), pop.getY() - 1));
      }
      if (pop.getY() + 1 < canvas.getWidth()
          && pixels[pop.getX()][pop.getY() + 1] == originalChar) {
        stack.add(new Point(pop.getX(), pop.getY() + 1));
      }
    }
  }

}
