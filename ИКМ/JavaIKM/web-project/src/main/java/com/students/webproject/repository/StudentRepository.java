package com.students.webproject.repository;

import com.students.webproject.entity.Group;
import com.students.webproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы со студентами.
 * Предоставляет стандартные CRUD‑операции и методы поиска по группе.
 *
 * Используется сервисами для получения и сохранения данных студентов.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  /**
   * Найти всех студентов, относящихся к указанной группе.
   *
   * @param group сущность группы
   * @return список студентов данной группы
   */
  List<Student> findByGroup(Group group);
}