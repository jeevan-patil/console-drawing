package xyz.jeevan.consoledrawing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import xyz.jeevan.consoledrawing.command.Command;
import xyz.jeevan.consoledrawing.command.factory.CommandFactory;
import xyz.jeevan.consoledrawing.drawable.Canvas;
import xyz.jeevan.consoledrawing.exception.CanvasAlreadyDrawnException;
import xyz.jeevan.consoledrawing.exception.CanvasNotDrawnException;

public class ConsoleDrawingTest {

  @Test
  public void drawCanvas() {
    Canvas canvas = getBasicCanvas();

    assertNotNull(canvas);
    assertEquals(canvas.getHeight(), canvas.getPixels().length);
  }

  @Test(expected = CanvasAlreadyDrawnException.class)
  public void shouldNotDrawCanvasMultipleTimes() {
    Canvas existingCanvas = getBasicCanvas();

    Command command = CommandFactory.getCommand("C 15 3");
    command.execute(existingCanvas);
  }

  @Test(expected = CanvasNotDrawnException.class)
  public void shouldNotAllowDrawablesWithoutCanvas() {
    Canvas canvas = null;

    Command command = CommandFactory.getCommand("L 6 3 6 4");
    command.execute(canvas);
  }

  /**
   * Provide basic canvas of 20X4 to draw other images.
   */
  private Canvas getBasicCanvas() {
    final String commandInput = "C 20 4";
    Command command = CommandFactory.getCommand(commandInput);
    return command.execute(null);
  }

}
