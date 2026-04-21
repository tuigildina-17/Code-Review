package ru.tuigildina.math;

/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/**
 * Класс, представляющий обычное вещественное число.
 * Используется как один из типов, поддерживающих интерфейс Summable.
 */
public class RealNumber implements Summable {

  private final double value;

  /**
   * Создаёт объект, представляющий вещественное число.
   *
   * @param value числовое значение
   */
  public RealNumber(double value) {
    this.value = value;
  }

  /**
   * Возвращает значение числа в виде double.
   *
   * @return числовое значение
   */
  @Override
  public double toDouble() {
    return value;
  }
}