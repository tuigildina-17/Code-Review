package com.students.webproject.service;

import com.students.webproject.dto.StudentDTO;
import com.students.webproject.entity.Group;
import com.students.webproject.entity.Student;
import com.students.webproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы со студентами.
 * Выполняет операции получения, сохранения, преобразования и удаления данных студентов.
 * Используется контроллерами и другими сервисами.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

  private final StudentRepository studentRepository;
  private final GroupService groupService;

  /**
   * Получить список студентов, относящихся к указанной группе.
   *
   * @param groupId идентификатор группы
   * @return список DTO студентов
   * @throws IllegalArgumentException если группа не найдена
   */
  @Transactional(readOnly = true)
  public List<StudentDTO> getStudentsByGroup(Long groupId) {
    Group group = groupService.getGroupEntity(groupId);
    return studentRepository.findByGroup(group).stream()
      .map(this::toDto)
      .collect(Collectors.toList());
  }

  /**
   * Получить студента по его идентификатору.
   *
   * @param id идентификатор студента
   * @return DTO студента
   * @throws IllegalArgumentException если студент не найден
   */
  @Transactional(readOnly = true)
  public StudentDTO getStudentById(Long id) {
    Student student = studentRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Студент не найден, id=" + id));
    return toDto(student);
  }

  /**
   * Создать нового или обновить существующего студента.
   *
   * @param dto данные студента
   * @return сохранённый студент в виде DTO
   * @throws IllegalArgumentException если обновляемый студент не найден
   *                  или дата рождения некорректна
   */
  public StudentDTO saveStudent(StudentDTO dto) {
    Group group = groupService.getGroupEntity(dto.getGroupId());

    Student student;
    if (dto.getId() != null) {
      student = studentRepository.findById(dto.getId())
        .orElseThrow(() -> new IllegalArgumentException("Студент не найден, id=" + dto.getId()));
    } else {
      student = new Student();
      student.setGroup(group);
    }

    student.setLastName(dto.getLastName().trim());
    student.setFirstName(dto.getFirstName().trim());
    student.setMiddleName(nullIfBlank(dto.getMiddleName()));

    LocalDate birthDate = parseDate(dto.getBirthDay(), dto.getBirthMonth(), dto.getBirthYear());
    student.setBirthDate(birthDate);

    Student saved = studentRepository.save(student);
    return toDto(saved);
  }

  /**
   * Удалить студента по идентификатору.
   *
   * @param id идентификатор студента
   */
  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
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
   * Преобразовать сущность студента в DTO.
   *
   * @param student сущность студента
   * @return DTO студента
   */
  private StudentDTO toDto(Student student) {
    LocalDate birthDate = student.getBirthDate();
    String day = String.format("%02d", birthDate.getDayOfMonth());
    String month = String.format("%02d", birthDate.getMonthValue());
    String year = String.format("%04d", birthDate.getYear());

    return StudentDTO.builder()
      .id(student.getId())
      .groupId(student.getGroup().getId())
      .groupName(student.getGroup().getName())
      .lastName(student.getLastName())
      .firstName(student.getFirstName())
      .middleName(student.getMiddleName())
      .birthDay(day)
      .birthMonth(month)
      .birthYear(year)
      .build();
  }

  /**
   * Сконструировать дату рождения из трёх строк.
   *
   * @param day строка с днём (2 цифры)
   * @param month строка с месяцем (2 цифры)
   * @param year строка с годом (4 цифры)
   * @return объект LocalDate
   * @throws IllegalArgumentException если дата некорректна
   */
  /*FIXME: отсутствие проверки на диапозон года*/
  private LocalDate parseDate(String day, String month, String year) {
    try {
      int d = Integer.parseInt(day);
      int m = Integer.parseInt(month);
      int y = Integer.parseInt(year);

      /*return LocalDate.of(y, m, d);*/
      int currentYear = LocalDate.now().getYear();
      if (y < 1900 || y > currentYear) {
        throw new IllegalArgumentException("Год рождения должен быть в диапазоне 1900–"
          + currentYear);
      }
      LocalDate date = LocalDate.of(y, m, d);
      if (date.isAfter(LocalDate.now())) {
        throw new IllegalArgumentException("Дата рождения не может быть в будущем");
      }
      return date;

    } catch (NumberFormatException | DateTimeException ex) {
      throw new IllegalArgumentException("Некорректная дата рождения");
    }
  }
}