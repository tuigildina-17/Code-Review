#include "Header.h"

int main() {
    // FIX_ME: Отсутствие кодировки ввода консоли для работы с русскими буквами
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    setlocale(LC_ALL, "RU");

    //FIX_ME: Запрещено использовать using namespace std;
    /*cout << "Введите сообщение для преобразования в азбуку Морзе: ";
    string message;
    getline(cin, message);
    */
    std::string message;
    std::cout << "Введите сообщение для преобразования в азбуку Морзе: ";
    std::getline(std::cin, message);

    if (!is_valid_input(message)) {
        //FIX_ME: Строка была длиннее 80 символов
        // std::cout << "Ошибка: ввод должен содержать только русские буквы и"пробелы.\n";
        std::cout << "Ошибка: ввод должен содержать только русские буквы"
            "и пробелы.\n";
        return 1;
    }

    std::string morse_message = to_morse_code(message);
    //FIX_ME: Имя переменной нарушает стиль
    //cout << "Сообщение в азбуке Морзе: " << morseMessage << endl;
    std::cout << "Сообщение в азбуке Морзе: " << morse_message << "\n";


    return 0;
}