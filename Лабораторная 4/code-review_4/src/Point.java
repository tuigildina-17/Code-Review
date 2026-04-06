/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/* FIXME: Не хватало javadoc */
/**
 * Класс, представляющий точку на плоскости.
 * Содержит координаты X и Y.
 */
public class Point {
  public double x;
  public double y;

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт точку с координатами (0, 0).
   */
  public Point() {
    this.x = 0;
    this.y = 0;
  }

  /* FIXME: Не хватало javadoc */
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

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление точки.
   * Формат: "{x;y}"
   *
   * @return строка с координатами точки
   */
  public String toString() {
    return "{" + x + ";" + y + "}";
  }
}