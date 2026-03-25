#include "Header.h"

/*FIX_ME:
* 1. Глобальные переменные запрещены Google Style
* 2. Имя morseCode нарушало стиль констант
* 3. Комментарий несодержательный
*/
/*// Создаем ассоциативный массив для хранения символов и их соответствий в азбуке Морзе
unordered_map<char, string> morseCode = {
*/
static const std::unordered_map<char, std::string>& get_morse_map() {
    static const std::unordered_map<char, std::string> kMorseCode = {
    {'А', "·-"}, {'Б', "-···"}, {'В', "·--"}, {'Г', "--·"},
    {'Д', "-··"}, {'Е', "·"},   {'Ж', "···-"}, {'З', "--··"},
    {'И', "··"},  {'Й', "·---"}, {'К', "-·-"}, {'Л', "·-··"},
    {'М', "--"},  {'Н', "-·"},   {'О', "---"}, {'П', "·--·"},
    {'Р', "·-·"}, {'С', "···"},  {'Т', "-"},  {'У', "··-"},
    {'Ф', "··-·"}, {'Х', "····"}, {'Ц', "-·-·"}, {'Ч', "---·"},
    {'Ш', "----"}, {'Щ', "--·-"}, {'Ъ', "·--·-·"}, {'Ы', "-·--"},
    {'Ь', "-··-"}, {'Э', "··-··"}, {'Ю', "··--"}, {'Я', "·-·"},
    {' ', " "}
};
    return kMorseCode;
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

        if (morse.find(static_cast<char>(up)) == morse.end()) {
            return false;
        }
    }
    return true;
}

//FIX_ME: Название функции нарушало стиль
// string toMorseCode(const string& input) {
std::string to_morse_code(const std::string& input) {
    ////FIX_ME: Использовалась глобальная переменная morse
    const auto& morse = get_morse_map();
    std::string output = "";
    for (char ch : input) {
        //FIX_ME: Несодержательные комментарии
        /*// Приводим символ к верхнему регистру
        unsigned char up = static_cast<unsigned char>(std::toupper(ch));
        // Ищем символ в азбуке Морзе и добавляем его к выходной строке
        if (morseCode.find(ch) != morseCode.end()) {
            output += morseCode[ch] + " ";
        }*/
        unsigned char up = static_cast<unsigned char>(std::toupper(ch));
        if (morse.find(static_cast<char>(up)) != morse.end()) {
            output += morse.at(static_cast<char>(up)) + " ";
        }

    }
    return output;
}