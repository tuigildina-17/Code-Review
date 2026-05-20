package com.students.webproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Сущность факультета.
 * Содержит информацию о факультете и связанные группы.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Entity
@Table(name = "faculties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Faculty {

  /**
   * Идентификатор факультета.
   *
   * @return уникальный идентификатор факультета
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Название факультета.
   *
   * @return название факультета
   */
  @Column(nullable = false, unique = true)
  private String name;

  /**
   * Фамилия декана (необязательное поле).
   *
   * @return фамилия декана
   */
  private String deanLastName;

  /**
   * Имя декана (необязательное поле).
   *
   * @return имя декана
   */
  private String deanFirstName;

  /**
   * Отчество декана (необязательное поле).
   *
   * @return отчество декана
   */
  private String deanMiddleName;

  /**
   * Список групп, относящихся к факультету.
   *
   * @return список учебных групп
   */
  @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  @Builder.Default
  private List<Group> groups = new ArrayList<>();
}