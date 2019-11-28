package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.Scanner;

/**
 * Description A班
 * Given an array, the task is to complete the function which finds the maximum sum subarray, where you
 * may remove at most one element to get the maximum sum.
 *
 * Input
 * 第一行为测试用例个数T；后面每两行表示一个用例，第一行为用例中数组长度N，第二行为数组具体内容。
 *
 * Output
 * 每一行表示对应用例的结果。
 *
 * Sample Input 1
 * 1
 * 5
 * 1 2 3 -4 5
 *
 * Sample Output 1
 * 11
 */
public class BatchQuery {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = sc.nextInt();
            }

            maxSum(digit);

            numbers--;
        }
    }

    public static void maxSum(int[] digit) {
        int n = digit.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = digit[0];
        g[0] = 0;

        int res = f[0];
        for (int i = 1; i < n ; i++) {
            f[i] = Math.max(f[i - 1] + digit[i], digit[i]);
            // 选f[i - 1]说明跳过i
            g[i] = Math.max(g[i - 1] + digit[i], f[i - 1]);
            res = Math.max(res, Math.max(f[i], g[i]));
        }

        System.out.println(res);
    }

//    public static void maxSum(int[] arr) {
//        int ans = arr[0];
//        int len = arr.length;
//        int[][] dp = new int[len][2];
//        // 初始化状态
//        // "尚未删除"，最大子数组和为本身
//        dp[0][0] = arr[0];
//        // "已经删除"，只能删除自身，最大子数组和为 0
//        dp[0][1] = 0;
//        for (int i = 1; i < len; i++) {
//            // 如果前一个子数组和大于 0，则加上
//            dp[i][0] = Math.max(arr[i], arr[i] + dp[i - 1][0]);
//            // 删除的字符的两种情况：
//            // 1. 当前数字被删除，为了满足至少一个元素，必须加上前面一个子数组 "尚未删除" 的最大值
//            // 2. 当前数字不被删除，则由前面子数组删除，前面子数组 "已经删除" 的最大值加上当前数字
//            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
//            // 两种状态都可能产生最大值
//            ans = Math.max(ans, dp[i][0]);
//            ans = Math.max(ans, dp[i][1]);
//        }
//        System.out.println(ans);
//    }
}
