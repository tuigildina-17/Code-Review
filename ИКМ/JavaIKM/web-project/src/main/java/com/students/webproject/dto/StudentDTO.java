package com.students.webproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * Объект передачи данных для работы со студентами.
 * Используется для передачи данных между формами и контроллером.
 * Дата рождения передается в виде трёх строк (день, месяц, год).
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

  /**
   * Идентификатор студента.
   */
  private Long id;

  /**
   * Идентификатор группы, к которой относится студент.
   */
  @NotNull(message = "Группа должна быть выбрана")
  private Long groupId;

  /**
   * Фамилия студента.
   */
  @NotBlank(message = "Фамилия не может быть пустой")
  private String lastName;

  /**
   * Имя студента.
   */
  @NotBlank(message = "Имя не может быть пустым")
  private String firstName;

  /**
   * Отчество студента (необязательное поле).
   */
  private String middleName;

  /**
   * День рождения (2 цифры).
   */
  @NotBlank(message = "День рождения обязателен")
  @Pattern(regexp = "\\d{2}", message = "День должен состоять из 2 цифр")
  private String birthDay;

  /**
   * Месяц рождения (2 цифры).
   */
  @NotBlank(message = "Месяц рождения обязателен")
  @Pattern(regexp = "\\d{2}", message = "Месяц должен состоять из 2 цифр")
  private String birthMonth;

  /**
   * Год рождения (4 цифры).
   */
  @NotBlank(message = "Год рождения обязателен")
  @Pattern(regexp = "\\d{4}", message = "Год должен состоять из 4 цифр")
  private String birthYear;

  /**
   * Название группы (для отображения, не редактируется).
   */
  private String groupName;
}