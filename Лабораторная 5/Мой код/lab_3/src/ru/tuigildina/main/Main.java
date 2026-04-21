package ru.tuigildina.main;

import ru.tuigildina.math.Fraction;
import ru.tuigildina.util.Correct;
import ru.tuigildina.city.City;
import ru.tuigildina.city.BidirectionalCity;
import ru.tuigildina.city.Route;
import ru.tuigildina.math.RealNumber;
import ru.tuigildina.math.SumUtil;
import ru.tuigildina.math.Summable;
import ru.tuigildina.geometry.Point;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * FIXME:
 * 1. Используется табуляция
 * 2. Не хватает Javadoс
 */

/**
 * Главный класс приложения.
 * Выполняет демонстрацию всех заданий: работу с дробями, графом городов,
 * построением маршрута, суммированием чисел, сравнением городов
 * и клонированием точки.
 */
public class Main {
  /**
   * Преобразует строковые значения в целые числа и выполняет
   * возведение первого числа в степень второго.
   *
   * @param xStr строковое представление основания степени
   * @param yStr строковое представление показателя степени
   * @return результат возведения числа x в степень y
   */
  public static double powFromStrings(String xStr, String yStr) {
    int x = parseInt(xStr);
    int y = parseInt(yStr);
    return pow(x, y);
  }
  /**
   * Точка входа в программу.
   * Последовательно демонстрирует выполнение всех заданий:
   * создание и операции над дробями, работа с графом городов,
   * построение маршрута, создание запретной дроби, использование дроби как Number,
   * суммирование чисел, сравнение городов и клонирование точки.
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {

    if (args.length >= 2) {
      double result = powFromStrings(args[0], args[1]);
      System.out.println("7.3.Результат возведения в степень: " + result);
    } else {
      /* FIXME: Строка больше 100 символов */
//    System.out.println("Для демонстрации возведения в степень передайте 2 аргумента командной строки.");
      System.out.println("Для демонстрации возведения в степень передайте 2 аргумента " +
              "командной строки.");
    }

    Fraction f1 = null;
    Fraction f2 = null;

    System.out.println("1.4.Дроби. ");
    System.out.println("Создание первой дроби: ");
    while (f1 == null) {
      try {
        int n1 = Correct.inputInt("Введите числитель: ");
        int d1 = Correct.inputInt("Введите знаменатель: ");
        f1 = new Fraction(n1, d1);
      } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
        System.out.println("Попробуйте снова.\n");
      }
    }

    System.out.println("Создание второй дроби: ");
    while (f2 == null) {
      try {
        int n2 = Correct.inputInt("Введите числитель: ");
        int d2 = Correct.inputInt("Введите знаменатель: ");
        f2 = new Fraction(n2, d2);
      } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
        System.out.println("Попробуйте снова.\n");
      }
    }

    System.out.println("\nДроби: ");
    System.out.println("Первая дробь: " + f1);
    System.out.println("Вторая дробь: " + f2);

    System.out.println("\nОперации: ");
    System.out.println("Сложение: " + f1.add(f2));
    System.out.println("Вычитание: " + f1.subtract(f2));
    System.out.println("Умножение: " + f1.multiply(f2));

    Fraction divisionResult = null;
    while (divisionResult == null) {
      try {
        divisionResult = f1.divide(f2);
        System.out.println("Деление: " + divisionResult);
      } catch (ArithmeticException e) {
        System.out.println("Ошибка: " + e.getMessage());
        System.out.println("Введите вторую дробь заново (числитель не должен быть 0).");

        int n2 = Correct.inputInt("Введите числитель: ");
        int d2 = Correct.inputInt("Введите знаменатель: ");

        try {
          f2 = new Fraction(n2, d2);
        } catch (IllegalArgumentException ex) {
          System.out.println("Ошибка: " + ex.getMessage());
          System.out.println("Попробуйте снова.\n");
          f2 = null;
        }
      }
    }

    System.out.println("1.10.Дороги. ");
    City A = new City("A");
    City B = new City("B");
    City C = new City("C");
    City D = new City("D");
    City E = new City("E");
    City F = new City("F");

    A.addRoad(F, 1);
    A.addRoad(D, 6);
    D.addRoad(A, 6);
    A.addRoad(B, 5);
    B.addRoad(A, 5);
    B.addRoad(C, 3);
    C.addRoad(B, 3);
    C.addRoad(D, 4);
    D.addRoad(C, 4);
    D.addRoad(E, 2);
    E.addRoad(F, 2);
    F.addRoad(E, 2);
    F.addRoad(B, 1);

    System.out.println("Карта дорог: ");
    printAll(A, B, C, D, E, F);

    System.out.println("\nДобавление новой дороги: ");
    String from = Correct.inputString("Из какого города: ");
    String to = Correct.inputString("В какой город: ");
    int cost = Correct.inputPositiveInt("Стоимость дороги: ");

    City fromCity = getCity(from, A, B, C, D, E, F);
    City toCity = getCity(to, A, B, C, D, E, F);

    /* FIXME: Нет проверки на существование дороги и на дорогу из города в тот же город */
