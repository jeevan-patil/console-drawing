package xyz.jeevan.consoledrawing.command;

import xyz.jeevan.consoledrawing.drawable.Canvas;

public class ClearCommand implements Command {

  @Override
  public Canvas execute(Canvas canvas) {
    canvas.clear();
    canvas.draw(canvas);
    return canvas;
  }

}
