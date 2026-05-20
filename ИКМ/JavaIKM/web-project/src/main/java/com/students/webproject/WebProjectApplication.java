package com.students.webproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*FIXME: использование табуляции*/
/**
 * Главный класс Spring Boot приложения.
 * Запускает встроенный сервер и инициализирует все компоненты приложения.
 *
 * Точка входа в программу — метод main().
 * При запуске создаётся контекст Spring и поднимается веб‑приложение.
 *
 * @author Туйгильдина Динара
 * @version 1.0
 */
@SpringBootApplication
public class WebProjectApplication {

  /**
   * Точка входа в приложение.
   * Запускает Spring Boot и инициализирует веб‑сервер.
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {
    SpringApplication.run(WebProjectApplication.class, args);
  }
}