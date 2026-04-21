package ru.tuigildina.math;

/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/**
 * Утилитный класс для выполнения операций суммирования.
 * Позволяет складывать объекты, реализующие интерфейс Summable.
 */
public class SumUtil {

  /**
   * Складывает все переданные значения, преобразуя каждое из них
   * в тип double с помощью метода toDouble().
   *
   * @param values набор объектов, поддерживающих интерфейс Summable
   * @return сумма всех значений
   */
  public static double sum(Summable... values) {
    double result = 0;
    for (Summable s : values) {
      result += s.toDouble();
    }
    return result;
  }
}