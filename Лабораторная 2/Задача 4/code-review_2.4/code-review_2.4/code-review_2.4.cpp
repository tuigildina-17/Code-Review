#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена функций, полей и переменных не соответствуют стилю
* 3. Комментарии отвечают на вопрос "что", а не "почему"
* 4. Использование табуляции
*/

int main() {
  setlocale(LC_ALL, "Russian");
    /*Spisok Spisok;
    Spisok.Initsializatsiya();*/
  List list;
  list.init();

    /*cout << "Введите количество элементов: ";
    int N;
    cin >> N;*/
  std::cout << "Введите количество элементов: ";
  int n;
  std::cin >> n;

    /*if (N <= 0) {
        cout << "Некорректное число!" << endl;
        return 0;
    }*/
  if (n <= 0) {
    std::cout << "Некорректное число!" << std::endl;
    return 0;
  }

    /*cout << "Вводите элементы:" << endl;
    for (int i = 0; i < N; i++) {
        int Chislo;
        if (!(cin >> Chislo)) {
            cout << "Ошибка ввода!" << endl;
            return 0;
        }
        Spisok.DobavitElement(Chislo);
    }*/
  std::cout << "Вводите элементы:" << std::endl;
  for (int i = 0; i < n; i++) {
    int number;  // CHANGE: Chislo → number
    if (!(std::cin >> number)) {
      std::cout << "Ошибка ввода!" << std::endl;
      return 0;
    }
    list.add_element(number);
  }

    /*cout << "Список: ";
    Spisok.VivodSpiska();
    Spisok.VivodMezhduMinMax();
    Spisok.Ochistka();*/
  std::cout << "Список: ";
  list.print_list();
  list.print_between_min_max();
  list.clear();

  return 0;
}