package ru.borisova.main;

import ru.borisova.people.Human;
import ru.borisova.util.InputUtils;

/**
 * Task8 — работа с объектом Human и изменением его состояния.
 */
public class Task8 {

  /**
   * Запускает выполнение задания 8.
   */
  public static void run() {
    System.out.println("=== Задание 8: Непустые имена / Человек меняется ===\n");

    // FIXME: Ввод данных отца написан прямо в методе — дублирование логики.
    // FIXME: Лучше вынести в отдельный метод readHuman(title, isFather).
    /*
    System.out.println("Введите данные отца:");
    String fatherName = InputUtils.readName("Имя: ");
    String fatherSurname = InputUtils.readName("Фамилия: ");
    int fatherHeight = InputUtils.readIntInRange("Рост (100..250): ", 100, 250);

    Human father = new Human(fatherName, fatherSurname, fatherHeight, null);
    */
    Human father = readHuman("Введите данные отца:", true, null);

    // FIXME: Ввод данных ребёнка полностью дублирует ввод данных отца.
    /*
    System.out.println("\nВведите данные ребёнка:");
    String childName = InputUtils.readName("Имя: ");
    String childSurname = InputUtils.readName("Фамилия: ");
    int childHeight = InputUtils.readIntInRange("Рост (100..250): ", 100, 250);

    Human child = new Human(childName, childSurname, childHeight, father);
    */
    Human child = readHuman("Введите данные ребёнка:", false, father);

    printHuman("Создан человек:", child);

    // FIXME: Изменение роста написано прямо в методе — лучше вынести в changeHeight().
    /*
    int newHeight = InputUtils.readIntInRange("\nВведите новый рост ребёнка (100..250): ", 100, 250);
    child.setHeight(newHeight);

    System.out.println("После изменения роста:");
    System.out.println(child);
    */
    changeHeight(child);
  }

  /**
   * Считывает данные человека.
   *
   * @param title  заголовок перед вводом
   * @param isFather true, если создаётся отец
   * @param father объект отца (null, если создаётся отец)
   * @return объект Human
   */
  private static Human readHuman(String title, boolean isFather, Human father) {
    System.out.println("\n" + title);
    String name = InputUtils.readName("Имя: ");
    String surname = InputUtils.readName("Фамилия: ");
    int height = InputUtils.readIntInRange("Рост (100..250): ", 100, 250);

    return new Human(name, surname, height, isFather ? null : father);
  }

  /**
   * Выводит информацию о человеке.
   *
   * @param title заголовок
   * @param human объект Human
   */
  private static void printHuman(String title, Human human) {
    System.out.println("\n" + title);
    System.out.println(human);
  }

  /**
   * Изменяет рост ребёнка и выводит обновлённые данные.
   *
   * @param child объект Human
   */
  private static void changeHeight(Human child) {
    int newHeight = InputUtils.readIntInRange(
        "\nВведите новый рост ребёнка (100..250): ", 100, 250);
    child.setHeight(newHeight);

    System.out.println("После изменения роста:");
    System.out.println(child);
  }
}