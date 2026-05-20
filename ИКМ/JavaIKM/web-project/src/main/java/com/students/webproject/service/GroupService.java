package com.students.webproject.service;

import com.students.webproject.dto.GroupDTO;
import com.students.webproject.entity.Faculty;
import com.students.webproject.entity.Group;
import com.students.webproject.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с учебными группами.
 * Выполняет операции получения, сохранения, преобразования и удаления данных групп.
 * Используется контроллерами и другими сервисами.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class GroupService {

  private final GroupRepository groupRepository;
  private final FacultyService facultyService;

  /**
   * Получить список групп, относящихся к факультету.
   *
   * @param facultyId идентификатор факультета
   * @return список DTO групп
   * @throws IllegalArgumentException если факультет не найден
   */
  @Transactional(readOnly = true)
  public List<GroupDTO> getGroupsByFaculty(Long facultyId) {
    Faculty faculty = facultyService.getFacultyEntity(facultyId);
    return groupRepository.findByFaculty(faculty).stream()
      .map(this::toDtoWithCounts)
      .collect(Collectors.toList());
  }

  /**
   * Получить группу по её идентификатору.
   *
   * @param id идентификатор группы
   * @return DTO группы
   * @throws IllegalArgumentException если группа не найдена
   */
  @Transactional(readOnly = true)
  public GroupDTO getGroupById(Long id) {
    Group group = groupRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Группа не найдена, id=" + id));
    return toDtoWithCounts(group);
  }

  /**
   * Создать новую или редактировать существующую группу.
   *
   * @param dto данные группы
   * @return сохранённая группа в виде DTO
   * @throws IllegalArgumentException если обновляемая группа не найдена
   */
  public GroupDTO saveGroup(GroupDTO dto) {
    Faculty faculty = facultyService.getFacultyEntity(dto.getFacultyId());

    Group group;
    if (dto.getId() != null) {
      group = groupRepository.findById(dto.getId())
        .orElseThrow(() -> new IllegalArgumentException("Группа не найдена, id=" + dto.getId()));
    } else {
      group = new Group();
      group.setFaculty(faculty);
    }

    group.setName(dto.getName());
    group.setEducationForm(dto.getEducationForm());

    group.setTutorLastName(nullIfBlank(dto.getTutorLastName()));
    group.setTutorFirstName(nullIfBlank(dto.getTutorFirstName()));
    group.setTutorMiddleName(nullIfBlank(dto.getTutorMiddleName()));

    group.setHeadmanLastName(nullIfBlank(dto.getHeadmanLastName()));
    group.setHeadmanFirstName(nullIfBlank(dto.getHeadmanFirstName()));
    group.setHeadmanMiddleName(nullIfBlank(dto.getHeadmanMiddleName()));

    Group saved = groupRepository.save(group);
    return toDtoWithCounts(saved);
  }

  /**
   * Удалить группу по идентификатору.
   *
   * @param id идентификатор группы
   */
  public void deleteGroup(Long id) {
    groupRepository.deleteById(id);
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
   * Преобразовать сущность группы в DTO с подсчётом количества студентов.
   *
   * @param group сущность группы
   * @return DTO группы
   */
  private GroupDTO toDtoWithCounts(Group group) {
    long studentCount = group.getStudents().size();
    return GroupDTO.builder()
      .id(group.getId())
      .facultyId(group.getFaculty().getId())
      .name(group.getName())
      .educationForm(group.getEducationForm())
      .tutorLastName(group.getTutorLastName())
      .tutorFirstName(group.getTutorFirstName())
      .tutorMiddleName(group.getTutorMiddleName())
      .headmanLastName(group.getHeadmanLastName())
      .headmanFirstName(group.getHeadmanFirstName())
      .headmanMiddleName(group.getHeadmanMiddleName())
      .studentCount(studentCount)
      .facultyName(group.getFaculty().getName())
      .build();
  }

  /**
   * Получить сущность группы по id.
   * Используется другими сервисами.
   *
   * @param id идентификатор группы
   * @return сущность группы
   * @throws IllegalArgumentException если группа не найдена
   */
  @Transactional(readOnly = true)
  public Group getGroupEntity(Long id) {
    return groupRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Группа не найдена, id=" + id));
  }
}