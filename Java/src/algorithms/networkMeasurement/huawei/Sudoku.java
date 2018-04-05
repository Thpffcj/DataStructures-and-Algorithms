package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/3/16.
 */

import java.util.Scanner;

/**
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 *
 * 输入描述:
 * 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 *
 * 输出描述:
 * 输出九行，每行九个空格隔开的数字，为解出的答案。
 */
public class Sudoku {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            solve(board);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.print(board[i][8]);
                System.out.println();
            }
        }
    }

    public static boolean solve(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != 0 && board[i][col] == num) {
                return false;
            }
            if (board[row][i] != 0 && board[row][i] == num) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != 0
                    && board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
