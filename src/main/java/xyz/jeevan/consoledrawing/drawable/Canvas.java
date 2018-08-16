package xyz.jeevan.consoledrawing.drawable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import xyz.jeevan.consoledrawing.exception.InvalidEntityException;
import xyz.jeevan.consoledrawing.util.NumberUtil;

public class Canvas implements CanvasDrawable {

  private static final char EMPTY_SPACE = ' ';
  private static final char VERTICAL_CHAR = '|'; // pipe will be used to draw horizontal lines
  private static final char HORIZONTAL_CHAR = '-'; // hyphen will be used to draw vertical  lines
  private static final char DRAWING_CHAR = 'x';

  private final char[][] pixels;
  private final String horizontalEdge;
  private int width;
  private int height;
  // List of drawables being drawn on the canvas
  private LinkedList<Drawable> drawables;

  public Canvas(int... parameters) {
    NumberUtil.validateParameters(parameters);

    this.width = parameters[0];
    this.height = parameters[1];

    drawables = new LinkedList<>();
    pixels = new char[this.height][this.width];

    // fill canvas pixels with empty characters, otherwise it prints unwanted characters inside it
    Arrays.stream(pixels).forEach(chars -> Arrays.fill(chars, EMPTY_SPACE));
    horizontalEdge = Stream.generate(() -> String.valueOf(HORIZONTAL_CHAR)).limit(width + 2)
        .collect(
            Collectors.joining());
  }

  public static char getDrawingChar() {
    return DRAWING_CHAR;
  }

  public static char getEmptySpace() {
    return EMPTY_SPACE;
  }

  public void addDrawable(Drawable drawable) {
    drawables.add(drawable);
  }

  public void draw(Canvas canvas) {
    if (drawables == null || drawables.isEmpty()) {
      throw new InvalidEntityException("No drawables to draw.");
    }

    for (Drawable drawable : drawables) {
      if (!(drawable instanceof Canvas)) {
        drawable.draw(canvas);
      }
    }

    render();
  }

  /**
   * This method renders the entire canvas along with the drawings inside it.
   */
  private void render() {
    StringBuilder builder = new StringBuilder();
    builder.append(horizontalEdge).append("\n");
    for (int i = 0; i < this.height; i++) {
      builder.append(VERTICAL_CHAR);
      for (int j = 0; j < this.width; j++) {
        builder.append(pixels[i][j]);
      }
      builder.append(VERTICAL_CHAR);
      builder.append("\n");
    }
    builder.append(horizontalEdge);
    System.out.printf(builder.toString());
  }

  public void clear() {
    Iterator<Drawable> iterator = this.drawables.iterator();
    while (iterator.hasNext()) {
      if (!(iterator.next() instanceof Canvas)) {
        iterator.remove();
      }
    }

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        pixels[row][col] = EMPTY_SPACE;
      }
    }
  }

  /**
   * Method to mark a line on the canvas. This method could be used to draw horizontal and vertical
   * lines. Same method could used in case rectangles are drawn.
   */
  public void markLine(int x1, int y1, int x2, int y2) {
    for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
      for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
        pixels[row][col] = DRAWING_CHAR;
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public char[][] getPixels() {
    return pixels;
  }

  public LinkedList<Drawable> getDrawables() {
    return drawables;
  }
}
