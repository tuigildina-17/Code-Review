/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 *  3. Ненужные комментарии
 */

/* FIXME: Не хватало javadoc */
/**
 * Класс, представляющий имя человека.
 * Поддерживает различные варианты задания имени: только личное имя,
 * имя + фамилия или полное ФИО.
 */
class NameEx4 {
  private String firstName;
  private String lastName;
  private String middleName;

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает личное имя.
   *
   * @return личное имя
   */
  public String getFirstName() {
    return firstName;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает фамилию.
   *
   * @return фамилия или null, если не задана
   */
  public String getLastName() {
    return lastName;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает отчество.
   *
   * @return отчество или null, если не задано
   */
  public String getMiddleName() {
    return middleName;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт объект имени, содержащий только личное имя.
   *
   * @param firstName личное имя
   */
  public NameEx4(String firstName) {
    this.firstName = firstName;
    this.lastName = null;
    this.middleName = null;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт объект имени, содержащий личное имя и фамилию.
   *
   * @param firstName личное имя
   * @param lastName  фамилия
   */
  public NameEx4(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = null;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт объект имени, содержащий личное имя, фамилию и отчество.
   *
   * @param firstName  личное имя
   * @param lastName   фамилия
   * @param middleName отчество
   */
  public NameEx4(String firstName, String lastName, String middleName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
  }

  /**
   * Проверяет, что строка не null и не пустая.
   *
   * @param name проверяемая строка
   * @return true если строка не null и не пустая, иначе false
   */
  private boolean isSet(String name) {
    return name != null && !name.trim().isEmpty();
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление имени.
   * Формирует строку из заданных частей ФИО в корректном порядке.
   *
   * @return строка вида "Имя Фамилия Отчество"
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    if (isSet(firstName)) {
      result.append(firstName);
    }
    if (isSet(lastName)) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(lastName);
    }
    if (isSet(middleName)) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(middleName);
    }
    return result.toString();
  }
}