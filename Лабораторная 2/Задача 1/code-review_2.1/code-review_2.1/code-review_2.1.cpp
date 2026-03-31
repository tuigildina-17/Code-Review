#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена класса, полей и переменных не соответствуют стилю
* 3. Использование табуляции
* 4. Отсутствие проверки ввода
*/
int main() {
    //stack stack;
  Stack stack;
  setlocale(LC_ALL, "RU");

    //cout << "Введите количество элементов стека" << endl;
  std::cout << "Введите количество элементов стека" << std::endl;
  int n;
    //cin >> n;
  //FIX_ME: Отсутствие проверки на корректность ввода
  while (true) {
    std::cin >> n;

    if (std::cin.fail() || n <= 0) {
      std::cin.clear();
      std::cin.ignore(10000, '\n');
      std::cout << "Ошибка! Введите положительное число." << std::endl;
      continue;
    }
    break;
  }

  for (int i = 0; i < n; i++) {
        /*int num;
        cout << "Введите элемент стека" << endl;
        cin >> num;
        stack.add(num);*/
    std::cout << "Введите элемент стека" << std::endl;
    int num;
    //std::cin >> num;
    //FIX_ME: Отсутствие проверки на корректность ввода
    while (true) {
      std::cin >> num;

      if (std::cin.fail() || num <= 0) {
        std::cin.clear();
        std::cin.ignore(10000, '\n');
        std::cout << "Ошибка! Введите положительное число." << std::endl;
        continue;
      }
      break;
    }
    stack.add(num);
  }

    //cout << "Стек:" << endl;
  std::cout << "Стек:" << std::endl;
  stack.show();

    //stack.topdel();
  stack.delete_top();

  return 0;
}