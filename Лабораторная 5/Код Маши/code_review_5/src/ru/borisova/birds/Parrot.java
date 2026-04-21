package ru.borisova.birds;

import java.util.Random;

/**
 * Попугай, который произносит случайную часть заданного текста.
 */
public class Parrot extends Bird {

  private final String text;

  /**
   * Создаёт попугая с заданным текстом.
   *
   * @param text текст, который попугай может произнести
   */
  public Parrot(String text) {
    this.text = text;
  }

  /**
   * Произносит случайное количество первых символов текста.
   * Если текст пустой, выводит пустую строку.
   */
  @Override
  public void sing() {
    if (text.isEmpty()) {
      System.out.println();
      return;
    }
    Random r = new Random();
    int n = r.nextInt(text.length()) + 1; // 1..length
    System.out.println(text.substring(0, n));
  }
}