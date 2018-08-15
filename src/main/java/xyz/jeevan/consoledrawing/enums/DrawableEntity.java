package xyz.jeevan.consoledrawing.enums;

public enum DrawableEntity {

  CANVAS("C"), LINE("L"), RECTANGLE("R"), FILL_AREA("B");

  private final String entity;

  DrawableEntity(final String entity) {
    this.entity = entity;
  }

  public String getDrawableEntity() {
    return this.entity;
  }
}
