package xyz.jeevan.consoledrawing.command;

import xyz.jeevan.consoledrawing.drawable.Canvas;
import xyz.jeevan.consoledrawing.drawable.Drawable;
import xyz.jeevan.consoledrawing.drawable.factory.DrawableFactory;
import xyz.jeevan.consoledrawing.enums.DrawableEntity;
import xyz.jeevan.consoledrawing.exception.CanvasAlreadyDrawnException;
import xyz.jeevan.consoledrawing.exception.CanvasNotDrawnException;
import xyz.jeevan.consoledrawing.exception.InvalidEntityException;

public class DrawCommand implements Command {

  private String command;

  public DrawCommand(String command) {
    this.command = command;
  }

  public Canvas execute(Canvas canvas) {
    // check if basic canvas is drawn before other entities
    isCanvasDrawn(canvas);

    // check if user is trying to draw canvas again
    isCanvasAlreadyDrawn(canvas);

    Drawable drawable = DrawableFactory.getEntity(command);

    if (drawable == null) {
      throw new InvalidEntityException("Drawable you are trying to draw is invalid.");
    }

    if (drawable instanceof Canvas) {
      canvas = new Canvas(((Canvas) drawable).getWidth(), ((Canvas) drawable).getHeight());
    }

    canvas.addDrawable(drawable);
    canvas.draw(canvas);
    return canvas;
  }

  /**
   * Before drawing other diagrams, canvas need to be there. This method checks if the basic canvas
   * is drawn already or not.
   */
  private void isCanvasDrawn(Canvas canvas) {
    if (canvas == null && !command.toUpperCase()
        .startsWith(DrawableEntity.CANVAS.getDrawableEntity())) {
      throw new CanvasNotDrawnException(
          "Canvas is not drawn yet. Use C w h command to draw the canvas. w is width and h is "
              + "height of the canvas.");
    }
  }

  /**
   * This method is used to check if the user is drawing the canvas again and again.
   */
  private void isCanvasAlreadyDrawn(Canvas canvas) {
    if (canvas != null && command.toUpperCase()
        .startsWith(DrawableEntity.CANVAS.getDrawableEntity())) {
      throw new CanvasAlreadyDrawnException(
          "Canvas has already been drawn. Please draw something else.");
    }
  }
}
