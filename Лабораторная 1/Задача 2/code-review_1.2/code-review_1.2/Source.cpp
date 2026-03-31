#include "Header.h"

/*FIX_ME:
* 1. Строки длиннее 80 символов
* 2. Названия переменных не соответствуют стилю
* */
//void Solve(const vector<vector<int>>& board,vector<vector<int>>& board2, int n)
void solve(const std::vector<std::vector<int>>& board, 
    std::vector<std::vector<int>>& board_opt, int n)
{
    int i, j;
    //board2[n - 1][n - 1] = board[n - 1][n - 1];
    board_opt[n - 1][n - 1] = board[n - 1][n - 1];

    for (i = n - 2; i >= 0; i--) {
        //board2[i][n - 1] = board2[i + 1][n - 1] + board[i][n - 1];
        board_opt[i][n - 1] = board_opt[i + 1][n - 1] + board[i][n - 1];
    }

    for (j = n - 2; j >= 0; j--) {
        //board2[n - 1][j] = board2[n - 1][j + 1] + board[n - 1][j];
        board_opt[n - 1][j] = board_opt[n - 1][j + 1] + board[n - 1][j];
    }

    for (i = n - 2; i >= 0; i--) {
        for (j = n - 2; j >= 0; j--) {
            /*if (board2[i + 1][j] > board2[i][j + 1]) 
            {
                board2[i][j] = board2[i + 1][j] + board[i][j];
            }
            else 
            {
                board2[i][j] = board2[i][j + 1] + board[i][j];
            }*/
            if (board_opt[i + 1][j] > board_opt[i][j + 1]) {
                board_opt[i][j] = board_opt[i + 1][j] + board[i][j];
            }
            else {
                board_opt[i][j] = board_opt[i][j + 1] + board[i][j];
            }
        }
    }
}

//string Path(const vector<vector<int>>& board2, int n)
std::string path(const std::vector<std::vector<int>>& board_opt, int n)
{
    //FIX_ME: Непонятное название переменной
    //string s = "";
    std::string path = "";
    int i = 0, j = 0;

    while (i < n - 1 || j < n - 1) {
        if (i < n - 1 && j < n - 1) {
            //if (board2[i + 1][j] > board2[i][j + 1]) 
            if (board_opt[i + 1][j] > board_opt[i][j + 1]) {
                //FIX_ME: Для символов должны использоваться одинарные кавычки
                //s += "U";
                path += 'U';
                i++;
            }
            else {
                //s += "L";
                path += 'L';
                j++;
            }
        }
        else if (i < n - 1) {
            //s += "U";
            path += 'U';
            i++;
        }
        else {
            //s += "L";
            path += 'L';
            j++;
        }
    }

    //reverse(s.begin(), s.end());
    reverse(path.begin(), path.end());
    //return s;
    return path;
}
