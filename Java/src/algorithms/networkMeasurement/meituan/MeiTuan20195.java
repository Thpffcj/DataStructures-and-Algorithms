package algorithms.networkMeasurement.meituan;

import java.util.Scanner;
import java.io.*;

/**
 * Created by thpffcj on 2020/2/12.
 *
 * 小明同学在参加一场考试，考试时间2个小时。试卷上一共有n道题目，小明要在规定时间内，完成一定数量的题目。
 * 考试中不限制试题作答顺序，对于 i 第道题目，小明有三种不同的策略可以选择:  (1)直接跳过这道题目，不花费时间，本题得0分。
 * (2)只做一部分题目，花费pi分钟的时间，本题可以得到ai分。  (3)做完整个题目，花费qi分钟的时间，本题可以得到bi分。
 * 小明想知道，他最多能得到多少分。
 *
 * 输入描述:
 * 第一行输入一个n数表示题目的数量。
 * 接下来n行，每行四个数p_i，a_i，q_i，b_i。(1≤n≤100，1≤p_i≤q_i≤120，0≤a_i≤b_i≤1000)。
 *
 * 输出描述:
 * 输出一个数，小明的最高得分。
 *
 * 输入例子1:
 * 4
 * 20 20 100 60
 * 50 30 80 55
 * 100 60 110 88
 * 5 3 10 6
 *
 * 输出例子1:
 * 94
 */
public class MeiTuan20195 {

    // 背包问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time1 = new int[n + 1];
        int[] time2 = new int[n + 1];
        int[] grade1 = new int[n + 1];
        int[] grade2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time1[i] = sc.nextInt();
            grade1[i] = sc.nextInt();
            time2[i] = sc.nextInt();
            grade2[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][121];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 120; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= time1[i]) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i - 1][j - time1[i]] + grade1[i]));
                }
                if (j >= time2[i]) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i - 1][j - time2[i]] + grade2[i]));
                }
            }
        }

        System.out.println(dp[n][120]);
    }
}
