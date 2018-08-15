package xyz.jeevan.consoledrawing.drawable.factory;

import java.util.Arrays;
import java.util.stream.Stream;
import xyz.jeevan.consoledrawing.drawable.AreaFill;
import xyz.jeevan.consoledrawing.drawable.Canvas;
import xyz.jeevan.consoledrawing.drawable.Drawable;
import xyz.jeevan.consoledrawing.drawable.Line;
import xyz.jeevan.consoledrawing.drawable.Rectangle;
import xyz.jeevan.consoledrawing.enums.DrawableEntity;

public class DrawableFactory {

  private DrawableFactory() {
  }

  public static Drawable getEntity(final String command) {
    if (command == null) {
      throw new IllegalArgumentException("Input can not be null");
    }

    String[] operands = command.split("\\s+");
    String drawable = operands[0].toUpperCase();

    if (DrawableEntity.FILL_AREA.getDrawableEntity().equals(drawable)) {
      return new AreaFill(Integer.parseInt(operands[1]), Integer.parseInt(operands[2]),
          operands[3].charAt(0));
    }

    int[] parameters = Stream.of(Arrays.copyOfRange(operands, 1, operands.length))
        .mapToInt(Integer::parseInt).toArray();

    if (DrawableEntity.CANVAS.getDrawableEntity().equals(drawable)) {
      return new Canvas(parameters);
    } else if (DrawableEntity.RECTANGLE.getDrawableEntity().equals(drawable)) {
      return new Rectangle(parameters);
    } else if (DrawableEntity.LINE.getDrawableEntity().equals(drawable)) {
      return new Line(parameters);
    }

    return null;
  }
}
