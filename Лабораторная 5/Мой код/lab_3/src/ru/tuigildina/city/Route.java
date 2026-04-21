package ru.tuigildina.city;

import java.util.*;

/**
 * FIXME:
 * 1. Используется табуляция
 * 2. Не хватает Javadoс
 */

/**
 * Класс, представляющий маршрут между двумя городами.
 * Хранит начальный и конечный города и позволяет получить путь между ними.
 * Путь строится с помощью поиска в ширину (BFS).
 */
public class Route {
  private City start;
  private City end;

  /**
   * Создаёт маршрут между двумя городами.
   *
   * @param start город начала маршрута
   * @param end город конца маршрута
   * @throws IllegalArgumentException если один из городов равен null
   */
  public Route(City start, City end) {
    if (start == null || end == null)
      throw new IllegalArgumentException("Начало и конец маршрута не могут быть null");
    this.start = start;
    this.end = end;
  }

  /**
   * Устанавливает новый начальный город маршрута.
   *
   * @param start новый город начала
   * @throws IllegalArgumentException если значение равно null
   */
  public void setStart(City start) {
    if (start == null)
      throw new IllegalArgumentException("Начало маршрута не может быть null");
    this.start = start;
  }

  /**
   * Устанавливает новый конечный город маршрута.
   *
   * @param end новый город конца
   * @throws IllegalArgumentException если значение равно null
   */
  public void setEnd(City end) {
    if (end == null)
      throw new IllegalArgumentException("Конец маршрута не может быть null");
    this.end = end;
  }

  /**
   * Возвращает путь между начальным и конечным городами.
   * Если путь существует, возвращается массив городов в правильном порядке.
   * Если путь отсутствует, возвращается пустой массив.
   *
   * @return массив городов, представляющий маршрут
   */
  public City[] getPath() {
    /* FIXME: Фигурные скобки нужны даже для однострочных операторов */
//   if (start == end) return new City[]{start};
    if (start == end) {
      return new City[]{start};
    }

    Queue<City> queue = new LinkedList<>();
    Map<City, City> parent = new HashMap<>();
    Set<City> visited = new HashSet<>();

    queue.add(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      City current = queue.poll();

      for (City next : current.getRoads().keySet()) {
        if (!visited.contains(next)) {
          visited.add(next);
          parent.put(next, current);
          queue.add(next);

          if (next == end) {
            return buildPath(parent);
          }
        }
      }
    }

    return new City[0];
  }

  /**
   * Восстанавливает путь от конечного города к начальному
   * на основе карты родителей, созданной BFS.
   *
   * @param parent карта соответствия город → родитель
   * @return массив городов, представляющий маршрут
   */
  private City[] buildPath(Map<City, City> parent) {
    List<City> path = new ArrayList<>();
    City cur = end;

    while (cur != null) {
      path.add(cur);
      cur = parent.get(cur);
    }

    Collections.reverse(path);
    return path.toArray(new City[0]);
  }

  /**
   * Возвращает строковое представление маршрута.
   * Если путь не найден, возвращает сообщение об ошибке.
   *
   * @return строковое представление маршрута
   */
  @Override
  public String toString() {
    City[] path = getPath();
    if (path.length == 0) return "Маршрут не найден";

    StringBuilder sb = new StringBuilder();
    for (City c : path) {
      sb.append(c.getName()).append(" ");
    }
    return sb.toString().trim();
  }
}