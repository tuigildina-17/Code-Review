package com.students.webproject.repository;

import com.students.webproject.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с сущностями факультетов.
 * Предоставляет стандартные CRUD‑операции через JpaRepository.
 *
 * Используется сервисами для доступа к данным факультетов.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}