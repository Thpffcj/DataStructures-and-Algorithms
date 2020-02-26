package algorithms.leetcodecn.z_hot;

/**
 * Created by thpffcj on 2020/2/26.
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        int[] max = new int[n + 1];
        int[] min = new int[n + 1];
        max[0] = min[0] = 1;
        int result = nums[0];
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) {
                max[i] = Math.max(nums[i - 1], max[i - 1] * nums[i - 1]);
                min[i] = Math.min(nums[i - 1], min[i - 1] * nums[i - 1]);
            } else {
                max[i] = Math.max(nums[i - 1], min[i - 1] * nums[i - 1]);
                min[i] = Math.min(nums[i - 1], max[i - 1] * nums[i - 1]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}
