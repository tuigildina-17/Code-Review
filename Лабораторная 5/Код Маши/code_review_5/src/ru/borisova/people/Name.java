package ru.borisova.people;

/**
 * Неизменяемое имя человека, содержащее имя и фамилию.
 */
public final class Name {

  private final String first;
  private final String last;

  /**
   * Создаёт объект имени.
   * Требует, чтобы хотя бы одно поле (имя или фамилия) было непустым.
   *
   * @param first имя (может быть null или пустым)
   * @param last  фамилия (может быть null или пустым)
   * @throws IllegalArgumentException если оба поля пустые
   */
  public Name(String first, String last) {
    if ((first == null || first.isEmpty())
        && (last == null || last.isEmpty())) {
      throw new IllegalArgumentException("Имя не может быть пустым");
    }
    this.first = first;
    this.last = last;
  }

  /**
   * Возвращает строковое представление имени.
   * Пустые части заменяются на пустую строку.
   */
  @Override
  public String toString() {
    return (first != null ? first : "") + " "
        + (last != null ? last : "");
  }
}