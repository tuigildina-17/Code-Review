package ru.tuigildina.math;

/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/**
 * Класс, представляющий дробь в виде числителя и знаменателя.
 * Дробь является неизменяемой, автоматически сокращается и
 * всегда хранится со знаменателем больше нуля.
 * Реализует интерфейс Summable и наследует методы класса Number.
 */
public final class Fraction extends Number implements Summable {
  private final int numerator;
  private final int denominator;

  /**
   * Создаёт дробь с указанными числителем и знаменателем.
   * Выполняет проверку знаменателя, нормализацию знака и сокращение дроби.
   *
   * @param numerator числитель дроби
   * @param denominator знаменатель дроби
   * @throws IllegalArgumentException если знаменатель равен нулю
   */
  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
    }

    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    int gcd = gcd(Math.abs(numerator), denominator);
    this.numerator = numerator / gcd;
    this.denominator = denominator / gcd;
  }

  /**
   * Вычисляет наибольший общий делитель двух чисел.
   *
   * @param a первое число
   * @param b второе число
   * @return наибольший общий делитель
   */
  private int gcd(int a, int b) {
    while (b != 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  /**
   * Складывает текущую дробь с другой дробью.
   *
   * @param other дробь, которую нужно прибавить
   * @return новая дробь — результат сложения
   */
  public Fraction add(Fraction other) {
    return new Fraction(
        this.numerator * other.denominator + other.numerator * this.denominator,
        this.denominator * other.denominator
    );
  }

  /**
   * Вычитает другую дробь из текущей.
   *
   * @param other дробь, которую нужно вычесть
   * @return новая дробь — результат вычитания
   */
  public Fraction subtract(Fraction other) {
    return new Fraction(
        this.numerator * other.denominator - other.numerator * this.denominator,
        this.denominator * other.denominator
    );
  }

  /**
   * Умножает текущую дробь на другую дробь.
   *
   * @param other дробь-множитель
   * @return новая дробь — результат умножения
   */
  public Fraction multiply(Fraction other) {
    return new Fraction(
        this.numerator * other.numerator,
        this.denominator * other.denominator
    );
  }

  /**
   * Делит текущую дробь на другую дробь.
   *
   * @param other дробь-делитель
   * @return новая дробь — результат деления
   * @throws ArithmeticException если числитель делителя равен нулю
   */
  public Fraction divide(Fraction other) {
    if (other.numerator == 0) {
      throw new ArithmeticException("Деление на ноль невозможно");
    }
    return new Fraction(
        this.numerator * other.denominator,
        this.denominator * other.numerator
    );
  }

  /**
   * Возвращает значение дроби в виде double.
   *
   * @return значение дроби
   */
  public double toDouble() {
    return (double) numerator / denominator;
  }

  /**
   * Возвращает значение дроби, приведённое к типу int.
   * Дробная часть отбрасывается.
   *
   * @return целочисленное представление дроби
   */
  @Override
  public int intValue() {
    return numerator / denominator;
  }

  /**
   * Возвращает значение дроби, приведённое к типу long.
   * Дробная часть отбрасывается.
   *
   * @return значение дроби в формате long
   */
  @Override
  public long longValue() {
    return (long) numerator / denominator;
  }

  /**
   * Возвращает значение дроби, приведённое к типу float.
   *
   * @return значение дроби в формате float
   */
  @Override
  public float floatValue() {
    return (float) numerator / denominator;
  }

  /**
   * Возвращает значение дроби, приведённое к типу double.
   *
   * @return значение дроби в формате double
   */
  @Override
  public double doubleValue() {
    return (double) numerator / denominator;
  }

  /**
   * Возвращает значение дроби, приведённое к типу short.
   * Дробная часть отбрасывается.
   *
   * @return значение дроби в формате short
   */
  @Override
  public short shortValue() {
    return (short) intValue();
  }

  /**
   * Возвращает значение дроби, приведённое к типу byte.
   * Дробная часть отбрасывается.
   *
   * @return значение дроби в формате byte
   */
  @Override
  public byte byteValue() {
    return (byte) intValue();
  }

  /**
   * Возвращает строковое представление дроби в формате "числитель/знаменатель".
   *
   * @return строковое представление дроби
   */
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }
}