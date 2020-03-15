package algorithms.leetcodecn.z_hot;

import java.util.ArrayDeque;

/**
 * Created by thpffcj on 2020/2/28.
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向
 * 右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 */
public class SlidingWindowMaximum {

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        this.nums = nums;
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            if (i - k + 1 >= 0) {
                output[i - k + 1] = nums[deq.getFirst()];
            }
        }

        return output;
    }

    public void clean_deque(int i, int k) {
        // 从滑动窗口中删除元素的索引
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // 从deq索引中删除所有小于当前元素nums [i]的元素
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }
        return result;
    }
}
