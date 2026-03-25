#include "Header.h"

int main() {
    // FIX_ME: Отсутствие кодировки ввода консоли для работы с русскими буквами
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    setlocale(LC_ALL, "RU");

    //FIX_ME: Запрещено использовать using namespace std;
    /*string input;
    cout << "Введите сообщение на русском языке: ";
    getline(cin, input);
    */
    std::string input;
    std::cout << "Введите сообщение на русском языке: ";
    std::getline(std::cin, input);

    if (!is_valid_input(input)) {
        //FIX_ME: Строка была длиннее 80 символов
        // std::cout << "Ошибка: ввод должен содержать только русские буквы и пробелы.\n";
        std::cout << "Ошибка: ввод должен содержать только русские буквы и "
            "пробелы.\n"; 
        return 0;
    }

    process_morse(input);

    return 0;
}