package com.students.webproject.dto;

import com.students.webproject.entity.EducationForm;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Объект передачи данных для работы с группами.
 * Используется для отображения и редактирования данных группы в веб-слое.
 * Содержит как основные поля, так и вычисляемые значения.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDTO {

  /**
   * Идентификатор группы.
   */
  private Long id;

  /**
   * Идентификатор факультета, к которому относится группа.
   */
  @NotNull(message = "Факультет должен быть выбран")
  private Long facultyId;

  /**
   * Название группы.
   */
  @NotBlank(message = "Название группы не может быть пустым")
  private String name;

  /**
   * Форма обучения.
   */
  @NotNull(message = "Форма обучения должна быть выбрана")
  private EducationForm educationForm;

  // ФИО тьютора (все поля необязательные)

  private String tutorLastName;
  private String tutorFirstName;
  private String tutorMiddleName;

  // ФИО старосты (все поля необязательные)

  private String headmanLastName;
  private String headmanFirstName;
  private String headmanMiddleName;

  /**
   * Количество студентов в группе (вычисляется автоматически).
   */
  private long studentCount;

  /**
   * Название факультета (для отображения, не редактируется).
   */
  private String facultyName;
}