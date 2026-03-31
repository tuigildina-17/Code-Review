#include "Header.h"

int main() {
  SetConsoleCP(1251);
  SetConsoleOutputCP(1251);

    /*FIX_ME: 
    * 1. Использование using namespace std;
    * 2. Присутствуют строки длиннее 80 символов
    * 3. Много лишних пустых строк (cout << endl;)
    * 4. Открывающиеся скобки были на отдельной строке
    * 5. Отсутствие проверки ввода
    * 6. Использование табуляции
    */
    /*srand(time(0));
    cout << "Добро пожаловать! Перед вами задача о неделимом рюкзаке. В чем её суть?" << endl;
    cout << "Археолог нашел N артефактов. Известны веса (сi) и ценности (di) артефактов." << endl;
    cout << "Нужно выбрать такое подмножество найденных вещей, чтобы суммарный их вес не превысил Z кг," << endl;
    cout << "а их общая ценность оказалась максимальной." << endl;
    cout << "-------------------------------------------------------" << endl;
    cout << endl;
    cout << endl;
    cout << "Вам неоюходимо будет ввести два числа: N - количество артифактов;" << endl;
    cout << "Z - суммарный вес, который нельзя привышать." << endl;
    cout << "После чего мы подсчитаем суммарный вес и максимальную ценность, а также выведем товары, которые были взяты." << endl;
    cout << "----------------------------------------------------------" << endl;
    cout << endl;
    cout << endl;*/
  std::srand(std::time(nullptr));

  std::cout << "Добро пожаловать! Перед вами задача о неделимом рюкзаке.\n";
  std::cout << "Археолог нашел N артефактов. Известны веса (сi) и "
        "ценности (di).\n";
  std::cout << "Нужно выбрать подмножество вещей, чтобы суммарный вес не "
        "превысил Z кг,\n";
  std::cout << "а их общая ценность была максимальной.\n\n";

    /*int n;
    cout << "Введите число N - количество артефактов: ";
    cin >> n;*/
  int n = read_positive_int("Введите число N - количество артефактов: ");
    /*int z;
    cout << "Введите число Z - вес, который нельзя привышать: ";
    cin >> z;*/
  int z = read_positive_int("Введите число Z - максимальный вес: ");

    //FIX_ME: Непонятное имя переменной
    /*fstream f1("a.txt");
    f1 << n << " " << z;
    f1 << endl;*/
  std::fstream file("a.txt");
  file << n << " " << z << "\n";
    /*FIX_ME:
    * 1. Ненужные комментарии
    * 2. Непонятные имена переменных*/
    //vector<int> p(n + 1, 0); // Цены (индексы от 1 до n)
    //vector<int> w(n + 1, 0); // Веса (индексы от 1 до n)
  std::vector<int> prices(n + 1, 0);
  std::vector<int> weights(n + 1, 0);

  for (int i = 1; i <= n; i++) {
        //w[i] = rand() % 50 + 1;
    weights[i] = std::rand() % 50 + 1;
        //f1 << w[i] << " ";
    file << weights[i] << " ";
  }
    //f1 << endl;
  file << "\n";

  for (int i = 1; i <= n; i++) {
        //p[i] = rand() % 101;
    prices[i] = std::rand() % 101;
        //f1 << p[i] << " ";
    file << prices[i] << " ";
  }
    //f1 << endl;
  file << "\n";

  double weight = 0;
    //vector<vector<int>> a(n + 1, vector<int>(z + 1, 0));
  std::vector<std::vector<int>> a(n + 1, std::vector<int>(z + 1, 0));

  for (int k = 1; k <= n; k++) {
    for (int s = 1; s <= z; s++) {
            //if (s >= w[k])
      if (s >= weights[k]) {
                //a[k][s] = max(a[k - 1][s], a[k - 1][s - w[k]] + p[k]);
      a[k][s] = max(a[k - 1][s], a[k - 1][s - weights[k]] + prices[k]);
      }
      else {
        a[k][s] = a[k - 1][s];
      }
    }
  }

    //cout << "Максимальная ценность рюкзака: " << a[n][z] << endl;
  std::cout << "Максимальная ценность рюкзака: " << a[n][z] << "\n";
    //find(a, n, z, w, weight);
  find(a, n, z, weights, weight);
    //cout << endl;
    //cout << "Максимальный вес рюкзака: " << weight << endl;
  std::cout << "\nМаксимальный вес рюкзака: " << weight << "\n";

    /*f1 << a[n][z] << " " << weight << endl;
    f1.close();*/
  file << a[n][z] << " " << weight << "\n";
  file.close();

  return 0;
}