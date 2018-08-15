package xyz.jeevan.consoledrawing.drawable.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import xyz.jeevan.consoledrawing.drawable.AreaFill;
import xyz.jeevan.consoledrawing.drawable.Canvas;
import xyz.jeevan.consoledrawing.drawable.Drawable;
import xyz.jeevan.consoledrawing.drawable.Line;
import xyz.jeevan.consoledrawing.drawable.Rectangle;

public class DrawableFactoryTest {

  @Test
  public void shouldProvideCanvasDrawable() {
    Drawable drawable = DrawableFactory.getEntity("C 20 4");
    assertNotNull(drawable);
    assertTrue(drawable instanceof Canvas);
  }

  @Test
  public void shouldProvideLineDrawable() {
    Drawable drawable = DrawableFactory.getEntity("L 1 2 6 2");
    assertNotNull(drawable);
    assertTrue(drawable instanceof Line);
  }

  @Test
  public void shouldProvideRectangleDrawable() {
    Drawable drawable = DrawableFactory.getEntity("R 16 1 20 3");
    assertNotNull(drawable);
    assertTrue(drawable instanceof Rectangle);
  }

  @Test
  public void shouldProvideAreaFillDrawable() {
    Drawable drawable = DrawableFactory.getEntity("B 10 3 o");
    assertNotNull(drawable);
    assertTrue(drawable instanceof AreaFill);
  }

}
