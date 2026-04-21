package ru.borisova.people;

/**
 * Человек с именем, фамилией, ростом и ссылкой на отца.
 */
public class Human {

  private String name;
  private String surname;
  private int height;
  private Human father;

  /**
   * Создаёт человека с указанными параметрами.
   *
   * @param name  имя
   * @param surname фамилия
   * @param height  рост
   * @param father  объект отца (null, если отец неизвестен)
   */
  public Human(String name, String surname, int height, Human father) {
    this.name = name;
    this.surname = surname;
    this.height = height;
    this.father = father;
  }

  /**
   * Изменяет рост человека.
   *
   * @param height новый рост
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Возвращает строковое представление человека.
   * Если отец указан, добавляет информацию о нём.
   */
  @Override
  public String toString() {
    if (father == null) {
      return name + " " + surname + ", рост: " + height;
    } else {
      return name + " " + surname + ", рост: " + height
          + ", отец: " + father.name + " " + father.surname;
    }
  }
}