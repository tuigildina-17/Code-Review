/*Археолог нашел N артефактов.Известны веса(сi) и ценности(di) артефактов.Нужно
выбрать такое подмножество найденных вещей, чтобы суммарный их вес не превысил 
Z кг, а их общая ценность оказалась максимальной.Известно, что решение
единственно.Укажите порядковые номера вещей, которые нужно взять.Исходный
данные находятся в текстовом файле, в первой строке указаны N и Z, а во 
второй строке значения весов(в кг), в третьей - ценность находок.Вывести так
же суммарный вес и общую ценность результата.*/

#pragma once
# include <iostream>
# include <windows.h>
# include <vector>
# include <ctime>
# include <fstream>
# include <cmath>

//FIX_ME: Google Style запрещает использование using namespace std;
// using namespace std;

//FIX_ME: Строка длиннее 80 символов
//void find(const vector<vector<int>>& a, int k, int s, const vector<int>& w, double& weight);
void find(const std::vector<std::vector<int>>& a, int k, int s,
  const std::vector<int>& w, double& weight);
//FIX_ME: Отсутствие проверки на ввод
int read_positive_int(const std::string& prompt);