//  if (fromCity != null && toCity != null) {
//    fromCity.addRoad(toCity, cost);
//  } else {
//    System.out.println("Город не найден.");
//  }
    if (fromCity == null || toCity == null) {
      System.out.println("Город не найден.");
    }
    else if (fromCity == toCity) {
      System.out.println("Нельзя добавить дорогу в тот же самый город.");
    }
    else if (fromCity.getRoads().containsKey(toCity)) {
      System.out.println("Дорога уже существует. Стоимость обновлена.");
      fromCity.addRoad(toCity, cost);
    }
    else {
      fromCity.addRoad(toCity, cost);
    }

    System.out.println("\nУдаление дороги: ");
    String delFrom = Correct.inputString("Из какого города удалить дорогу: ");
    String delTo = Correct.inputString("Дорогу в какой город удалить: ");

    City delFromCity = getCity(delFrom, A, B, C, D, E, F);
    City delToCity = getCity(delTo, A, B, C, D, E, F);

    if (delFromCity != null && delToCity != null) {
      delFromCity.removeRoad(delToCity);
    } else {
      System.out.println("Такой дороги нет.");
    }

    System.out.println("\n Итоговая карта ");
    printAll(A, B, C, D, E, F);

    System.out.println("2.5.Маршрут.");
    String startName = Correct.inputString("Введите город начала: ");
    City startCity = getCity(startName, A, B, C, D, E, F);

    String endName = Correct.inputString("Введите город конца: ");
    City endCity = getCity(endName, A, B, C, D, E, F);

    if (startCity == null || endCity == null) {
      System.out.println("Один из городов не найден. Маршрут построить невозможно.");
    } else {
      Route route = new Route(startCity, endCity);
      System.out.println("Маршрут " + startCity.getName() + " → " + endCity.getName() + ":");
      System.out.println(route);
    }

    System.out.println("\n3.1.Запретная дробь.");

    int num = Correct.inputInt("Введите числитель новой дроби: ");
    int den = Correct.inputInt("Введите знаменатель новой дроби: ");

    try {
      Fraction forbidden = new Fraction(num, den);
      System.out.println("Создана дробь: " + forbidden);
      System.out.println("Эта дробь неизменяема и не может иметь подклассов.");
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }

    System.out.println("\n4.2.Дробь это число.");

    int numN = Correct.inputInt("Введите числитель дроби: ");
    int denN = Correct.inputInt("Введите знаменатель дроби: ");

    Fraction f = null;
    while (f == null) {
      try {
        f = new Fraction(numN, denN);
      } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
        numN = Correct.inputInt("Введите числитель дроби: ");
        denN = Correct.inputInt("Введите знаменатель дроби: ");
      }
    }

    System.out.println("Дробь: " + f);
    System.out.println("double: " + f.doubleValue());
    System.out.println("int: " + f.intValue());
    System.out.println("float: " + f.floatValue());

    System.out.println("5.1.Сложение.");
    int count = Correct.inputPositiveInt("Сколько чисел хотите сложить? ");

    Summable[] values = new Summable[count];

    for (int i = 0; i < count; i++) {
      System.out.println("\nЧисло №" + (i + 1));
      System.out.println("1 — обычное число");
      System.out.println("2 — дробь");

      int type = Correct.inputPositiveInt("Выберите тип (1 или 2): ");

      if (type == 1) {
        double realVal = Correct.inputDouble("Введите вещественное число: ");
        values[i] = new RealNumber(realVal);

      } else if (type == 2) {
        int fracNum = Correct.inputInt("Введите числитель: ");
        int fracDen = Correct.inputInt("Введите знаменатель: ");

        try {
          values[i] = new Fraction(fracNum, fracDen);
        } catch (IllegalArgumentException e) {
          System.out.println("Ошибка: " + e.getMessage());
          i--;
        }

      } else {
        System.out.println("Неверный выбор. Повторите.");
        i--;
      }
    }

    double result = SumUtil.sum(values);
    System.out.println("\nРезультат сложения: " + result);

    System.out.println("\n6.5.Сравнение городов.");

    City g = new City("G");
    City h = new City("H");

    g.addRoad(h, 5);
    h.addRoad(g, 5);

    BidirectionalCity k = new BidirectionalCity("G");
    BidirectionalCity l = new BidirectionalCity("H");

    k.addRoad(l, 5);

    String city1Name = Correct.inputString("Введите название первого города: ");
    String city2Name = Correct.inputString("Введите название второго города: ");

    City city1 = getCity(city1Name, A, B, C, D, E, F, g, h, k, l);
    City city2 = getCity(city2Name, A, B, C, D, E, F, g, h, k, l);

    if (city1 == null || city2 == null) {
      System.out.println("Один из городов не найден.");
    } else {
      System.out.println("Города равны? " + city1.equals(city2));
    }

    System.out.println("\n8.4.Клонирование точки.");

    double xVal = Correct.inputDouble("Введите X точки: ");
    double yVal = Correct.inputDouble("Введите Y точки: ");

    Point originalPoint = new Point(xVal, yVal);
    Point clonedPoint = originalPoint.clone();

    System.out.println("Оригинал: " + originalPoint);
    System.out.println("Клон:   " + clonedPoint);

    System.out.println("Равны ли точки? " + originalPoint.equals(clonedPoint));
    System.out.println("Это один и тот же объект? " + (originalPoint == clonedPoint));
  }

  /**
   * Ищет город по имени среди переданного набора городов.
   * Сравнение выполняется без учета регистра.
   *
   * @param name имя искомого города
   * @param cities список городов, среди которых выполняется поиск
   * @return найденный город или null, если город отсутствует
   */
  private static City getCity(String name, City... cities) {
    for (City c : cities) {
      if (c.getName().equalsIgnoreCase(name)) return c;
    }
    return null;
  }

  /**
   * Выводит в консоль информацию обо всех переданных городах.
   * Для каждого города вызывается его метод toString().
   *
   * @param cities города, которые необходимо вывести
   */
  private static void printAll(City... cities) {
    for (City c : cities) {
      System.out.println(c);
    }
  }
}