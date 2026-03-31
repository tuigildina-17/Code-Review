#include "Header.h"

int main() {
  setlocale(0, "");
    /*FIX_ME: 
    * 1. Названия переменных не соответствуют стилю
    * 2. Использование using namespace std;
    * 3. Использование табуляции
    * */
    //fstream f1("f1.txt");
  std::fstream input("f1.txt");

    /*if (!f1.is_open()) {
        cout << "Не удалось открыть файл f1.txt(" << endl;*/
  if (!input.is_open()) {
    std::cout << "Не удалось открыть файл f1.txt\n";
    return 1;
  }

    /*fstream f2("f2.txt");
    if (!f2.is_open()) {
        cout << "Не удалось открыть файл f2.txt(" << endl;*/
  std::fstream output("f2.txt");
  if (!output.is_open()) {
    std::cout << "Не удалось открыть файл f2.txt\n";
    return 1;
  }

  int n;
    //f1 >> n;
  input >> n;

    //FIX_ME: Отсутствие проверки диапазона
  if (!input || n <= 1 || n >= 80) {
    std::cout << "Ошибка: некорректное значение N. Ожидалось: 1 < N < 80.\n";
    return 1;
  }

    //vector<vector<int>> board(n, vector<int>(n));
  std::vector<std::vector<int>> board(n, std::vector<int>(n));
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
            //f1 >> board[i][j];
      if (!(input >> board[i][j])) {
        std::cout << "Ошибка: недостаточно данных или неверный формат.\n";
        return 1;
      }
      if (board[i][j] < 1 || board[i][j] > 100) {
        std::cout << "Ошибка: значение монеты вне диапазона 1..100.\n";
        return 1;
      }
    }
  }

    //vector<vector<int>> board2(n, vector<int>(n, 0));
  std::vector<std::vector<int>> board_opt(n, std::vector<int>(n, 0));

    //Solve(board, board2, n);
  solve(board, board_opt, n);

    /*f2 << board2[0][0] << endl;
    f2 << Path(board2, n);*/
  output << board_opt[0][0] << '\n';
  output << path(board_opt, n);

    /*f1.close();
    f2.close();*/
  input.close();
  output.close();

  return 0;
}