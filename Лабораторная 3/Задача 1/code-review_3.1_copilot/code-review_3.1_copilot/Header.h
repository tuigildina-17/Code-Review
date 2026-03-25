/* https://copilot.microsoft.com/shares/8ikJh2zvazGU9WWSNZUPf
Напишите программу-телеграф, которая принимает от пользователя сообщение 
и выводит его на экран в виде последовательности точек и тире.Азбука Морзе
для букв русского алфавита приведена ниже.*/

#pragma once
#include <string>
#include <map>
#include <iostream>
#include <cctype>
//FIX_ME: Не было кодировки ввода консоли для работы с русскими буквами
#include <windows.h>

//FIX_ME: Не было проверки корректности ввода
bool is_valid_input(const std::string& input);
void process_morse(const std::string& text);