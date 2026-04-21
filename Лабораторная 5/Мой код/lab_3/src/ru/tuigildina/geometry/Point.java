package ru.tuigildina.geometry;

/**
 * FIXME:
 * 1. Используется табуляция
 * 2. Не хватает Javadoс
 */

/**
 * Класс, представляющий точку на плоскости.
 * Содержит координаты X и Y и поддерживает сравнение и клонирование.
 */
public class Point implements Cloneable {
  double x;
  double y;

  /**
   * Создаёт точку с указанными координатами.
   *
   * @param x значение координаты X
   * @param y значение координаты Y
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Сравнивает текущую точку с другим объектом.
   * Точки считаются равными, если их координаты совпадают.
   *
   * @param o объект для сравнения
   * @return true, если точки равны по координатам, иначе false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Point other)) return false;
    return this.x == other.x && this.y == other.y;
  }

  /**
   * Создаёт копию текущей точки.
   * Возвращает новый объект Point с теми же координатами.
   *
   * @return новый объект Point, являющийся копией текущего
   */
  @Override
  public Point clone() {
    return new Point(this.x, this.y);
  }

  /**
   * Возвращает строковое представление точки в формате (x; y).
   *
   * @return строковое представление точки
   */
  @Override
  public String toString() {
    return "(" + x + "; " + y + ")";
  }
}