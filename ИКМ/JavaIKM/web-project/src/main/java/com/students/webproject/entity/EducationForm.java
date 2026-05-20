package com.students.webproject.entity;

/**
 * Перечисление форм обучения для группы.
 * Используется для указания режима обучения студентов.
 *
 * @author Динара Туйгильдина
 * @version 1.0
 */
public enum EducationForm {
  OCHNAYA("Очная"),
  OCHNO_ZAOCHNAYA("Очно-заочная"),
  ZAOCHNAYA("Заочная");

  private final String title;

  /**
   * Конструктор формы обучения.
   *
   * @param title текстовое представление формы
   */
  EducationForm(String title) {
    this.title = title;
  }

  /**
   * Получение текстового представление формы обучения.
   *
   * @return строка с названием формы
   */
  public String getTitle() {
    return title;
  }
}