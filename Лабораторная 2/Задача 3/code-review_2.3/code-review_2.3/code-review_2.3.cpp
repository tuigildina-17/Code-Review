#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена функций и переменных не соответствуют стилю
* 3. Комментарии излишни
* 4. Использование табуляции
*/
int main() {
    // FIX_ME: Отсутствие кодировки ввода консоли для работы с русскими буквами
  setlocale(LC_ALL, "RU");
  LinkedList list;

    //FIX_ME: Отутствие проверки корректности ввода
    /*int n, value, M;
    cout << "Введите количество элементов в списке: ";
    cin >> n;*/
  int n = read_int("Введите количество элементов в списке: ");

  std::cout << "Введите элементы списка: ";
  for (int i = 0; i < n; ++i) {
        //cin >> value;               // Вводим значение элемента
    int value = read_int("");
    list.add(value);
  }

    /*cout << "Введите значение M для вставки: ";
    cin >> M;*/
  int m = read_int("Введите значение M для вставки: ");

    /*// Вставка значения M перед каждым вторым элементом
    insertBeforeEverySecond(list, M);*/
  insert_before_every_second(list, m);

  std::cout << "Список после вставки: ";
  list.print();

    /*// Получение указателя на последний элемент списка
    Node* lastNode = list.getLastNode();*/
  Node* last_node = list.get_last_node();

    /*// Вывод результата
    if (lastNode != nullptr) {
        std::cout << "Указатель на последний элемент списка: " << lastNode << std::endl;
        std::cout << "Значение последнего элемента: " << lastNode->data << std::endl;*/
  if(last_node != nullptr) {
    std::cout << "Указатель на последний элемент списка: " << last_node << std::endl;
    std::cout << "Значение последнего элемента: " << last_node->data << std::endl;
  }
  else {
    std::cout << "Список пуст." << std::endl;
  }

    //list.clearList();
  list.clear_list();

  std::cout << "Проверка списка после очистки: ";
  list.print();

  return 0;
}