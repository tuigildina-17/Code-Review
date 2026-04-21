package ru.tuigildina.util;

import java.util.Scanner;

/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/**
 * Утилитный класс для безопасного ввода данных с клавиатуры.
 * Содержит методы для ввода целых, положительных целых,
 * строковых и вещественных значений с проверкой корректности.
 */
public class Correct {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Запрашивает у пользователя целое число.
   * В случае ошибки ввода повторяет запрос.
   *
   * @param message текст приглашения ко вводу
   * @return корректно введённое целое число
   */
  public static int inputInt(String message) {
    while (true) {
      System.out.print(message);
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        System.out.println("Ошибка ввода! Введите целое число.");
        scanner.next();
      }
    }
  }

  /**
   * Запрашивает у пользователя положительное целое число.
   * Если число неположительное, повторяет запрос.
   *
   * @param message текст приглашения ко вводу
   * @return корректно введённое положительное целое число
   */
  public static int inputPositiveInt(String message) {
    while (true) {
      int x = inputInt(message);
      /* FIXME: Фигурные скобки нужны даже для однострочных операторов */
//    if (x > 0) return x;
      if (x > 0) {
        return x;
      }
      System.out.println("Число должно быть положительным.");
    }
  }

  /**
   * Запрашивает у пользователя строку.
   *
   * @param message текст приглашения ко вводу
   * @return введённая строка
   */
  public static String inputString(String message) {
    System.out.print(message);
    return scanner.next();
  }

  /**
   * Запрашивает у пользователя вещественное число.
   * В случае ошибки ввода повторяет запрос.
   *
   * @param message текст приглашения ко вводу
   * @return корректно введённое вещественное число
   */
  public static double inputDouble(String message) {
    while (true) {
      System.out.print(message);
      if (scanner.hasNextDouble()) {
        return scanner.nextDouble();
      } else {
        System.out.println("Ошибка ввода! Введите вещественное число.");
        scanner.next();
      }
    }
  }
}
