/* Дан двусвязный линейный список и указатель первый элемент этого
списка. Все элементы списка хранят различные между собой значения. Необходимо
вывести значения элементов списка, которые находятся между наименьшим и
наибольшим элементами списка, в том порядке, в каком они находятся в исходном
списке. Использовать процедуры.

Все динамические структуры данных реализовывать через классы. Не использовать STL.  Для каждой динамической структуры должен быть предусмотрен
стандартный набор методов - добавления/удаления/вывода элементов.
Во всех задачах обязательно наличие дружественного интерфейса. Ввод данных с клавиатуры.*/

#pragma once
#include <iostream>
//FIX_ME: Google Style запрещает использование using namespace std;
// using namespace std;

/*FIX_ME:
* 1. Имена функций, полей, переменных не соответствуют стилю
* 2. Излишние комментарии
* */
/*// Структура узла двусвязного списка
struct Uzel {
    int Znachenie;         // Значение узла
    Uzel* Predydushiy;      // Указатель на предыдущий узел
    Uzel* Sleduyushiy;      // Указатель на следующий узел
};*/
struct Node {
  int value;
  Node* prev;
  Node* next;
};

/*// Класс для работы с двусвязным списком
class Spisok {*/
class List {
private:
    //Uzel* PerviyElement;    // Указатель на первый элемент списка
  Node* first_element;
public:
    //void Initsializatsiya();
  void init();
    //void Ochistka();
  void clear();
    //void DobavitElement(int Znachenie);
  void add_element(int value);
    //void VivodSpiska();
  void print_list();
    //void PoiskMinMax(Uzel*& Min, Uzel*& Max);
  void find_min_max(Node*& min, Node*& max);
    //bool ProverkaPoryadka(Uzel* A, Uzel* B);
  bool is_first_before(Node* a, Node* b);
    //void VivodMezhduMinMax();
  void print_between_min_max();
};
