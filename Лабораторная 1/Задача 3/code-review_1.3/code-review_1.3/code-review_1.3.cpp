#include "Header.h"

/*FIX_ME:
* 1. Название функции не соответствует стилю
* 2. Открывающиеся скобки на отдельной строке
* 3. Использование using namespace std;
* 4. Использование табуляции
*/
int main() {
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);

  int k, n;

  while (true) {
        /*cout << "Введите основание системы счисления K(2 <= K <= 10): ";
        cin >> k;*/
    std::cout << "Введите основание системы счисления K(2 <= K <= 10): ";
    std::cin >> k;
        //FIX_ME: Неполноценная проверка корректности ввода
    if (std::cin.fail()) {
      std::cin.clear();
      std::cin.ignore(10000, '\n');
      std::cout << "Ошибка: введите число.\n";
      continue;
    }
    if (k >= 2 && k <= 10)
      break;

        //cout << "Некорректный ввод. Повторите попытку." << endl;
    std::cout << "Некорректный ввод. Повторите попытку.\n";
  }

  while (true) {
        /*cout << "Введите кол-во разрядов N(1 < N < 20): ";
        cin >> n;*/
    std::cout << "Введите кол-во разрядов N(1 < N < 20): ";
    std::cin >> n;
        //FIX_ME: Неполноценная проверка корректности ввода
    if (std::cin.fail()) {
      std::cin.clear();
      std::cin.ignore(10000, '\n');
      std::cout << "Ошибка: введите число.\n";
      continue;
    }
    if (n > 1 && n < 20 && (n + k) < 26)
      break;
        //cout << "Некорректный ввод. Повторите попытку." << endl;
      std::cout << "Некорректный ввод. Повторите попытку.\n";
    }

    //double total = CountValidNumbers(k, n);
  double total = count_valid_numbers(k, n);

    //cout << "Количество чисел: " << total << endl;
  std::cout << "Количество чисел: " << total << "\n";

  return 0;
}