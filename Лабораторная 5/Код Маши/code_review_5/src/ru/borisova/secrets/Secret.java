package ru.borisova.secrets;

import java.util.Random;

/**
 * Секрет, передающийся по цепочке хранителей.
 * Каждый новый хранитель получает изменённый текст.
 */
public class Secret {

  // FIXME: лишние комментарии
  private final String keeper;
  private final String text;
  private final Secret previous;
  private Secret next;
  private final int index;
  private final int changes;

  /**
   * Создаёт первый секрет в цепочке.
   * Единственный момент, когда текст можно вывести напрямую.
   *
   * @param keeper имя первого хранителя
   * @param text   исходный текст секрета
   */
  public Secret(String keeper, String text) {
    this.keeper = keeper;
    this.text = text;
    this.previous = null;
    this.next = null;
    this.index = 1;
    this.changes = 0;

    // FIXME: единственный вывод текста — по условию задания
    System.out.println(keeper + " сказал что " + text);
  }

  /**
   * Создаёт новый элемент цепочки, передавая секрет следующему хранителю.
   * Текст изменяется случайным образом.
   *
   * @param prev    предыдущий хранитель
   * @param newKeeper имя нового хранителя
   */
  public Secret(Secret prev, String newKeeper) {
    this.previous = prev;
    this.index = prev.index + 1;
    this.keeper = newKeeper;

    // FIXME: вывод текста предыдущего хранителя обязателен
    System.out.println(prev.keeper + " сказал что " + prev.text);

    this.text = modifyText(prev.text);
    this.changes = prev.changes + countChanges(prev.text, this.text);

    // FIXME: связывание цепочки — важная часть задания
    prev.next = this;
    this.next = null;

    System.out.println(newKeeper + " сказал что " + this.text);
  }

  /**
   * Генерирует случайную русскую букву.
   *
   * @return случайная буква
   */
  private char randomRussianLetter() {
    String letters = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
    Random r = new Random();
    return letters.charAt(r.nextInt(letters.length()));
  }

  /**
   * Вставляет X случайных русских букв в X случайных мест текста.
   * X зависит от длины текста и всегда ≥ 1, если длина ≥ 10.
   *
   * @param original исходный текст
   * @return изменённый текст
   */
  private String modifyText(String original) {
    Random r = new Random();

    int n = Math.max(1, original.length() / 10);
    int x;

    // FIXME: гарантируем хотя бы одно изменение для длинных текстов
    if (original.length() >= 10) {
      x = 1 + r.nextInt(n);
    } else {
      x = r.nextInt(n + 1);
    }

    StringBuilder sb = new StringBuilder(original);

    for (int i = 0; i < x; i++) {
      int pos = r.nextInt(sb.length() + 1);
      sb.insert(pos, randomRussianLetter());
    }

    return sb.toString();
  }

  /**
   * Подсчитывает количество добавленных символов.
   *
   * @param oldText старый текст
   * @param newText новый текст
   * @return число добавленных символов
   */
  private int countChanges(String oldText, String newText) {
    return Math.max(0, newText.length() - oldText.length());
  }

  /**
   * Возвращает строковое представление секрета.
   * Текст секрета не раскрывается.
   */
  @Override
  public String toString() {
    return keeper + ": это секрет!";
  }

  /**
   * Возвращает порядковый номер хранителя.
   */
  public int getIndexInChain() {
    return index;
  }

  /**
   * Возвращает количество людей, узнавших секрет после текущего.
   */
  public int getHowManyAfter() {
    int count = 0;
    Secret cur = this;

    while (cur.next != null) {
      cur = cur.next;
      count++;
    }

    return count;
  }

  /**
   * Возвращает имя хранителя, находящегося на расстоянии n.
   * Положительное n — вперёд, отрицательное — назад.
   *
   * @param n смещение относительно текущего
   * @return имя хранителя или null, если выйти за пределы цепочки
   */
  public String getRelativeKeeperName(int n) {
    Secret cur = this;

    if (n > 0) {
      for (int i = 0; i < n; i++) {
        if (cur.next == null) {
          return null;
        }
        cur = cur.next;
      }
      return cur.keeper;
    }

    if (n < 0) {
      for (int i = 0; i < -n; i++) {
        if (cur.previous == null) {
          return null;
        }
        cur = cur.previous;
      }
      return cur.keeper;
    }

    return keeper;
  }

  /**
   * Возвращает разницу в количестве изменений текста
   * между текущим хранителем и хранителем на расстоянии n.
   *
   * @param n смещение относительно текущего
   * @return разница изменений или -1, если хранитель не найден
   */
  public int getTextLengthDifferenceWith(int n) {
    Secret target = this;

    if (n > 0) {
      for (int i = 0; i < n; i++) {
        if (target.next == null) {
          return -1;
        }
        target = target.next;
      }
    } else if (n < 0) {
      for (int i = 0; i < -n; i++) {
        if (target.previous == null) {
          return -1;
        }
        target = target.previous;
      }
    }

    return this.changes - target.changes;
  }
}