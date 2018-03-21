package algorithms.algorithmInterview.dynamicProgramming;

/**
 * Created by Thpffcj on 2018/3/20.
 */

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {

    // TODO 还有很多其他解法
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
