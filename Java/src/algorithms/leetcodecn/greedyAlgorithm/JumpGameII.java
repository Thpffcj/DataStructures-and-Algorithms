package algorithms.leetcodecn.greedyAlgorithm;

import java.util.Arrays;

/**
 * Created by thpffcj on 2020/1/27.
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 */
public class JumpGameII {

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 100000);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < dp.length) {
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }

        return dp[dp.length - 1];
    }

    public int jump2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end) { // 遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int jump3(int[] nums) {
        int position = nums.length - 1; // 要找的位置
        int steps = 0;
        while (position != 0) { // 是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; // 更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        int[] nums = new int[]{2,3,1,1,4};
        j.jump(nums);
    }
}
