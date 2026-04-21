package ru.borisova.cats;

/**
 * Кот, который умеет мяукать.
 */
public class Cat implements Meowable {

  private final String name;

  /**
   * Создаёт кота с указанным именем.
   *
   * @param name имя кота
   */
  public Cat(String name) {
    this.name = name;
  }

  /**
   * Мяукает, выводя имя кота и звук «мяу!».
   */
  @Override
  public void meow() {
    System.out.println(name + ": мяу!");
  }
}