/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/**
 * Класс, представляющий кота.
 * Содержит имя кота и методы для вывода мяуканья.
 */
class Cat {
  private String name;

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает имя кота.
   *
   * @return имя кота
   */
  public String getName() {
  return name;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт нового кота с указанным именем.
   *
   * @param name имя кота
   */
  public Cat(String name) {
    this.name = name;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление кота.
   *
   * @return строка вида "кот: <имя>"
   */
  @Override
  public String toString() {
    return "кот: " + name;
  }

  /**
   * Выводит мяуканье кота в консоль.
   * Формат вывода: "имя_кота: мяу!"
   */
  public void meow() {
    System.out.println(name + ": мяу!");
  }

  /**
   * Выводит многократное мяуканье кота в консоль.
   * Кот мяукает указанное количество раз через дефис.
   *
   * @param n количество мяуканий. Если n <= 0, выводится многоточие
   */
  public void meow(int n) {
    if (n <= 0) {
      System.out.println(name + ": ...");
      return;
    }

    StringBuilder meowString = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        meowString.append("-");
      }
      meowString.append("мяу");
    }
    meowString.append("!");
    System.out.println(name + ": " + meowString.toString());
  }
}