package algorithms.advancedAlgorithm;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * 给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
 * Input
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为矩阵行数n和列数m，下面的n行每一行是用空格隔开的0或1。
 * Output
 * 输出一个数值。
 *
 * 1
 * 3 4
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 *
 * 6
 */
public class SubmatrixProblem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        }
    }
}
