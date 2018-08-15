package xyz.jeevan.consoledrawing.command;

import xyz.jeevan.consoledrawing.drawable.Canvas;

public class QuitCommand implements Command {

  public Canvas execute(Canvas canvas) {
    System.out.println("Exiting ... ");
    System.exit(0);
    return null;
  }
}
