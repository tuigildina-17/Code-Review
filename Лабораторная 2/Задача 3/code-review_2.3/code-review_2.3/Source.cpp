#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена функций и переменных не соответствуют стилю
* 3. Комментарии излишни
* 4. Использование табуляции
*/
Node::Node(int value) : data(value), next(nullptr) {}

LinkedList::LinkedList() : head(nullptr) {}

void LinkedList::add(int value) {
    //Node* newNode = new Node(value);
  Node* new_node = new Node(value);
  if (head == nullptr) {
        //head = newNode;
    head = new_node;
  }
  else {
    Node* current = head;
    while (current->next != nullptr) {
      current = current->next;
    }
        //current->next = newNode;
    current->next = new_node;
  }
}

//void LinkedList::insertBeforeEverySecond(int M) {
void LinkedList::insert_before_every_second(int m) {
  Node* current = head;
  int count = 1;                  // Счетчик для отслеживания позиции

  while (current != nullptr && current->next != nullptr) {
        /*if (count % 2 == 1) {       // Если текущий элемент — первый в паре
            Node* newNode = new Node(M); // Создаем новый узел со значением M
            newNode->next = current->next; // Новый узел указывает на следующий элемент
            current->next = newNode; // Текущий узел указывает на новый узел
            current = newNode->next; // Переходим к следующему элементу
        }*/
    if (count % 2 == 1) {
      Node* new_node = new Node(m);
      new_node->next = current->next;
      current->next = new_node;
      current = new_node->next;
    }
    else {
      current = current->next;
    }
    count++;
  }
}

void LinkedList::print() {
    /*Node* current = head;           // Начинаем с головы списка
    while (current != nullptr) {    // Пока не дойдем до конца списка
        cout << current->data << " "; // Выводим данные текущего узла
        current = current->next;    // Переходим к следующему узлу
    }
    cout << endl;         // Переход на новую строку после вывода*/
  Node* current = head;
  while (current != nullptr) {
    std::cout << current->data << " ";
    current = current->next;
  }
  std::cout << std::endl;
}

//Node* LinkedList::getLastNode() {
Node* LinkedList::get_last_node() {
  Node* current = head;
  while (current != nullptr && current->next != nullptr) {
    current = current->next;
  }
  return current;
}

//void LinkedList::clearList() {
void LinkedList::clear_list() {
  while (head != nullptr) {
    Node* temp = head;
    head = head->next;
    delete temp;
    }
    //cout << "Список очищен." << endl;
  std::cout << "Список очищен." << std::endl;
}

//void insertBeforeEverySecond(LinkedList& list, int M) {
void insert_before_every_second(LinkedList& list, int m) {
    //list.insertBeforeEverySecond(M);
  list.insert_before_every_second(m);
}

//FIX_ME: Отутствие проверки корректности ввода
int read_int(const char* prompt) {
  int value = 0;

  std::cout << prompt;

  while (true) {
    if (std::cin >> value) {
      if (value >= 0) {
        return value;
      }

      std::cout << "Ошибка: число не может быть отрицательным. Повторите ввод: ";
    }
    else {
      std::cout << "Ошибка: введите целое число: ";
      std::cin.clear();
      std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    }
  }
}