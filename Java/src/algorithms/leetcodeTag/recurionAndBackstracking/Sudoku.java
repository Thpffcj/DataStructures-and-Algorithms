package algorithms.leetcodeTag.recurionAndBackstracking;

/**
 * Created by Thpffcj on 2018/3/17.
 */
public class Sudoku {

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == num) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == num) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
