package ru.borisova.geometry;

/**
 * Трёхмерная точка с целочисленными координатами.
 */
public class Point3D extends Point {

  private int z;

  /**
   * Создаёт трёхмерную точку с указанными координатами.
   *
   * @param x координата X
   * @param y координата Y
   * @param z координата Z
   */
  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  /**
   * Возвращает строковое представление трёхмерной точки.
   */
  @Override
  public String toString() {
    return "Point3D(" + x + ", " + y + ", " + z + ")";
  }
}