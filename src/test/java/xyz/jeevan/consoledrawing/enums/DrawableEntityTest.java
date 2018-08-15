package xyz.jeevan.consoledrawing.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DrawableEntityTest {

  @Test
  public void shouldProvideCorrectDrawable() {
    String canvasDrawableEntity = DrawableEntity.CANVAS.getDrawableEntity();
    assertEquals("C", canvasDrawableEntity);

    String lineDrwableEntity = DrawableEntity.LINE.getDrawableEntity();
    assertEquals("L", lineDrwableEntity);

    String rectangleDrawableEntity = DrawableEntity.RECTANGLE.getDrawableEntity();
    assertEquals("R", rectangleDrawableEntity);

    String areaDrawableEntity = DrawableEntity.FILL_AREA.getDrawableEntity();
    assertEquals("B", areaDrawableEntity);
  }

}
