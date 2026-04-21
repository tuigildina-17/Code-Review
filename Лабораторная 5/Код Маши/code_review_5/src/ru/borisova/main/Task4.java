package ru.borisova.main;

import ru.borisova.cats.Cat;
import ru.borisova.cats.Meowable;
import ru.borisova.util.InputUtils;

/**
 * Task4 — создание массива котов и демонстрация полиморфизма.
 */
public class Task4 {

  /**
   * Запускает выполнение задания 4.
   */
  public static void run() {
    System.out.println("=== Задание 4: Мяуканье ===");

    // FIXME: Ввод количества котов и создание массива смешаны — лучше вынести в отдельный метод readCatCount().
    /*
    int count = InputUtils.readIntInRange("Сколько котов создать? (1..10): ", 1, 10);
    */
    int count = readCatCount();

    // FIXME: Создание массива и заполнение котами — дублируемая логика, лучше вынести в метод createCats(count).
    /*
    Meowable[] arr = new Meowable[count];

    for (int i = 0; i < count; i++) {
      String name = InputUtils.readName("Введите имя кота #" + (i + 1) + ": ");
      arr[i] = new Cat(name);
    }
    */
    Meowable[] cats = createCats(count);

    // FIXME: Вывод и вызов meow() повторяются — лучше вынести в метод makeCatsMeow().
    /*
    System.out.println("\nКоты мяукают:");
    for (Meowable m : arr) {
      m.meow();
    }
    */
    makeCatsMeow(cats);
  }

  /**
   * Считывает количество котов.
   *
   * @return число котов
   */
  private static int readCatCount() {
    return InputUtils.readIntInRange("Сколько котов создать? (1..10): ", 1, 10);
  }

  /**
   * Создаёт массив котов, запрашивая имена у пользователя.
   *
   * @param count количество котов
   * @return массив Meowable
   */
  private static Meowable[] createCats(int count) {
    Meowable[] arr = new Meowable[count];
    for (int i = 0; i < count; i++) {
      String name = InputUtils.readName("Введите имя кота #" + (i + 1) + ": ");
      arr[i] = new Cat(name);
    }
    return arr;
  }

  /**
   * Заставляет всех котов мяукать.
   *
   * @param cats массив объектов Meowable
   */
  private static void makeCatsMeow(Meowable[] cats) {
    System.out.println("\nКоты мяукают:");
    for (Meowable cat : cats) {
      cat.meow();
    }
  }
}