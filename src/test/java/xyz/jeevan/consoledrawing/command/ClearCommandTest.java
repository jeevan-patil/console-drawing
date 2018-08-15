package xyz.jeevan.consoledrawing.command;

import static org.junit.Assert.*;

import org.junit.Test;
import xyz.jeevan.consoledrawing.command.factory.CommandFactory;
import xyz.jeevan.consoledrawing.drawable.Canvas;
import xyz.jeevan.consoledrawing.drawable.Line;

public class ClearCommandTest {

  @Test
  public void shouldClearTheCanvas() {
    Canvas canvas = getBasicCanvas();

    int x1 = 1, y1 = 3, x2 = 7, y2 = 3;
    Line line = new Line(x1, y1, x2, y2);

    canvas.addDrawable(line);
    canvas.draw(canvas);

    Command command = CommandFactory.getCommand("c");
    assertTrue(command instanceof ClearCommand);

    command.execute(canvas);

    assertEquals(1, canvas.getDrawables().size());
  }

  private Canvas getBasicCanvas() {
    final String commandInput = "C 20 4";
    Command command = CommandFactory.getCommand(commandInput);
    return command.execute(null);
  }
}
