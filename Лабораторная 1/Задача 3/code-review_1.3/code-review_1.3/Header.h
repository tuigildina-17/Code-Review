/*  - ичные числа.—реди чисел в системе счислени€ с основанием K(2<=K<=10)
определить сколько имеетс€ чисел из N(1 < N < 20, N + K < 26) разр€дов 
таких, что в их записи не содержитс€ более трех подр€д идущих нулей.ƒл€ того,
чтобы избежать переполнени€, ответ представьте в виде вещественного числа.*/

#pragma once
#include <iostream>
#include <cmath>
#include <string>
#include <Windows.h>
//FIX_ME: Google Style запрещает использование using namespace std;
// using namespace std;

//FIX_ME: »мена функции не соответствует стилю
//bool NoThreeZeros(const string& num);
bool no_three_zeros(const std::string& num);
//FIX_ME: ѕодсчет количества чисел находилс€ в main
double count_valid_numbers(int k, int n);