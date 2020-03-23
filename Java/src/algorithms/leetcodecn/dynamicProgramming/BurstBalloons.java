package algorithms.leetcodecn.dynamicProgramming;

/**
 * Created by thpffcj on 2020/2/5.
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 
 * right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {

    /**
     * dp[i][j]代表扎破i+1号气球～j-1号气球能获得的金币数，i和j是不能被扎破的，因为是两端，并且当前气球k不能被扎破，要分别考
     * 虑k的左侧（i～k-1）和右侧（k+1～j），
     *
     * 状态转移方程为：
     * dp[i][j] = max{dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]},k∈(i,j)
     * dp[i][k]代表扎破i+1～k-1号气球，dp[k][j]代表扎破k+1～j-1号气球，再加上扎破这个气球获得的金币数
     *
     * 初始条件：没有气球要扎破就获得0个金币
     * dp[0][1] = dp[1][2] = ... = dp[n-2][n-1] = 0
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 生成新数组
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            A[i + 1] = nums[i];
        }
        n += 2;

        int[][] dp = new int[n][n];

        // 初始化
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0;
        }

        // 区间型dp标准格式
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MIN_VALUE;
                // 枚举中间的气球
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
