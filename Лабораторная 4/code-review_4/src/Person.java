/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/* FIXME: Не хватало javadoc */
/**
 * Класс, представляющий человека.
 * Содержит имя и рост человека.
 */
class Person {
  private Name name;
  private int height;

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает имя человека.
   *
   * @return объект Name, представляющий имя
   */
  public Name getName() {
    return name;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает рост человека.
   *
   * @return рост в сантиметрах
   */
  public int getHeight() {
    return height;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт нового человека с указанным именем и ростом.
   *
   * @param name   объект Name, представляющий имя человека
   * @param height рост человека в сантиметрах
   */
  public Person(Name name, int height) {
    this.name = name;
    this.height = height;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление человека.
   * Формат: "<ФИО>, рост: <число>"
   *
   * @return строка с описанием человека
   */
  @Override
  public String toString() {
    return name + ", рост: " + height;
  }
}