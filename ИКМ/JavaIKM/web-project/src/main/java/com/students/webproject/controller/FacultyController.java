package com.students.webproject.controller;

import com.students.webproject.dto.FacultyDTO;
import com.students.webproject.service.FacultyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для работы с факультетами.
 * Обрабатывает отображение списка, создание, редактирование,
 * просмотр и удаление факультетов.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Controller
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

  private final FacultyService facultyService;

  /**
   * Показать список всех факультетов.
   *
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона со списком факультетов
   */
  @GetMapping
  public String listFaculties(Model model) {
    model.addAttribute("faculties", facultyService.getAllFaculties());
    return "faculties/list";
  }

  /**
   * Показать форму добавления нового факультета.
   *
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона формы
   */
  @GetMapping("/new")
  public String showCreateForm(Model model) {
    model.addAttribute("faculty", new FacultyDTO());
    model.addAttribute("title", "Добавить факультет");
    return "faculties/form";
  }

  /**
   * Показать форму редактирования существующего факультета.
   *
   * @param id идентификатор факультета
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона формы
   */
  @GetMapping("/{id}/edit")
  public String showEditForm(@PathVariable Long id, Model model) {
    FacultyDTO faculty = facultyService.getFacultyById(id);
    model.addAttribute("faculty", faculty);
    model.addAttribute("title", "Изменить факультет");
    return "faculties/form";
  }

  /**
   * Сохранить факультет (создание или редактирование).
   *
   * @param facultyDTO данные факультета из формы
   * @param bindingResult результат проверки данных
   * @param model модель для передачи данных в представление
   * @return перенаправление на список факультетов или возврат формы при ошибках
   */
  @PostMapping("/save")
  public String saveFaculty(@ModelAttribute("faculty") @Valid FacultyDTO facultyDTO,
    BindingResult bindingResult,
    Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("title", facultyDTO.getId() == null ?
        "Добавить факультет" : "Изменить факультет");
      return "faculties/form";
    }
    facultyService.saveFaculty(facultyDTO);
    return "redirect:/faculties";
  }

  /**
   * Показать детальную информацию о факультете.
   *
   * @param id идентификатор факультета
   * @param model модель для передачи данных в представление
   * @return имя HTML-шаблона просмотра факультета
   */
  @GetMapping("/{id}")
  public String viewFaculty(@PathVariable Long id, Model model) {
    FacultyDTO faculty = facultyService.getFacultyById(id);
    model.addAttribute("faculty", faculty);
    return "faculties/view";
  }

  /**
   * Удалить факультет.
   *
   * @param id идентификатор факультета
   * @return перенаправление на список факультетов
   */
  @PostMapping("/{id}/delete")
  public String deleteFaculty(@PathVariable Long id) {
    facultyService.deleteFaculty(id);
    return "redirect:/faculties";
  }
}