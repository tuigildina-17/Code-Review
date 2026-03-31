#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена функций, полей и переменных не соответствуют стилю
* 3. Комментарии отвечают на вопрос "что", а не "почему"
* 4. Использование табуляции
*/

/*// Инициализация списка
void Spisok::Initsializatsiya() {
    PerviyElement = nullptr;
}*/
void List::init() {
  first_element = nullptr;
}

/*// Очистка списка
void Spisok::Ochistka() {
    Uzel* Tekushiy = PerviyElement;
    while (Tekushiy != nullptr) {
        Uzel* Vremenniy = Tekushiy;
        Tekushiy = Tekushiy->Sleduyushiy;
        delete Vremenniy;
    }
    PerviyElement = nullptr;
}*/
void List::clear() {
  Node* current = first_element;
  while (current != nullptr) {
    Node* temp = current;
    current = current->next;
    delete temp;
  }
  first_element = nullptr;
}

/*// Добавление элемента в конец списка
void Spisok::DobavitElement(int Znachenie) {
    Uzel* Noviy = new Uzel;
    Noviy->Znachenie = Znachenie;
    Noviy->Predydushiy = nullptr;
    Noviy->Sleduyushiy = nullptr;

    if (PerviyElement == nullptr) {
        PerviyElement = Noviy;
    }
    else {
        Uzel* Tekushiy = PerviyElement;
        while (Tekushiy->Sleduyushiy != nullptr) {
            Tekushiy = Tekushiy->Sleduyushiy;
        }
        Tekushiy->Sleduyushiy = Noviy;
        Noviy->Predydushiy = Tekushiy;
    }
}*/
void List::add_element(int value) {
  Node* node = new Node;
  node->value = value;
  node->prev = nullptr;
  node->next = nullptr;

  if (first_element == nullptr) {
    first_element = node;
  }
    else {
      Node* current = first_element;
      while (current->next != nullptr) {
        current = current->next;
      }
      current->next = node;
      node->prev = current;
    }
}

/*// Вывод всех элементов списка
void Spisok::VivodSpiska() {
    Uzel* Tekushiy = PerviyElement;
    while (Tekushiy != nullptr) {
        cout << Tekushiy->Znachenie << " ";
        Tekushiy = Tekushiy->Sleduyushiy;
    }
    cout << endl;
}*/
void List::print_list() {
  Node* current = first_element;
  while (current != nullptr) {
    std::cout << current->value << " ";
    current = current->next;
  }
  std::cout << std::endl;
}

/*// Поиск минимального и максимального элементов
void Spisok::PoiskMinMax(Uzel*& Min, Uzel*& Max) {
    if (PerviyElement == nullptr) return;

    Min = Max = PerviyElement;
    Uzel* Tekushiy = PerviyElement->Sleduyushiy;

    while (Tekushiy != nullptr) {
        if (Tekushiy->Znachenie < Min->Znachenie) Min = Tekushiy;
        if (Tekushiy->Znachenie > Max->Znachenie) Max = Tekushiy;
        Tekushiy = Tekushiy->Sleduyushiy;
    }
}*/
void List::find_min_max(Node*& min, Node*& max) {  // CHANGE
  if (first_element == nullptr) return;

  min = max = first_element;
  Node* current = first_element->next;

  while (current != nullptr) {
    if (current->value < min->value) min = current;
    if (current->value > max->value) max = current;
    current = current->next;
  }
}

/*// Проверка, какой элемент встречается раньше
bool Spisok::ProverkaPoryadka(Uzel* A, Uzel* B) {
    Uzel* Tekushiy = PerviyElement;
    while (Tekushiy != nullptr) {
        if (Tekushiy == A) return true;
        if (Tekushiy == B) return false;
        Tekushiy = Tekushiy->Sleduyushiy;
    }
    return false;
}*/
bool List::is_first_before(Node* a, Node* b) {  // CHANGE
  Node* current = first_element;
  while (current != nullptr) {
    if (current == a) return true;
    if (current == b) return false;
    current = current->next;
  }
  return false;
}

/*// Вывод элементов между минимальным и максимальным
void Spisok::VivodMezhduMinMax() {
    Uzel* Min = nullptr;
    Uzel* Max = nullptr;
    PoiskMinMax(Min, Max);

    if (Min == nullptr || Max == nullptr || Min == Max) {
        cout << "Нет элементов для вывода!" << endl;
        return;
    }

    bool MinPerviy = ProverkaPoryadka(Min, Max);
    Uzel* Start = MinPerviy ? Min : Max;
    Uzel* End = MinPerviy ? Max : Min;

    cout << "Элементы между " << Min->Znachenie << " и " << Max->Znachenie << ": ";
    Uzel* Tekushiy = Start->Sleduyushiy;
    bool EstElementy = false;

    while (Tekushiy != nullptr && Tekushiy != End) {
        cout << Tekushiy->Znachenie << " ";
        EstElementy = true;
        Tekushiy = Tekushiy->Sleduyushiy;
    }

    if (!EstElementy) cout << "Отсутствуют";
    cout << endl;
}*/
void List::print_between_min_max() {
  Node* min = nullptr;
  Node* max = nullptr;
  find_min_max(min, max);

  if (min == nullptr || max == nullptr || min == max) {
    std::cout << "Нет элементов для вывода!" << std::endl;
    return;
  }

  bool min_first = is_first_before(min, max);
  Node* start = min_first ? min : max;
  Node* end = min_first ? max : min;

  std::cout << "Элементы между " << min->value
    << " и " << max->value << ": ";

  Node* current = start->next;
  bool has_elements = false;

  while (current != nullptr && current != end) {
    std::cout << current->value << " ";
    has_elements = true;
    current = current->next;
  }

  if (!has_elements) std::cout << "Отсутствуют";
  std::cout << std::endl;
}