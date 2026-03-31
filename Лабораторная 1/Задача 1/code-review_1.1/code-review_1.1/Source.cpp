#include "Header.h"

/*FIX_ME: 
* 1. Строка длиннее 80 символов
* 2. Открывающиеся скобки на отдельной строке
* 3. Использование табуляции
*/
//void find(const vector<vector<int>>& a, int k, int s, const vector<int>& w, double& weight)
void find(const std::vector<std::vector<int>>& a, int k, int s,
  const std::vector<int>& w, double& weight) {
    /*FIX_ME:
    * 1. Несодержательные коментарии
    * 2. Использование using namespace std;
    * */
  if (k == 0 || s == 0) return;
    //if (a[k][s] == a[k - 1][s]) // если коробка не была выбрана
  if (a[k][s] == a[k - 1][s]) {
    find(a, k - 1, s, w, weight);
  }
    //else // если коробка была выбрана
  else {
        //cout << k << " "; // выводим номер коробки
    std::cout << k << " ";
    weight += w[k];
        //find(a, k - 1, s - w[k], w, weight); // ищем оставшиеся коробки
    find(a, k - 1, s - w[k], w, weight);
  }
}

//FIX_ME: Отсутствие проверки на ввод
int read_positive_int(const std::string& prompt) {
  int value;
  std::cout << prompt;
  std::cin >> value;

  while (std::cin.fail() || value <= 0) {
    std::cin.clear();

    std::cin.ignore(1000000000, '\n');

    std::cout << "Ошибка! Введите положительное целое число: ";
    std::cin >> value;
  }

  return value;
}