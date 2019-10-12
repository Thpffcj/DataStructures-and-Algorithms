package algorithms.leetcodecn.array;

/**
 * Created by thpffcj on 2019/10/11.
 */

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不
 * 重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class TheSumOfTheThreeNumbers {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return results;
        }

        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        String s = "";

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                List<Integer> result = new ArrayList<>();
                if (nums[start] + nums[end] == target) {
                    s = "" + nums[i] + nums[start] + nums[end];
                    if (!set.contains(s)) {
                        set.add(s);
                        result.add(nums[i]);
                        result.add(nums[start]);
                        result.add(nums[end]);
                        results.add(result);
                    }
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return results;
    }
}
