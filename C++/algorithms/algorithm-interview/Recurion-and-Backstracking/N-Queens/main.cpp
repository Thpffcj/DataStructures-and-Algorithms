/**
 * Created by Thpffcj on 2017/9/25
 */

/**
 *The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and
 * an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Solution {
private:
    vector<bool> col, dia1, dia2;
    vector<vector<string>> res;

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    void putQueen(int n , int index, vector<int> &row){

        if ( index == n ) {
            res.push_back( generateBoard(n,row) );
            return;
        }

        for ( int i = 0; i < n; i++ ) {
            // 尝试将第index行的皇后摆放在第i列
            if ( !col[i] && !dia1[index+i] && !dia2[index-i+n-1] ) {
                row.push_back(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n, index+1, row);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
                row.pop_back();
            }
        }

        return;
    }

    vector<string> generateBoard( int n, vector<int> &row ){

        assert( row.size() == n );
        vector<string> board(n, string(n, '.'));
        for( int i = 0 ; i < n ; i ++ ) {
            board[i][row[i]] = 'Q';
        }

        return board;
    }
public:
    vector<vector<string>> solveNQueens(int n) {

        res.clear();

        col = vector<bool>(n, false);
        dia1 = vector<bool>(2*n-1, false);
        dia2 = vector<bool>(2*n-1, false);

        vector<int> row;
        putQueen(n, 0, row);

        return res;
    }
};

int main() {

    int n = 4;
    vector<vector<string>> res = Solution().solveNQueens(n);
    for( int i = 0 ; i < res.size() ; i ++ ){
        for( int j = 0 ; j < n ; j ++)
            cout<<res[i][j]<<endl;
        cout<<endl;
    }

    return 0;
}
