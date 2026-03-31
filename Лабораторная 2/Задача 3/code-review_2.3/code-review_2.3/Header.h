/*
Все динамические структуры данных реализовывать через классы. Не использовать STL.  Для каждой динамической структуры должен быть предусмотрен
стандартный набор методов - добавления/удаления/вывода элементов. Во всех задачах обязательно
наличие дружественного интерфейса. Ввод данных с клавиатуры.

Дан односвязный линейный список и указатель на голову списка P1. Необходимо
вставить значение M перед каждым вторым элементом списка, и вывести ссылку на последний
элемент полученного списка P2. При нечетном числе элементов исходного списка в конец
списка вставлять не надо.
*/

#pragma once
#include <iostream>
#include <limits>
//FIX_ME: Google Style запрещает использование using namespace std;
// using namespace std;

class Node {
public:
  int data;
  Node* next;
  Node(int value);
};

class LinkedList {
private:
  Node* head;

public:
  LinkedList();

  void add(int value);
    //FIX_ME: Имена функций не соответствуют стилю
    //void insertBeforeEverySecond(int M);
  void insert_before_every_second(int m);
  void print();
    //Node* getLastNode();
  Node* get_last_node();
    //void clearList();
  void clear_list();

    //friend void insertBeforeEverySecond(LinkedList& list, int M);
  friend void insert_before_every_second(LinkedList& list, int m);
};

//void insertBeforeEverySecond(LinkedList& list, int M);
void insert_before_every_second(LinkedList& list, int m);

//FIX_ME: Отутствие проверки корректности ввода
int read_int(const char* prompt);