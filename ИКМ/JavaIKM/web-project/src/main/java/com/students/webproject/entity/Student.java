package com.students.webproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Сущность студента.
 * Хранит ФИО, дату рождения и принадлежность к группе.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

  /**
   * Идентификатор студента.
   *
   * @return уникальный идентификатор студента
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Фамилия студента.
   *
   * @return фамилия студента
   */
  @Column(nullable = false)
  private String lastName;

  /**
   * Имя студента.
   *
   * @return имя студента
   */
  @Column(nullable = false)
  private String firstName;

  /**
   * Отчество студента (необязательное поле).
   *
   * @return отчество студента
   */
  private String middleName;

  /**
   * Дата рождения студента.
   *
   * @return дата рождения
   */
  @Column(nullable = false)
  private LocalDate birthDate;

  /**
   * Группа, в которой обучается студент.
   *
   * @return учебная группа
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_id", nullable = false)
  @ToString.Exclude
  private Group group;
}