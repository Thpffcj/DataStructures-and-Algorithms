package algorithms.leetcodecn.weekly.oneHundredAndSixtyEight;

/**
 * Created by thpffcj on 2019/12/22.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 *
 * 示例 3：
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 *
 * 示例 4：
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    // 超时
    public boolean isPossibleDivide(int[] nums, int k) {

        if (nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        while (!list.isEmpty()) {
            int digit = list.get(0);
            list.remove(0);
            int position = 0;

            for (int i = 0; i < k - 1; i++) {
                while (position < list.size() && list.get(position) != digit + 1) {
                    position++;
                }

                if (position >= list.size()) {
                    return false;
                }

                digit += 1;
                list.remove(position);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers d = new DivideArrayInSetsOfKConsecutiveNumbers();
        int[] nums = new int[]{1,2,3,3,4,4,5,6};
        d.isPossibleDivide(nums, 4);
    }
}
