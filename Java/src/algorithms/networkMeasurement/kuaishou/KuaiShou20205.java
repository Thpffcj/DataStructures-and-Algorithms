package algorithms.networkMeasurement.kuaishou;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/19.
 *
 * 给定一个数组，每个元素范围是0~K（K < 整数最大值2^32），将该数组分成两部分，使得 |S1- S2|最小，其中S1和S2分别是数组两部分
 * 的元素之和。
 *
 * 输入描述:
 * 数组元素个数N（N 大于1但不超过 10, 000, 000）
 * 数组中N个元素（用空格分割）
 *
 * 输出描述:
 * |S1- S2|的值
 *
 * 输入例子1:
 * 5
 * 2 4 5 6 9
 *
 * 输出例子1:
 * 0
 *
 * 输入例子2:
 * 4
 * 1 1 1 999
 *
 * 输出例子2:
 * 996
 */
public class KuaiShou20205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] digit = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            digit[i] = sc.nextInt();
            sum += digit[i];
        }
        int target = sum / 2;

        int[][] dp = new int[N + 1][target + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                if (digit[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 使得sum<=SUM/2的条件下尽可能的大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - digit[i - 1]] + digit[i - 1]);
                }
            }
        }
        int result = Math.abs(sum - dp[N][target] * 2);
        System.out.println(result);
    }
}
