#include "Header.h"

int main() {
    // FIX_ME: Отсутствие кодировки ввода консоли для работы с русскими буквами
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    setlocale(LC_ALL, "RU");

    std::string text;
    std::cout << "Введите сообщение: ";
    std::getline(std::cin, text);

    if (!is_valid_input(text)) {
        //FIX_ME: Строка была длиннее 80 символов
        // std::cout << "Ошибка: ввод должен содержать только русские буквы и пробелы.\n";
        std::cout << "Ошибка: ввод должен содержать только русские буквы"
            "и пробелы.\n";
        return 1;
    }

    process_morse(text);

    return 0;
}