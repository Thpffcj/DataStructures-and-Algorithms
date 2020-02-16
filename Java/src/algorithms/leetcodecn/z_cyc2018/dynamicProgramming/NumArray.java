package algorithms.leetcodecn.z_cyc2018.dynamicProgramming;

/**
 * Created by thpffcj on 2020/2/15.
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class NumArray {

    int[] dp;
    public NumArray(int[] nums) {

        dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = nums[i - 1] + dp[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i + 1];
    }
}
