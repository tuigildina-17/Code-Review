package ru.borisova.main;

import ru.borisova.geometry.Point3D;
import ru.borisova.util.InputUtils;

/**
 * Task5 — создание и вывод трёхмерной точки.
 */
public class Task5 {

  /**
   * Запускает выполнение задания 5.
   */
  public static void run() {
    System.out.println("=== Задание 5: Трёхмерная точка ===");

    // FIXME: Ввод координат написан прямо в методе — дублирование логики.
    // FIXME: Лучше вынести в отдельный метод readPoint3D().
    /*
    int x = InputUtils.readInt("Введите x: ");
    int y = InputUtils.readInt("Введите y: ");
    int z = InputUtils.readInt("Введите z: ");

    Point3D p = new Point3D(x, y, z);

    System.out.println("Создана точка: " + p);
    */
    Point3D point = readPoint3D();
    printPoint(point);
  }

  /**
   * Считывает координаты трёхмерной точки.
   *
   * @return объект Point3D
   */
  private static Point3D readPoint3D() {
    int x = InputUtils.readInt("Введите x: ");
    int y = InputUtils.readInt("Введите y: ");
    int z = InputUtils.readInt("Введите z: ");
    return new Point3D(x, y, z);
  }

  /**
   * Выводит трёхмерную точку.
   *
   * @param point объект Point3D
   */
  private static void printPoint(Point3D point) {
    System.out.println("Создана точка: " + point);
  }
}