package ru.borisova.geometry;

import java.util.Objects;

/**
 * Точка на плоскости с целочисленными координатами.
 */
public class Point {

  protected int x;
  protected int y;

  /**
   * Создаёт точку с указанными координатами.
   *
   * @param x координата X
   * @param y координата Y
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Сравнивает точки по координатам.
   *
   * @param obj объект для сравнения
   * @return true, если координаты совпадают
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Point)) return false;
    Point p = (Point) obj;
    return this.x == p.x && this.y == p.y;
  }

  /**
   * Возвращает хеш-код точки.
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  /**
   * Возвращает строковое представление точки.
   */
  @Override
  public String toString() {
    return "Point(" + x + ", " + y + ")";
  }
}