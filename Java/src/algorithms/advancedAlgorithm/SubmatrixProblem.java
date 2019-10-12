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

    /**
     * 从第一行开始，一行一行向下扫描，记录每一列当前的1的个数（碰到0时候清零，可以理解为高度，记录其为h[i ]），然后计算每
     * 一列的符合该列高度的矩形有多宽（对第j列而言，宽度为r[j]-l[j]+1）最后遍历完所有行得到的最大面积就是答案。
     * @param args
     */
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

            int maxArea = 0;
            int cols = matrix[0].length;
            int[] leftLessMin = new int[cols];
            int[] rightLessMin = new int[cols];
            Arrays.fill(leftLessMin, -1); // 初始化为 -1，也就是最左边
            Arrays.fill(rightLessMin, cols); // 初始化为 cols，也就是最右边
            int[] heights = new int[cols];
            for (int row = 0; row < matrix.length; row++) {
                //更新所有高度
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == 1) {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                // 更新所有leftLessMin
                int boundary = -1; // 记录上次出现 0 的位置
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == 1) {
                        // 和上次出现 0 的位置比较
                        leftLessMin[col] = Math.max(leftLessMin[col], boundary);
                    } else {
                        //当前是 0 代表当前高度是 0，所以初始化为 -1，防止对下次循环的影响
                        leftLessMin[col] = -1;
                        //更新 0 的位置
                        boundary = col;
                    }
                }
                // 右边同理
                boundary = cols;
                for (int col = cols - 1; col >= 0; col--) {
                    if (matrix[row][col] == 1) {
                        rightLessMin[col] = Math.min(rightLessMin[col], boundary);
                    } else {
                        rightLessMin[col] = cols;
                        boundary = col;
                    }
                }

                // 更新所有面积
                for (int col = cols - 1; col >= 0; col--) {
                    int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                    maxArea = Math.max(area, maxArea);
                }

            }
            System.out.println(maxArea);
        }
    }
}
