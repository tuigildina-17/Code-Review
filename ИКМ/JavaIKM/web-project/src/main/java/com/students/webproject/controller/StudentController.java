package com.students.webproject.controller;

import com.students.webproject.dto.StudentDTO;
import com.students.webproject.service.GroupService;
import com.students.webproject.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для работы со студентами.
 * Обрабатывает операции просмотра, создания, редактирования и удаления студентов
 * в рамках конкретной группы и факультета.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Controller
@RequestMapping("/faculties/{facultyId}/groups/{groupId}/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;
  private final GroupService groupService;

  /**
   * Показать список студентов, относящихся к группе.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона со списком студентов
   */
  @GetMapping
  public String listStudents(@PathVariable Long facultyId,
                 @PathVariable Long groupId,
                 Model model) {
    model.addAttribute("group", groupService.getGroupById(groupId));
    model.addAttribute("students", studentService.getStudentsByGroup(groupId));
    model.addAttribute("facultyId", facultyId);
    return "students/list";
  }

  /**
   * Показать форму добавления нового студента.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона формы
   */
  @GetMapping("/new")
  public String showCreateForm(@PathVariable Long facultyId,
                 @PathVariable Long groupId,
                 Model model) {
    StudentDTO dto = new StudentDTO();
    dto.setGroupId(groupId);
    model.addAttribute("student", dto);
    model.addAttribute("group", groupService.getGroupById(groupId));
    model.addAttribute("facultyId", facultyId);
    model.addAttribute("title", "Добавить студента");
    return "students/form";
  }

  /**
   * Показать форму редактирования данных студента.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param studentId идентификатор студента
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона формы
   */
  @GetMapping("/{studentId}/edit")
  public String showEditForm(@PathVariable Long facultyId,
                 @PathVariable Long groupId,
                 @PathVariable Long studentId,
                 Model model) {
    StudentDTO student = studentService.getStudentById(studentId);
    model.addAttribute("student", student);
    model.addAttribute("group", groupService.getGroupById(groupId));
    model.addAttribute("facultyId", facultyId);
    model.addAttribute("title", "Изменить данные студента");
    return "students/form";
  }

  /**
   * Сохранить данные студента (создание или редактирование).
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param studentDTO данные студента из формы
   * @param bindingResult результат проверки данных
   * @param model модель для передачи данных в представление
   * @return перенаправление на список студентов или возврат формы при ошибках
   */
  @PostMapping("/save")
  public String saveStudent(@PathVariable Long facultyId,
                @PathVariable Long groupId,
                @ModelAttribute("student") @Valid StudentDTO studentDTO,
                BindingResult bindingResult,
                Model model) {
    studentDTO.setGroupId(groupId);

    if (bindingResult.hasErrors()) {
      model.addAttribute("group", groupService.getGroupById(groupId));
      model.addAttribute("facultyId", facultyId);
      model.addAttribute("title", studentDTO.getId() == null ?
        "Добавить студента" : "Изменить данные студента");
      return "students/form";
    }

    try {
      studentService.saveStudent(studentDTO);
    } catch (IllegalArgumentException ex) {
      bindingResult.rejectValue("birthYear", "invalidDate", ex.getMessage());
      model.addAttribute("group", groupService.getGroupById(groupId));
      model.addAttribute("facultyId", facultyId);
      model.addAttribute("title", studentDTO.getId() == null ?
        "Добавить студента" : "Изменить данные студента");
      return "students/form";
    }

    return "redirect:/faculties/" + facultyId + "/groups/" + groupId + "/students";
  }

  /**
   * Показать детальную информацию о студенте.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param studentId идентификатор студента
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона просмотра студента
   */
  @GetMapping("/{studentId}")
  public String viewStudent(@PathVariable Long facultyId,
      @PathVariable Long groupId,
      @PathVariable Long studentId,
      Model model) {
    model.addAttribute("student", studentService.getStudentById(studentId));
    model.addAttribute("group", groupService.getGroupById(groupId));
    model.addAttribute("facultyId", facultyId);
    return "students/view";
  }

  /**
   * Удалить студента.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param studentId идентификатор студента
   * @return перенаправление на список студентов
   */
  @PostMapping("/{studentId}/delete")
  public String deleteStudent(@PathVariable Long facultyId,
      @PathVariable Long groupId,
      @PathVariable Long studentId) {
    studentService.deleteStudent(studentId);
    return "redirect:/faculties/" + facultyId + "/groups/" + groupId + "/students";
  }
}