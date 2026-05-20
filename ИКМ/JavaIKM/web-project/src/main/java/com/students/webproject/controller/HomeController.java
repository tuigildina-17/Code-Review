package com.students.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для главной страницы приложения.
 * Перенаправляет пользователя на список факультетов.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@Controller
public class HomeController {

  /**
   * Обработка корневого URL.
   * Перенаправляет на страницу со списком факультетов.
   *
   * @return строка перенаправления
   */
  @GetMapping("/")
  public String home() {
    return "redirect:/faculties";
  }
}