package algorithms.leetcodecn.heap;

/**
 * Created by thpffcj on 2020/1/15.
 *
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if(dp[i] == dp[i2] * 2) {
                i2++;
            }
            if(dp[i] == dp[i3] * 3) {
                i3++;
            }
            if(dp[i] == dp[i5] * 5) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
