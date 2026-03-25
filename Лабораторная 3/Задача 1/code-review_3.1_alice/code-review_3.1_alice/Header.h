/*https://alice.yandex.ru/chat/019d202d-6c44-464b-9bf8-aa3f02bba991/?utm_campaign=ntp_new_chat_btn&utm_source=desktop_browser
Напишите программу - телеграф, которая принимает от пользователя сообщение и
выводит его на экран в виде последовательности точек и тире.Азбука Морзе для
букв русского алфавита приведена ниже.*/

#pragma once
#include <iostream>
#include <unordered_map>
#include <string>
//FIX_ME: Несодержательный комментарий
//#include <cctype> // для функции std::toupper
#include <cctype>
#include <windows.h>

//FIX_ME: Google Style запрещает использование using namespace std;
// using namespace std;

//FIX_ME: Название функции нарушало стиль
//string toMorseCode(const string& input);
std::string to_morse_code(const std::string& input);
//FIX_ME: Не было проверки корректности ввода
bool is_valid_input(const std::string& input);