package ru.borisova.main;

import ru.borisova.geometry.CloneablePoint;
import ru.borisova.util.InputUtils;

/**
 * Task6 — клонирование точки.
 */
public class Task6 {

  /**
   * Запускает выполнение задания 6.
   */
  public static void run() {
    System.out.println("=== Задание 6: Клонирование точки ===");

    // FIXME: Ввод координат написан прямо в методе — дублирование логики.
    // FIXME: Лучше вынести в отдельный метод readPoint().
    /*
    int x = InputUtils.readInt("Введите x: ");
    int y = InputUtils.readInt("Введите y: ");

    CloneablePoint p1 = new CloneablePoint(x, y);
    CloneablePoint p2 = p1.clone();

    System.out.println("Оригинал: " + p1);
    System.out.println("Клон:   " + p2);
    */
    CloneablePoint original = readPoint();
    CloneablePoint clone = original.clone();

    printPoints(original, clone);
  }

  /**
   * Считывает координаты точки.
   *
   * @return объект CloneablePoint
   */
  private static CloneablePoint readPoint() {
    int x = InputUtils.readInt("Введите x: ");
    int y = InputUtils.readInt("Введите y: ");
    return new CloneablePoint(x, y);
  }

  /**
   * Выводит оригинал и клон точки.
   *
   * @param p1 оригинальная точка
   * @param p2 клонированная точка
   */
  private static void printPoints(CloneablePoint p1, CloneablePoint p2) {
    System.out.println("Оригинал: " + p1);
    System.out.println("Клон:   " + p2);
  }
}