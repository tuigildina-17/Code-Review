package ru.borisova.main;

import ru.borisova.secrets.Secret;
import ru.borisova.util.InputUtils;

/**
 * Task1 — создание цепочки хранителей секрета.
 */
public class Task1 {

  /**
   * Запускает выполнение задания 1.
   */
  public static void run() {
    System.out.println("=== Задание 1: Секреты ===");

    // FIXME: Чтение имени и текста секрета смешано с логикой — лучше вынести в отдельный метод createFirstSecret().
    /*
    String keeper1 = InputUtils.readName("Введите имя первого хранителя: ");
    String text = InputUtils.readNonEmptyString("Введите текст секрета: ");
    Secret s1 = new Secret(keeper1, text);
    */
    Secret s1 = createFirstSecret();

    // FIXME: Повторяющийся код создания следующего хранителя — лучше вынести в метод createNextSecret().
    /*
    String keeper2 = InputUtils.readName("Введите имя второго хранителя: ");
    Secret s2 = new Secret(s1, keeper2);

    String keeper3 = InputUtils.readName("Введите имя третьего хранителя: ");
    Secret s3 = new Secret(s2, keeper3);
    */
    Secret s2 = createNextSecret(s1, "Введите имя второго хранителя: ");
    Secret s3 = createNextSecret(s2, "Введите имя третьего хранителя: ");

    printChainInfo(s1, s2, s3);
    printIndexes(s1, s2, s3);
    printAfterCounts(s1, s2, s3);
    printRelativeKeeper(s1);
    printTextDiff(s1, s3);
  }

  /**
   * Создаёт первого хранителя секрета.
   *
   * @return объект Secret
   */
  private static Secret createFirstSecret() {
    String keeper = InputUtils.readName("Введите имя первого хранителя: ");
    String text = InputUtils.readNonEmptyString("Введите текст секрета: ");
    return new Secret(keeper, text);
  }

  /**
   * Создаёт следующего хранителя.
   *
   * @param previous предыдущий хранитель
   * @param prompt   текст приглашения
   * @return объект Secret
   */
  private static Secret createNextSecret(Secret previous, String prompt) {
    String keeper = InputUtils.readName(prompt);
    return new Secret(previous, keeper);
  }

  /**
   * Выводит строковое представление цепочки.
   */
  private static void printChainInfo(Secret s1, Secret s2, Secret s3) {
    System.out.println("\n--- Строковое представление объектов ---");
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }

  /**
   * Выводит порядковые номера хранителей.
   */
  private static void printIndexes(Secret s1, Secret s2, Secret s3) {
    System.out.println("\n--- Порядковые номера хранителей ---");
    System.out.println("s1 → " + s1.getIndexInChain());
    System.out.println("s2 → " + s2.getIndexInChain());
    System.out.println("s3 → " + s3.getIndexInChain());
  }

  /**
   * Выводит количество людей после каждого хранителя.
   */
  private static void printAfterCounts(Secret s1, Secret s2, Secret s3) {
    System.out.println("\n--- Сколько людей узнали секрет после каждого ---");
    System.out.println("После s1: " + s1.getHowManyAfter());
    System.out.println("После s2: " + s2.getHowManyAfter());
    System.out.println("После s3: " + s3.getHowManyAfter());
  }

  /**
   * Выводит следующего хранителя после первого.
   */
  private static void printRelativeKeeper(Secret s1) {
    System.out.println("\n--- Имя следующего хранителя после первого ---");
    System.out.println("Следующий после s1: " + s1.getRelativeKeeperName(1));
  }

  /**
   * Выводит разницу длины текста.
   */
  private static void printTextDiff(Secret s1, Secret s3) {
    System.out.println("\n--- Разница длины текста между s3 и s1 ---");
    System.out.println("Разница: " + s3.getTextLengthDifferenceWith(-2));
  }
}