package xyz.jeevan.consoledrawing.drawable;

public interface Drawable {

  /**
   * Method to draw an entity. This method updates the pixels from canvas.
   *
   * @param canvas Canvas on which entity is being drawn.
   */
  void draw(Canvas canvas);
}
