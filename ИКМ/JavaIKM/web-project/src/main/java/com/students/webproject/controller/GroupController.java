package com.students.webproject.controller;

import com.students.webproject.dto.GroupDTO;
import com.students.webproject.entity.EducationForm;
import com.students.webproject.service.FacultyService;
import com.students.webproject.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для работы с группами.
 * Обрабатывает отображение списка, создание, редактирование,
 * просмотр и удаление групп в рамках конкретного факультета.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Controller
@RequestMapping("/faculties/{facultyId}/groups")
@RequiredArgsConstructor
public class GroupController {

  private final GroupService groupService;
  private final FacultyService facultyService;

  /**
   * Показать список групп, относящихся к факультету.
   *
   * @param facultyId идентификатор факультета
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона со списком групп
   */
  @GetMapping
  public String listGroups(@PathVariable Long facultyId, Model model) {
    model.addAttribute("faculty", facultyService.getFacultyById(facultyId));
    model.addAttribute("groups", groupService.getGroupsByFaculty(facultyId));
    return "groups/list";
  }

  /**
   * Показать форму добавления новой группы.
   *
   * @param facultyId идентификатор факультета
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона формы
   */
  @GetMapping("/new")
  public String showCreateForm(@PathVariable Long facultyId, Model model) {
    GroupDTO dto = new GroupDTO();
    dto.setFacultyId(facultyId);
    model.addAttribute("group", dto);
    model.addAttribute("educationForms", EducationForm.values());
    model.addAttribute("title", "Добавить группу");
    return "groups/form";
  }

  /**
   * Показать форму редактирования группы.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона формы
   */
  @GetMapping("/{groupId}/edit")
  public String showEditForm(@PathVariable Long facultyId,
      @PathVariable Long groupId,
      Model model) {
    GroupDTO group = groupService.getGroupById(groupId);
    model.addAttribute("group", group);
    model.addAttribute("educationForms", EducationForm.values());
    model.addAttribute("title", "Изменить группу");
    return "groups/form";
  }

  /**
   * Сохранить группу (создание или редактирование).
   *
   * @param facultyId идентификатор факультета
   * @param groupDTO данные группы из формы
   * @param bindingResult результат проверки данных
   * @param model модель для передачи данных в представление
   * @return перенаправление на список групп или возврат формы при ошибках
   */
  @PostMapping("/save")
  public String saveGroup(@PathVariable Long facultyId,
      @ModelAttribute("group") @Valid GroupDTO groupDTO,
      BindingResult bindingResult,
      Model model) {
    groupDTO.setFacultyId(facultyId);

    if (bindingResult.hasErrors()) {
      model.addAttribute("educationForms", EducationForm.values());
      model.addAttribute("title", groupDTO.getId() == null ?
        "Добавить группу" : "Изменить группу");
      return "groups/form";
    }

    groupService.saveGroup(groupDTO);
    return "redirect:/faculties/" + facultyId + "/groups";
  }

  /**
   * Показать детальную информацию о группе.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона просмотра группы
   */
  @GetMapping("/{groupId}")
  public String viewGroup(@PathVariable Long facultyId,
      @PathVariable Long groupId,
      Model model) {
    model.addAttribute("faculty", facultyService.getFacultyById(facultyId));
    model.addAttribute("group", groupService.getGroupById(groupId));
    return "groups/view";
  }

  /**
   * Удалить группу.
   *
   * @param facultyId идентификатор факультета
   * @param groupId идентификатор группы
   * @return перенаправление на список групп
   */
  @PostMapping("/{groupId}/delete")
  public String deleteGroup(@PathVariable Long facultyId,
      @PathVariable Long groupId) {
    groupService.deleteGroup(groupId);
    return "redirect:/faculties/" + facultyId + "/groups";
  }
}