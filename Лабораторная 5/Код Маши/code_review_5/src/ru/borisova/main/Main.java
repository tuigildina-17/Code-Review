package ru.borisova.main;

import ru.borisova.util.InputUtils;

/**
 * Главный класс программы, содержащий меню выбора заданий.
 */
public class Main {

  public static void main(String[] args) {

    while (true) {

      // FIXME: Меню выводится вручную — дублирование. Лучше вынести в отдельный метод printMenu().
      /*
      System.out.println("МЕНЮ");
      System.out.println("№ Задания");
      System.out.println("1 - Секреты");
      System.out.println("2 - Сравнение точек");
      System.out.println("3 - Птицы");
      System.out.println("4 - Мяуканье");
      System.out.println("5 - Трёхмерная точка");
      System.out.println("6 - Клонирование точки");
      System.out.println("7 - Пакеты");
      System.out.println("8 - Непустые имена / Человек меняется");
      System.out.println("0 - ВЫХОД");
      */
      printMenu();

      int choice = InputUtils.readInt("Введите номер задания: ");

      // FIXME: Сообщение об ошибке повторяется — лучше вынести в отдельный метод.
      /*
      if (choice < 0 || choice > 8) {
        System.out.println("Ввод некорректен, попробуйте снова.\n");
        continue;
      }
      */
      if (!isValidChoice(choice)) {
        printInvalidInput();
        continue;
      }

      if (choice == 0) {
        System.out.println("Выход...");
        break;
      }

      // FIXME: Дублирование switch — встречается дважды.
      /*
      switch (choice) {
        case 1 -> Task1.run();
        case 2 -> Task2.run();
        case 3 -> Task3.run();
        case 4 -> Task4.run();
        case 5 -> Task5.run();
        case 6 -> Task6.run();
        case 7 -> Task7.run();
        case 8 -> Task8.run();
      }
      */
      runTask(choice);

      int action = InputUtils.readInt("""
          Выберите действие:
          1 - Меню
          2 - Повторить задание
          0 - Выход
          Ваш выбор: """);

      if (action == 0) {
        System.out.println("Выход...");
        break;
      }

      // FIXME: Дублирование switch — повтор задания копирует код выше.
      /*
      if (action == 2) {
        switch (choice) {
          case 1 -> Task1.run();
          case 2 -> Task2.run();
          case 3 -> Task3.run();
          case 4 -> Task4.run();
          case 5 -> Task5.run();
          case 6 -> Task6.run();
          case 7 -> Task7.run();
          case 8 -> Task8.run();
        }
      }
      */
      if (action == 2) {
        runTask(choice);
      }

      // FIXME: При action == 1 логика неявная — лучше явно continue.
      if (action == 1) {

      }
    }
  }

  private static void printMenu() {
    System.out.println("МЕНЮ");
    System.out.println("№ Задания");
    System.out.println("1 - Секреты");
    System.out.println("2 - Сравнение точек");
    System.out.println("3 - Птицы");
    System.out.println("4 - Мяуканье");
    System.out.println("5 - Трёхмерная точка");
    System.out.println("6 - Клонирование точки");
    System.out.println("7 - Пакеты");
    System.out.println("8 - Непустые имена / Человек меняется");
    System.out.println("0 - ВЫХОД");
  }

  private static boolean isValidChoice(int choice) {
    return choice >= 0 && choice <= 8;
  }

  private static void printInvalidInput() {
    System.out.println("Ввод некорректен, попробуйте снова.\n");
  }

  private static void runTask(int choice) {
    switch (choice) {
      case 1 -> Task1.run();
      case 2 -> Task2.run();
      case 3 -> Task3.run();
      case 4 -> Task4.run();
      case 5 -> Task5.run();
      case 6 -> Task6.run();
      case 7 -> Task7.run();
      case 8 -> Task8.run();
      default -> System.out.println("Неизвестный номер задания.");
    }
  }
}