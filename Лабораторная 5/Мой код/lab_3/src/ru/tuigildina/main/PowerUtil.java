package ru.tuigildina.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * FIXME:
 * 1. Используется табуляция
 * 2. Не хватает Javadoс
 */

/**
 * Утилитный класс для работы с операцией возведения в степень.
 * Содержит метод, принимающий строковые значения и выполняющий
 * преобразование в числа с последующим вычислением степени.
 */
public class PowerUtil {

  /**
   * Преобразует строковые значения в целые числа и выполняет
   * возведение первого числа в степень второго.
   *
   * @param x строковое представление основания степени
   * @param y строковое представление показателя степени
   * @return результат возведения числа x в степень y
   */
  public static double power(String x, String y) {
    int base = parseInt(x);
    int exp = parseInt(y);
    return pow(base, exp);
  }
}