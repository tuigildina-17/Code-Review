#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена класса, полей и переменных не соответствуют стилю
* 3. Комментарии отвечали на вопрос "что", а не "почему"
* 4. Использование табуляции
* 5. Отсутствие проверки ввода
*/
//stack::stack() : p1(nullptr), cnt(0) {}
Stack::Stack() : top_(nullptr), count_(0) {}

/*void stack::add(int x) {
    Node* newnode = new Node(x);
    newnode->next = p1;
    p1 = newnode;
    cnt++;
}*/
void Stack::add(int value) {
  Node* new_node = new Node(value);
  new_node->next = top_;
  top_ = new_node;
  count_++;
}

/*void stack::topdel() { //извлечение 1 элемента и его удаление
    Node* temp = p1;
    cout << "Первый элемент стека:" << endl;
    cout << p1->d << endl;*/
void Stack::delete_top() {
  Node* temp = top_;
  std::cout << "Первый элемент стека:" << std::endl;
  std::cout << top_->data << std::endl;

    /*if (p1->next == nullptr) {
        p1 = nullptr;
    }
    else {
        p1 = p1->next;
    }*/
  if (top_->next == nullptr) {
    top_ = nullptr;
  }
  else {
    top_ = top_->next;
  }
    /*cout << "Адрес новой вершины p1 после извлечения 1 элемента: " << p1 << endl; // Вывод адреса новой вершины
    if (p1 != nullptr) {
        cout << "Значение новой вершины p1: " << p1->d << endl; // Вывод значения новой вершины
    }*/
  std::cout << "Адрес новой вершины p1 после извлечения 1 элемента: "
    << top_ << std::endl;

  if (top_ != nullptr) {
    std::cout << "Значение новой вершины p1: " << top_->data << std::endl;
  }

  delete temp;
    //cnt--;
  count_--;
}

//void stack::show() {
void Stack::show() {
    //Node* temp = p1;
  Node* temp = top_;
  while (temp != nullptr) {
        //cout << temp->d << endl;
    std::cout << temp->data << std::endl;
    temp = temp->next;
  }
}