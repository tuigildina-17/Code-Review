package ru.tuigildina.city;

/**
 * FIXME:
 * 1. Используется табуляция
 * 2. Не хватает Javadoс
 */

/**
 * Класс города с автоматическим созданием двусторонних дорог.
 * При добавлении дороги в другой город автоматически создаёт
 * обратную дорогу, если её ещё нет.
 */
public class BidirectionalCity extends City {

  /**
   * Создаёт двусторонний город с указанным именем.
   *
   * @param name имя города
   */
  public BidirectionalCity(String name) {
    super(name);
  }

  /**
   * Добавляет дорогу в указанный город и автоматически создаёт
   * обратную дорогу, если она отсутствует.
   * Если дорога уже существует, повторно не добавляется.
   *
   * @param destination город назначения
   * @param cost стоимость дороги
   */
  @Override
  /* FIXME: Название параметра неясное */
// public void addRoad(City to, int cost) {
//
//   if (!getRoadsInternal().containsKey(to)) {
//     super.addRoad(to, cost);
//   }
//
//   if (this != to && !to.getRoads().containsKey(this)) {
//     to.getRoads().put(this, cost);
  public void addRoad(City destination, int cost) {

      if (!getRoadsInternal().containsKey(destination)) {
          super.addRoad(destination, cost);
      }

      if (this != destination && !destination.getRoads().containsKey(this)) {
          destination.getRoads().put(this, cost);
    }
  }
}