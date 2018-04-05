package algorithms.algorithmInterview.usingHashTable;

/**
 * Created by Thpffcj on 2018/3/20.
 */

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 * target. Return the sum of the three integers. You may assume that each input would have exactly one
 * solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            int t = target - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == t) {
                    return target;
                } else if (nums[l] + nums[r] < t) {
                    if (t - nums[l] - nums[r] < min) {
                        res = nums[i] + nums[l] + nums[r];
                        min = t - nums[l] - nums[r];
                    }
                    l++;
                } else {
                    if (nums[l] + nums[r] - t < min) {
                        res = nums[i] + nums[l] + nums[r];
                        min = nums[l] + nums[r] - t;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
