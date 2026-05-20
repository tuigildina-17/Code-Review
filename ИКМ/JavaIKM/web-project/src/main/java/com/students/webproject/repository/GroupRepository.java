package com.students.webproject.repository;

import com.students.webproject.entity.Faculty;
import com.students.webproject.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с учебными группами.
 * Предоставляет стандартные CRUD‑операции и дополнительные методы поиска.
 *
 * Используется сервисами для получения и сохранения данных групп.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

  /**
   * Найти все группы, относящиеся к указанному факультету.
   *
   * @param faculty сущность факультета
   * @return список групп, принадлежащих факультету
   */
  List<Group> findByFaculty(Faculty faculty);
}