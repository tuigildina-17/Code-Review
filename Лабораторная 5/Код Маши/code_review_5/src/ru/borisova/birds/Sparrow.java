package ru.borisova.birds;

/**
 * Воробей, издающий звук «чырык».
 */
public class Sparrow extends Bird {

  /**
   * Поёт, выводя «чырык».
   */
  @Override
  public void sing() {
    System.out.println("чырык");
  }
}