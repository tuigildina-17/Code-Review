package ru.borisova.main;

import ru.borisova.geometry.Point;
import ru.borisova.util.InputUtils;

/**
 * Task2 — сравнение двух точек.
 */
public class Task2 {

  /**
   * Запускает выполнение задания 2.
   */
  public static void run() {
    System.out.println("=== Задание 2: Сравнение точек ===");

    // FIXME: Ввод координат первой точки написан прямо в методе — дублирование логики.
    // FIXME: Лучше вынести в отдельный метод readPoint(prompt).
    /*
    System.out.println("\nВведите координаты первой точки:");
    int x1 = InputUtils.readInt("x1 = ");
    int y1 = InputUtils.readInt("y1 = ");

    System.out.println("\nВведите координаты второй точки:");
    int x2 = InputUtils.readInt("x2 = ");
    int y2 = InputUtils.readInt("y2 = ");

    Point p1 = new Point(x1, y1);
    Point p2 = new Point(x2, y2);
    */
    Point p1 = readPoint("Введите координаты первой точки:");
    Point p2 = readPoint("Введите координаты второй точки:");

    // FIXME: Вывод точек повторяется — лучше вынести в отдельный метод printPoints().
    /*
    System.out.println("\nПервая точка:  " + p1);
    System.out.println("Вторая точка:  " + p2);
    */
    printPoints(p1, p2);

    // FIXME: Логика сравнения точек написана прямо в методе — лучше вынести в метод comparePoints().
    /*
    System.out.println("\nРезультат сравнения:");
    if (p1.equals(p2)) {
      System.out.println("Точки равны");
    } else {
      System.out.println("Точки НЕ равны");
    }
    */
    comparePoints(p1, p2);
  }

  /**
   * Считывает координаты точки.
   *
   * @param title заголовок перед вводом
   * @return объект Point
   */
  private static Point readPoint(String title) {
    System.out.println("\n" + title);
    int x = InputUtils.readInt("x = ");
    int y = InputUtils.readInt("y = ");
    return new Point(x, y);
  }

  /**
   * Выводит две точки.
   *
   * @param p1 первая точка
   * @param p2 вторая точка
   */
  private static void printPoints(Point p1, Point p2) {
    System.out.println("\nПервая точка:  " + p1);
    System.out.println("Вторая точка:  " + p2);
  }

  /**
   * Сравнивает две точки и выводит результат.
   *
   * @param p1 первая точка
   * @param p2 вторая точка
   */
  private static void comparePoints(Point p1, Point p2) {
    System.out.println("\nРезультат сравнения:");
    if (p1.equals(p2)) {
      System.out.println("Точки равны");
    } else {
      System.out.println("Точки НЕ равны");
    }
  }
}