package xyz.jeevan.consoledrawing.command;

import xyz.jeevan.consoledrawing.drawable.Canvas;

public interface Command {

  /**
   * Method to execute a command.
   *
   * @param canvas Canvas on which things are being drawn.
   * @return {@code Canvas} Canvas object.
   */
  Canvas execute(Canvas canvas);
}
