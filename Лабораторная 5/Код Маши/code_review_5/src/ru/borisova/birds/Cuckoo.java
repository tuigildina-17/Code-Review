package ru.borisova.birds;

import java.util.Random;

/**
 * Кукушка, издающая случайное количество звуков «ку-ку».
 */
public class Cuckoo extends Bird {

  /**
   * Поёт от 1 до 10 раз, выводя «ку-ку».
   */
  @Override
  public void sing() {
    Random r = new Random();
    int times = 1 + r.nextInt(10);
    for (int i = 0; i < times; i++) {
      System.out.println("ку-ку");
    }
  }
}