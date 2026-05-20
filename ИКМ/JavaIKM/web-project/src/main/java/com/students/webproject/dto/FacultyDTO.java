package com.students.webproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Объект передачи данных для работы с факультетами в веб-слое.
 * Используется для передачи данных между контроллером и представлением.
 * Содержит основную информацию о факультете и вычисляемые значения (количество групп и студентов).
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacultyDTO {

  /**
   * Идентификатор факультета.
   */
  private Long id;

  /**
   * Название факультета.
   */
  @NotBlank(message = "Название факультета не может быть пустым")
  private String name;

  /**
   * Фамилия декана (необязательное поле).
   */
  private String deanLastName;

  /**
   * Имя декана (необязательное поле).
   */
  private String deanFirstName;

  /**
   * Отчество декана (необязательное поле).
   */
  private String deanMiddleName;

  /**
   * Количество групп на факультете (вычисляется автоматически).
   */
  private long groupCount;

  /**
   * Количество студентов на факультете (вычисляется автоматически).
   */
  private long studentCount;
}