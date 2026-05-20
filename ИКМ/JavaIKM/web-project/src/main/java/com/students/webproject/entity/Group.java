package com.students.webproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Сущность учебной группы.
 * Связана с факультетом и студентами.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Entity
@Table(name = "student_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

  /**
   * Идентификатор группы.
   *
   * @return уникальный идентификатор группы
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Название группы (например, ФИТ-2025).
   *
   * @return название группы
   */
  @Column(nullable = false)
  private String name;

  /**
   * Форма обучения.
   *
   * @return форма обучения (очная, очно-заочная, заочная)
   */
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EducationForm educationForm;

  /**
   * Фамилия тьютора (необязательное поле).
   *
   * @return фамилия тьютора
   */
  private String tutorLastName;

  /**
   * Имя тьютора (необязательное поле).
   *
   * @return имя тьютора
   */
  private String tutorFirstName;

  /**
   * Отчество тьютора (необязательное поле).
   *
   * @return отчество тьютора
   */
  private String tutorMiddleName;

  /**
   * Фамилия старосты (необязательное поле).
   *
   * @return фамилия старосты
   */
  private String headmanLastName;

  /**
   * Имя старосты (необязательное поле).
   *
   * @return имя старосты
   */
  private String headmanFirstName;

  /**
   * Отчество старосты (необязательное поле).
   *
   * @return отчество старосты
   */
  private String headmanMiddleName;

  /**
   * Факультет, к которому относится группа.
   *
   * @return факультет
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "faculty_id", nullable = false)
  @ToString.Exclude
  private Faculty faculty;

  /**
   * Студенты данной группы.
   *
   * @return список студентов
   */
  @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  @Builder.Default
  private List<Student> students = new ArrayList<>();
}