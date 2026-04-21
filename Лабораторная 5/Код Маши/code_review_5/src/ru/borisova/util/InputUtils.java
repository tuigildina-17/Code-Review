package ru.borisova.util;

import java.util.Scanner;

/**
 * Утилиты для безопасного чтения пользовательского ввода.
 * Предотвращают ошибки формата и пустые строки.
 */
public class InputUtils {

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Считывает непустую строку.
   *
   * @param message приглашение к вводу
   * @return строка, не являющаяся пустой или пробельной
   */
  public static String readNonEmptyString(String message) {
    System.out.print(message);
    String s = scanner.nextLine();

    while (s == null || s.isBlank()) {
      System.out.print("Ошибка: строка не может быть пустой. Повторите ввод: ");
      s = scanner.nextLine();
    }
    return s;
  }

  /**
   * Считывает целое число. При ошибке предлагает повторить ввод.
   *
   * @param message приглашение к вводу
   * @return корректное целое число
   */
  public static int readInt(String message) {
    System.out.print(message);
    while (true) {
      String s = scanner.nextLine();
      try {
        return Integer.parseInt(s);
      } catch (NumberFormatException e) {
        System.out.print("Ошибка: введите целое число: ");
      }
    }
  }

  /**
   * Считывает имя, состоящее только из букв.
   * Не допускает пустые строки и символы, отличные от букв.
   *
   * @param message приглашение к вводу
   * @return корректное имя
   */
  public static String readName(String message) {
    System.out.print(message);
    String s = scanner.nextLine();

    while (true) {
      if (s == null || s.isBlank()) {
        System.out.print("Ошибка: имя не может быть пустым. Введите снова: ");
      } else if (!s.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
        System.out.print("Ошибка: имя должно содержать только буквы. Введите снова: ");
      } else {
        return s;
      }
      s = scanner.nextLine();
    }
  }

  /**
   * Считывает целое число в указанном диапазоне.
   *
   * @param message приглашение к вводу
   * @param min   минимально допустимое значение
   * @param max   максимально допустимое значение
   * @return корректное число в диапазоне
   */
  public static int readIntInRange(String message, int min, int max) {
    System.out.print(message);
    while (true) {
      String s = scanner.nextLine();
      try {
        int value = Integer.parseInt(s);
        if (value < min || value > max) {
          System.out.print(
              "Ошибка: число должно быть в диапазоне [" + min + ", " + max + "]. Повторите ввод: ");
        } else {
          return value;
        }
      } catch (NumberFormatException e) {
        System.out.print("Ошибка: введите целое число: ");
      }
    }
  }
}