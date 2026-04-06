/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 *  3. Ненужные комментарии
 */

import java.util.Scanner;

/* FIXME: Не хватало javadoc */
/**
 * Класс, содержащий методы проверки пользовательского ввода.
 * Предоставляет проверки строк и числовых значений с повторным запросом данных.
 */
public class GlobalVerification {
  private static Scanner scanner = new Scanner(System.in);
  /**
   * Считывает строку из консоли, проверяя что она содержит только буквы и пробелы.
   * Цикл продолжается до получения корректного ввода.
   *
   * @return строка без цифр и специальных символов, обрезанная от пробелов
   */
  public static String stringWithoutNum() {
    while(true) {
      String input = scanner.nextLine();

      if (input == null || input.trim().isEmpty()) {
        System.out.println("Поле не может быть пустым! Пожалуйста, введите данные: ");
        continue;
      }

      if (input.matches("^[a-zA-Zа-яА-ЯёЁ\\s]+$")) {
        return input.trim();
      }
      System.out.println("Некорректный ввод! ФИО должно содержать только буквы. Введите заново: ");
    }
  }

  /**
   * Считывает число из консоли, проверяя что оно находится в допустимом диапазоне.
   * Цикл продолжается до получения корректного ввода.
   *
   * @return число в диапазоне от 135 до 240
   */
  public static int numberNum() {
    while(true) {
      /* FIXME: Нет обработки исключений */
      /*int number = scanner.nextInt();
      scanner.nextLine();
      if (number >= 135 && number <= 240) {
        return number;
      }
      System.out.println("Введите положительное число от 135: ");*/
      String input = scanner.nextLine().trim();
      try {
        int number = Integer.parseInt(input);
        if (number >= 135 && number <= 240) {
          return number;
        }
        System.out.println("Ошибка: введите число от 135 до 240:");
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: введите целое число без лишних символов:");
      }
    }
  }

  /**
   * Считывает положительное число из консоли.
   * Цикл продолжается до получения корректного ввода.
   *
   * @return положительное число (>= 1)
   */
  public static int numberNumMiu() {
    while(true) {
      /* FIXME: Нет обработки исключений */
      /*int number = scanner.nextInt();
      scanner.nextLine();
      if (number >= 1) {
        return number;
      }
      System.out.println("Введите положительное число от 1: ");*/
      String input = scanner.nextLine().trim();
      try {
        int number = Integer.parseInt(input);
        if (number >= 1) {
          return number;
        }
        System.out.println("Ошибка: введите число не меньше 1:");
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: введите целое число без лишних символов:");
      }
    }
  }

  /* FIXME: Нет проверки на ввод числа */
  /**
   * Безопасное чтение целого числа с защитой от некорректного ввода.
   * Повторяет запрос, пока пользователь не введёт корректное число.
   */
  public static int safeInt() {
    while (true) {
      try {
        int number = Integer.parseInt(scanner.nextLine().trim());
        return number;
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: введите целое число!");
      }
    }
  }
}