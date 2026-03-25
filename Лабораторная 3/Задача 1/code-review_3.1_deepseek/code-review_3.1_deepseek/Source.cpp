#include "Header.h"

/*FIX_ME:
* 1. Google Style запрещает using namespace
* 2. Глобальные переменные запрещены Google Style
* 3. Константы должны называться kCamelCase
*/
// static map<char, string> morse = {
static const std::map<char, std::string>& get_morse_map() {
    static const std::map<char, std::string> kMorse = {
    {'А', "·-"},    {'Б', "-···"},  {'В', "·--"},   {'Г', "--·"},
    {'Д', "-··"},   {'Е', "·"},      {'Ж', "···-"},  {'З', "--··"},
    {'И', "··"},    {'Й', "·---"},   {'К', "-·-"},   {'Л', "·-··"},
    {'М', "--"},    {'Н', "-·"},     {'О', "---"},   {'П', "·--·"},
    {'Р', "·-·"},   {'С', "···"},    {'Т', "-"},     {'У', "··-"},
    {'Ф', "··-·"},  {'Х', "····"},   {'Ц', "-·-·"},  {'Ч', "---·"},
    {'Ш', "----"},  {'Щ', "--·-"},   {'Ъ', "·--·-·"}, {'Ы', "-·--"},
    {'Ь', "-··-"},  {'Э', "··-··"},  {'Ю', "··--"},   {'Я', "·-·"}
};
    return kMorse;
}

//FIX_ME: Не было проверки корректности ввода
bool is_valid_input(const std::string& input) {
    const auto& morse = get_morse_map();

    for (char ch : input) {

        if (ch == ' ')
            continue;

        unsigned char up = static_cast<unsigned char>(std::toupper(ch));

        if (up == 'Ё')
            up = 'Е';

        if (morse.find(up) == morse.end()) {
            return false;
        }
    }
    return true;
}

//FIX_ME: Google Style запрещает using namespace
// void process_morse(const string& text) {
void process_morse(const std::string& text) {
    //FIX_ME: Использовалась глобальная переменная morse
    const auto& morse = get_morse_map();

    std::string output;
    bool hasValidChars = false;

    //FIX_ME: Комментарии несодержательные
    /*for (char ch : text) {
        if (ch == ' ') {
            output += " ";  // пробел между словами
            continue;
        }
        // Приводим букву к верхнему регистру
        unsigned char upper = static_cast<unsigned char>(std::toupper(ch));
        */
    for (char ch : text) {
        if (ch == ' ') {
            output += " ";
            continue;
        }

        unsigned char upper = static_cast<unsigned char>(std::toupper(ch));

        auto it = morse.find(upper);
        if (it != morse.end()) {
            output += it->second;
            output += " ";
            hasValidChars = true;
        }
        else {
            output += "? ";
        }
    }

    if (!output.empty() && output.back() == ' ') {
        output.pop_back();
    }

    if (hasValidChars || !text.empty()) {
        std::cout << "\nАзбука Морзе:\n" << output << std::endl;
    }
    else {
        std::cout << "Не введено ни одного допустимого символа." << std::endl;
    }
}