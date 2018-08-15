package xyz.jeevan.consoledrawing.command;

import java.util.Iterator;
import xyz.jeevan.consoledrawing.drawable.Canvas;
import xyz.jeevan.consoledrawing.drawable.Drawable;

public class ClearCommand implements Command {

  @Override
  public Canvas execute(Canvas canvas) {
    Iterator<Drawable> iterator = canvas.getDrawables().iterator();
    while (iterator.hasNext()) {
      if (!(iterator.next() instanceof Canvas)) {
        iterator.remove();
      }
    }

    for (int row = 0; row < canvas.getHeight(); row++) {
      for (int col = 0; col < canvas.getWidth(); col++) {
        canvas.getPixels()[row][col] = canvas.getEmptySpace();
      }
    }

    canvas.draw(canvas);
    return canvas;
  }

}
