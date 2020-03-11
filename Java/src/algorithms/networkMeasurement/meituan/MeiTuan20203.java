package algorithms.networkMeasurement.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/8.
 *
 * 有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，成本为这两堆金币块数之和。经过N-1
 * 次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。
 * 其中，1 <= N <= 30，1 <= C[i] <= 100
 *
 * 输入描述:
 * 第一行输入一个数字 N 表示有 N 堆金币
 * 第二行输入 N 个数字表示每堆金币的数量 C[i]
 *
 * 输出描述:
 * 输出一个数字 S 表示最小的合并成一堆的成本
 *
 * 输入例子1:
 * 4
 * 3 2 4 1
 * 输出例子1:
 * 20
 *
 * 输入例子2:
 * 30
 * 10 20 30 40 50 60 70 80 90 100 99 89 79 69 59 49 39 29 19 9 2 12 22 32 42 52 62 72 82 92
 * 输出例子2:
 * 7307
 */
public class MeiTuan20203 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] dp = new int[n][n];

        // 初始化
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0;
        }

        // 区间型dp标准格式
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // 枚举中间的气球
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
