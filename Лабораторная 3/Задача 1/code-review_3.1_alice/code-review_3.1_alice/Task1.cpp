//#include <iostream>
//#include <unordered_map>
//#include <string>
//#include <cctype> // для функции std::toupper
//
//using namespace std;
//
//// Создаем ассоциативный массив для хранения символов и их соответствий в азбуке Морзе
//unordered_map<char, string> morseCode = {
//    {'А', "·-"}, {'Б', "-···"}, {'В', "·--"}, {'Г', "--·"},
//    {'Д', "-··"}, {'Е', "·"},   {'Ж', "···-"}, {'З', "--··"},
//    {'И', "··"},  {'Й', "·---"}, {'К', "-·-"}, {'Л', "·-··"},
//    {'М', "--"},  {'Н', "-·"},   {'О', "---"}, {'П', "·--·"},
//    {'Р', "·-·"}, {'С', "···"},  {'Т', "-"},  {'У', "··-"},
//    {'Ф', "··-·"}, {'Х', "····"}, {'Ц', "-·-·"}, {'Ч', "---·"},
//    {'Ш', "----"}, {'Щ', "--·-"}, {'Ъ', "·--·-·"}, {'Ы', "-·--"},
//    {'Ь', "-··-"}, {'Э', "··-··"}, {'Ю', "··--"}, {'Я', "·-·"},
//    {' ', " "}
//};
//
//string toMorseCode(const string& input) {
//    string output = "";
//    for (char ch : input) {
//        // Приводим символ к верхнему регистру
//        unsigned char up = static_cast<unsigned char>(std::toupper(ch));
//        // Ищем символ в азбуке Морзе и добавляем его к выходной строке
//            if (morse.find(static_cast<char>(up)) != morse.end()) {
//			  output += morse.at(static_cast<char>(up)) + " ";
//            }
//        }
//    }
//    return output;
//}
//
//int main() {
//    cout << "Введите сообщение для преобразования в азбуку Морзе: ";
//    string message;
//    getline(cin, message);
//
//    string morseMessage = toMorseCode(message);
//    cout << "Сообщение в азбуке Морзе: " << morseMessage << endl;
//
//    return 0;
//}