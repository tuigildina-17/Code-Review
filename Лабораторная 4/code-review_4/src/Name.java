/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 */

/* FIXME: Не хватало javadoc */
/**
 * Класс, представляющий имя человека.
 * Поддерживает различные варианты задания ФИО: полное, частичное или только личное имя.
 */
class Name {
  private String lastName;
  private String firstName;
  private String middleName;

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
   * Возвращает личное имя.
   *
   * @return имя
   */
  public String getFirstName() {
    return firstName;
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
   * Создаёт объект имени с фамилией, именем и отчеством.
   *
   * @param lastName   фамилия
   * @param firstName  имя
   * @param middleName отчество
   */
  public Name(String lastName, String firstName, String middleName) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт объект имени с фамилией и именем.
   *
   * @param lastName  фамилия
   * @param firstName имя
   */
  public Name(String lastName, String firstName) {
    this(lastName, firstName, null);
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт объект имени, содержащий только личное имя.
   *
   * @param firstName имя
   */
  public Name(String firstName) {
    this(null, firstName, null);
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Проверяет, задана ли строка (не null и не пустая).
   *
   * @param name строка для проверки
   * @return true, если строка содержит символы; false иначе
   */
  private boolean isSet(String name) {
    return name != null && !name.trim().isEmpty();
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление имени.
   * Формирует строку из заданных частей ФИО в правильном порядке.
   *
   * @return строка вида "Фамилия Имя Отчество"
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    if (isSet(lastName)) {
      result.append(lastName);
    }

    if (isSet(firstName)) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(firstName);
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