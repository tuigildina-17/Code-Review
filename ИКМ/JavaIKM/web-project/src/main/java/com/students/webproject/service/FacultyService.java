package com.students.webproject.service;

import com.students.webproject.dto.FacultyDTO;
import com.students.webproject.entity.Faculty;
import com.students.webproject.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с факультетами.
 * Выполняет операции получения, сохранения, преобразования и удаления данных факультетов.
 * Используется контроллерами и другими сервисами.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class FacultyService {

  private final FacultyRepository facultyRepository;

  /**
   * Получить список всех факультетов с подсчитанным количеством групп и студентов.
   *
   * @return список DTO факультетов
   */
  @Transactional(readOnly = true)
  public List<FacultyDTO> getAllFaculties() {
    return facultyRepository.findAll().stream()
      .map(this::toDtoWithCounts)
      .collect(Collectors.toList());
  }

  /**
   * Получить факультет по его идентификатору.
   *
   * @param id идентификатор факультета
   * @return DTO факультета
   * @throws IllegalArgumentException если факультет не найден
   */
  @Transactional(readOnly = true)
  public FacultyDTO getFacultyById(Long id) {
    Faculty faculty = facultyRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Факультет не найден, id=" + id));
    return toDtoWithCounts(faculty);
  }

  /**
   * Создать новый или редактировать существующий факультет на основе DTO.
   *
   * @param dto данные факультета
   * @return сохранённый факультет в виде DTO
   * @throws IllegalArgumentException если обновляемый факультет не найден
   */
  public FacultyDTO saveFaculty(FacultyDTO dto) {
    Faculty faculty;
    if (dto.getId() != null) {
      faculty = facultyRepository.findById(dto.getId())
      .orElseThrow(() -> new IllegalArgumentException("Факультет не найден, id=" + dto.getId()));
    } else {
      faculty = new Faculty();
    }

    faculty.setName(dto.getName());
    faculty.setDeanLastName(nullIfBlank(dto.getDeanLastName()));
    faculty.setDeanFirstName(nullIfBlank(dto.getDeanFirstName()));
    faculty.setDeanMiddleName(nullIfBlank(dto.getDeanMiddleName()));

    Faculty saved = facultyRepository.save(faculty);
    return toDtoWithCounts(saved);
  }

  /**
   * Удалить факультет по идентификатору.
   *
   * @param id идентификатор факультета
   */
  public void deleteFaculty(Long id) {
    facultyRepository.deleteById(id);
  }

  /**
   * Преобразовать строку в null, если она пустая или состоит из пробелов.
   *
   * @param value строка
   * @return trimmed строка или null
   */
  private String nullIfBlank(String value) {
    return (value == null || value.isBlank()) ? null : value.trim();
  }

  /**
   * Преобразовать сущность факультета в DTO с подсчётом количества групп и студентов.
   *
   * @param faculty сущность факультета
   * @return DTO факультета
   */
  private FacultyDTO toDtoWithCounts(Faculty faculty) {
    long groupCount = faculty.getGroups().size();
    long studentCount = faculty.getGroups().stream()
      .mapToLong(g -> g.getStudents().size())
      .sum();

    return FacultyDTO.builder()
      .id(faculty.getId())
      .name(faculty.getName())
      .deanLastName(faculty.getDeanLastName())
      .deanFirstName(faculty.getDeanFirstName())
      .deanMiddleName(faculty.getDeanMiddleName())
      .groupCount(groupCount)
      .studentCount(studentCount)
      .build();
  }

  /**
   * Получить сущность факультета по id.
   * Используется другими сервисами.
   *
   * @param id идентификатор факультета
   * @return сущность факультета
   * @throws IllegalArgumentException если факультет не найден
   */
  @Transactional(readOnly = true)
  public Faculty getFacultyEntity(Long id) {
    return facultyRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Факультет не найден, id=" + id));
  }
}