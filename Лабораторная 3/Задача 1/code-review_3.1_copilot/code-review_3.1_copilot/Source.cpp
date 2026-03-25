#include "Header.h"

/*FIX_ME: 
1. Название константы не соответствует Google Style 
2. Таблица была глобальной переменной 
*/
// std::map<char, std::string> morse = {
static const std::map<char, std::string>& get_morse_map() {
    static const std::map<char, std::string> kMorse = {
        {'А', "·-"},    {'Б', "-···"},  {'В', "·--"},   {'Г', "--·"},
        {'Д', "-··"},   {'Е', "·"},     {'Ж', "···-"},  {'З', "--··"},
        {'И', "··"},    {'Й', "·---"},  {'К', "-·-"},   {'Л', "·-··"},
        {'М', "--"},    {'Н', "-·"},    {'О', "---"},   {'П', "·--·"},
        {'Р', "·-·"},   {'С', "···"},   {'Т', "-"},     {'У', "··-"},
        {'Ф', "··-·"},  {'Х', "····"},  {'Ц', "-·-·"},  {'Ч', "---·"},
        {'Ш', "----"},  {'Щ', "--·-"},  {'Ъ', "·--·-·"}, {'Ы', "-·--"},
        {'Ь', "-··-"},  {'Э', "··-··"}, {'Ю', "··--"},  {'Я', "·-·"}
    };
    return kMorse;
}

//FIX_ME: Не было проверки корректности ввода
bool is_valid_input(const std::string& input) {
    const auto& morse = get_morse_map();

    for (char ch : input) {
        if (ch == ' ') {
            continue;
        }

        unsigned char up = static_cast<unsigned char>(std::toupper(ch));

        if (up == 'Ё') {
            up = 'Е';
        }

        if (morse.find(static_cast<char>(up)) == morse.end()) {
            return false;
        }
    }
    return true;
}

void process_morse(const std::string& text) {
    /*FIX_ME: Использовалась глобальная переменная morse
    (не было вызова статической функции)*/
    const auto& morse = get_morse_map();

    std::cout << "Телеграф (азбука Морзе):\n";

    for (size_t i = 0; i < text.size(); ++i) {
        unsigned char ch = text[i];
        //FIX_ME: Комментарии были несодержательны
        /*// Пробел — разделитель слов
        if (ch == ' ') {
            std::cout << "   "; // несколько пробелов между словами
            continue;
        }*/
        if (ch == ' ') {
            std::cout << "   ";
            continue;
        }

        ch = static_cast<unsigned char>(std::toupper(ch));

        auto it = morse.find(static_cast<char>(ch));
        if (it != morse.end()) {
            std::cout << it->second << ' ';
        }
        else {
            std::cout << "? ";
        }
    }

    std::cout << std::endl;
}