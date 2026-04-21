ОТЧЁТ ПО ИСПРАВЛЕНИЮ КОД-РЕВЬЮ МАШИ
- Исправленные ошибки:
1. Добавлена проверка на то, что введённая строка является числом
- Реализован безопасный метод:
-  private static String readNumberString(String message) {
-   while (true) {
-    String s = InputUtils.readNonEmptyString(message);
-    try {
-    Integer.parseInt(s);
-    return s;
-    } catch (NumberFormatException e) {
-    System.out.println("Ошибка: введите целое число!\n");
-    }
-  }
-}
2. Удаление лишних комментариев
- Устаревшие, дублирующие и неинформативные комментарии были удалены, что улучшило читаемость кода.
