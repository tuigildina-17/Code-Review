package ru.tuigildina.city;

import java.util.HashMap;
import java.util.Map;

/**
 * FIXME:
 * 1. Используется табуляция
 * 2. Не хватает Javadoс
 */

/**
 * Класс, представляющий город.
 * Хранит имя города и список дорог до других городов с указанием стоимости.
 */
public class City {
  private final String name;
  private final Map<City, Integer> roads;

  /**
   * Создаёт город с указанным именем.
   *
   * @param name имя города
   */
  public City(String name) {
    this.name = name;
    this.roads = new HashMap<>();
  }

  /**
   * Добавляет дорогу из текущего города в указанный город.
   *
   * @param to город, в который ведёт дорога
   * @param cost стоимость дороги
   */
  public void addRoad(City to, int cost) {
    roads.put(to, cost);
  }

  /**
   * Удаляет дорогу из текущего города в указанный город.
   *
   * @param to город, дорога к которому должна быть удалена
   */
  public void removeRoad(City to) {
    roads.remove(to);
  }

  /**
   * Возвращает карту дорог текущего города.
   * Ключ — город назначения, значение — стоимость дороги.
   *
   * @return карта дорог
   */
  public Map<City, Integer> getRoads() {
    return roads;
  }

  /**
   * Возвращает внутреннюю карту дорог.
   * Используется подклассами для прямого доступа.
   *
   * @return карта дорог
   */
  protected Map<City, Integer> getRoadsInternal() {
    return roads;
  }

  /**
   * Возвращает имя города.
   *
   * @return имя города
   */
  public String getName() {
    return name;
  }

  /**
   * Сравнивает два города по набору дорог.
   * Города считаются равными, если имеют одинаковые дороги
   * к городам с одинаковыми именами и одинаковой стоимостью.
   *
   * @param o объект для сравнения
   * @return true, если города равны по структуре дорог, иначе false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof City other)) return false;

    if (this.roads.size() != other.roads.size()) return false;

    for (Map.Entry<City, Integer> entry : this.roads.entrySet()) {
      String thisNeighborName = entry.getKey().getName();
      Integer thisCost = entry.getValue();

      boolean found = false;
      for (Map.Entry<City, Integer> otherEntry : other.roads.entrySet()) {
        if (thisNeighborName.equals(otherEntry.getKey().getName()) &&
            thisCost.equals(otherEntry.getValue())) {
          found = true;
          break;
        }
      }

      if (!found) return false;
    }

    return true;
  }

  /**
   * Вычисляет хеш‑код города на основе его имени и дорог.
   *
   * @return хеш‑код города
   */
  @Override
  public int hashCode() {
    int result = name.hashCode();
    for (Map.Entry<City, Integer> entry : roads.entrySet()) {
      result = 31 * result + entry.getKey().getName().hashCode();
      result = 31 * result + entry.getValue().hashCode();
    }
    return result;
  }

  /**
   * Возвращает строковое представление города и его дорог.
   *
   * @return строковое представление города
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(name + " → ");
    for (Map.Entry<City, Integer> e : roads.entrySet()) {
      sb.append(e.getKey().name).append("(").append(e.getValue()).append(") ");
    }
    return sb.toString();
  }
}
