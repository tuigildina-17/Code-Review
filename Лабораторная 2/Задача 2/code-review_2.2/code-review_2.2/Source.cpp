#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена функций, полей и переменных не соответствуют стилю
* 3. Комментарии отвечали на вопрос "что", а не "почему"
* 4. Использование табуляции
*/

//bool IsNumber(const string& str) {
bool is_number(const std::string& str) {
  if (str.empty()) return false;
  int start = (str[0] == '-' || str[0] == '+') ? 1 : 0;
  for (int i = start; i < str.length(); ++i) {
    if (!isdigit(str[i])) return false;
  }
  return start < str.length();
}

//Queue::Queue() : P1(nullptr), P2(nullptr) {}
Queue::Queue() : p1_(nullptr), p2_(nullptr) {}

void Queue::push(int num) { // Добавление элемента в очередь
    /*Node* newNode = new Node;
    newNode->data = num;
    newNode->next = nullptr;*/
  Node* new_node = new Node;
  new_node->data = num;
  new_node->next = nullptr;
    /*if (!P2) {
        P1 = P2 = newNode;
    }
    else {
        P2->next = newNode;
        P2 = newNode;
    }*/
  if (!p2_) {
    p1_ = p2_ = new_node;
  }
  else {
    p2_->next = new_node;
    p2_ = new_node;
  }
}

//void Queue::show() { // Вывод элементов
void Queue::show() {
    //Node* temp = P1;
  Node* temp = p1_;
  if (!temp) {
        //cout << "Очередь пустая" << endl;
    std::cout << "Очередь пустая\n";
    return;
  }
  while (temp) {
        //cout << temp->data << " ";
    std::cout << temp->data << " ";
    temp = temp->next;
  }
    //cout << endl;
  std::cout << std::endl;
}

//bool Queue::pop(int& num) { // Извлечение элемента из очереди
bool Queue::pop(int& num) {
    //if (!P1) return false; // Очередь пуста
  if (!p1_) return false;

    /*Node* temp = P1;
    num = P1->data;
    P1 = P1->next;
    if (!P1) P2 = nullptr; // Если очередь стала пустой*/
  Node* temp = p1_;
  num = p1_->data;
  p1_ = p1_->next;
  if (!p1_) p2_ = nullptr;

  delete temp;
  return true;
}

/*Queue::Node* Queue::getP1() const {
    return P1;
}*/
Queue::Node* Queue::get_p1() const {
  return p1_;
}

/*void Queue::getP1data() const {
    if (P1) cout << P1->data;
    else cout << "nullptr";
}*/
void Queue::get_p1_data() const {
  if (p1_) std::cout << p1_->data;
  else std::cout << "nullptr";
}

/*void Queue::getP2data() const {
    if (P2) cout << P2->data;
    else cout << "nullptr";
}*/
void Queue::get_p2_data() const {
  if (p2_) std::cout << p2_->data;
  else std::cout << "nullptr";
}

/*Queue::Node* Queue::getP2() const {
    return P2;
}*/
Queue::Node* Queue::get_p2() const {
  return p2_;
}

//void Queue::EvenHead() { // Извлечение элементов, пока не встретится четное значение
void Queue::even_head() {
  int num;
    //while (!(P1 == nullptr) && (P1->data % 2 != 0)) {
  while (p1_ != nullptr && (p1_->data % 2 != 0)) {
    pop(num);
        //cout << num << " ";
    std::cout << num << " ";
  }
    //cout << endl;
  std::cout << "\n";
}

Queue::~Queue() {
  int del;
  while (pop(del));
}