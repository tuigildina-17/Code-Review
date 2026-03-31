#include "Header.h"

/*FIX_ME:
* 1. Названия функций не соответствуют стилю
* 2. Открывающиеся скобки на отдельной строке
* 3. Использование using namespace std;
*/
//bool NoThreeZeros(const string& num)
bool no_three_zeros(const std::string& num) {
    int count = 0;
    for (char ch : num) {
        if (ch == '0') {
            count++;
            if (count > 3)
                return false;
        }
        else
            count = 0;
    }
    return true;
}

//double CountValidNumbers(int k, int n) 
double count_valid_numbers(int k, int n) {
    double total = 0;

    for (int i = pow(k, n - 1); i < pow(k, n); i++) {
        //string num = "";
        std::string num = "";
        int temp = i;

        if (k != 10) {
            for (int j = 0; j < n; j++) {
                //num = to_string(temp % k) + num;
                num = std::to_string(temp % k) + num;
                temp /= k;
            }
        }

        //if (num[0] != '0' && NoThreeZeros(num))
        if (num[0] != '0' && no_three_zeros(num)) {
            total++;
        }
    }

    return total;
}