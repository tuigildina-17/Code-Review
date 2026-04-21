package ru.borisova.geometry;

/**
 * Точка на плоскости, поддерживающая клонирование.
 */
public class CloneablePoint implements Cloneable {

  private int x;
  private int y;

  /**
   * Создаёт точку с указанными координатами.
   *
   * @param x координата X
   * @param y координата Y
   */
  public CloneablePoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Создаёт копию точки.
   *
   * @return новый объект CloneablePoint с теми же координатами
   */
  @Override
  public CloneablePoint clone() {
    return new CloneablePoint(this.x, this.y);
  }

  /**
   * Возвращает строковое представление точки.
   */
  @Override
  public String toString() {
    return "CloneablePoint(" + x + ", " + y + ")";
  }
}
