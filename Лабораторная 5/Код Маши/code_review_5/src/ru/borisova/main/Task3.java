package ru.borisova.main;

import ru.borisova.birds.Bird;
import ru.borisova.birds.Cuckoo;
import ru.borisova.birds.Parrot;
import ru.borisova.birds.Sparrow;
import ru.borisova.util.InputUtils;

/**
 * Task3 — демонстрация полиморфизма на примере птиц.
 */
public class Task3 {

  /**
   * Запускает выполнение задания 3.
   */
  public static void run() {
    System.out.println("=== Задание 3: Птицы ===");

    // FIXME: Создание птиц прямо в методе — лучше вынести в отдельный метод createDefaultBirds().
    /*
    Bird sparrow = new Sparrow();
    Bird cuckoo = new Cuckoo();
    */
    Bird sparrow = createSparrow();
    Bird cuckoo = createCuckoo();

    // FIXME: Ввод текста попугая смешан с логикой — лучше вынести в метод createParrot().
    /*
    String text = InputUtils.readNonEmptyString("Введите текст, который будет говорить попугай: ");
    Bird parrot = new Parrot(text);
    */
    Bird parrot = createParrot();

    // FIXME: Вывод и вызов sing() повторяются — лучше вынести в метод printBirdSong().
    /*
    System.out.println("\nВоробей поёт:");
    sparrow.sing();

    System.out.println("\nКукушка поёт:");
    cuckoo.sing();

    System.out.println("\nПопугай поёт:");
    parrot.sing();
    */
    printBirdSong("Воробей", sparrow);
    printBirdSong("Кукушка", cuckoo);
    printBirdSong("Попугай", parrot);
  }

  /**
   * Создаёт воробья.
   *
   * @return объект Sparrow
   */
  private static Bird createSparrow() {
    return new Sparrow();
  }

  /**
   * Создаёт кукушку.
   *
   * @return объект Cuckoo
   */
  private static Bird createCuckoo() {
    return new Cuckoo();
  }

  /**
   * Создаёт попугая, запрашивая текст у пользователя.
   *
   * @return объект Parrot
   */
  private static Bird createParrot() {
    String text = InputUtils.readNonEmptyString("Введите текст, который будет говорить попугай: ");
    return new Parrot(text);
  }

  /**
   * Выводит заголовок и заставляет птицу петь.
   *
   * @param name имя птицы
   * @param bird объект Bird
   */
  private static void printBirdSong(String name, Bird bird) {
    System.out.println("\n" + name + " поёт:");
    bird.sing();
  }
}
