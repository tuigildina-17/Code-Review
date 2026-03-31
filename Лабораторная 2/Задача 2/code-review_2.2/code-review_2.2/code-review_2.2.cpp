#include "Header.h"

/*FIX_ME:
* 1. Использование using namespace std;
* 2. Имена функций, полей и переменных не соответствуют стилю
* 3. Использование табуляции
*/

int main() {
  setlocale(LC_ALL, "ru");
  Queue q;
    /*string in;
    string inum;*/
  std::string input;
  std::string input_num;
  int num;
  int n;

    //cout << "Введите количество элементов в очереди: ";
  std::cout << "Введите количество элементов в очереди: ";
    //cin >> in;
  std::cin >> input;
    //if (!IsNumber(in)) {
  if (!is_number(input)) {
        //cout << "Недопустимое значение.";
    std::cout << "Недопустимое значение.";
    return 1;
  }
  else {
        //n = stoi(in);
    n = std::stoi(input);
  }

    //cout << "Введите элементы очереди: ";
  std::cout << "Введите элементы очереди: ";
  for (int i = 1; i <= n; i++) {
        //cin >> inum;
    std::cin >> input_num;
        //if (!IsNumber(inum)) {
    if (!is_number(input_num)) {
            //cout << "Недопустимое значение.";
      std::cout << "Недопустимое значение.";
      return 1;
    }
    else {
            //num = stoi(inum);
      num = std::stoi(input_num);
      q.push(num);
    }
  }

  std::cout << "Изначальная очередь: ";
  q.show();

  std::cout << "Извлеченные элементы: ";
    //q.EvenHead();
  q.even_head();

  std::cout << "Измененная очередь: ";
  q.show();

  std::cout << "Значение первого элемента: ";
    //q.getP1data();
  q.get_p1_data();
  std::cout << std::endl;

    //cout << "Новый адрес начала очереди (P1): " << q.getP1() << endl;
  std::cout << "Новый адрес начала очереди (P1): " << q.get_p1() << std::endl;

  std::cout << "Значение последнего элемента: ";
    //q.getP2data();
  q.get_p2_data();
  std::cout << std::endl;

    //cout << "Новый адрес конца очереди (P2): " << q.getP2() << endl;
  std::cout << "Новый адрес конца очереди (P2): " << q.get_p2() << std::endl;

  return 0;
}