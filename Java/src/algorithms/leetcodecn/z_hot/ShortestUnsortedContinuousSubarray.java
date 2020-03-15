package algorithms.leetcodecn.z_hot;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by thpffcj on 2020/3/2.
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        int[] digit = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            digit[i] = nums[i];
        }
        Arrays.sort(digit);

        int start = 0;
        int end = nums.length - 1;
        while (start < nums.length && digit[start] == nums[start]) {
            start++;
        }
        while (end >= 0 && digit[end] == nums[end]) {
            end--;
        }
        if (end < start) {
            return 0;
        }
        return end - start + 1;
    }

    /**
     * 为了达到这一目的，此方法中，我们使用 栈栈 。我们从头遍历 numsnums 数组，如果遇到的数字大小一直是升序的，我们就不断把
     * 对应的下标压入栈中，这么做的目的是因为这些元素在目前都是处于正确的位置上。一旦我们遇到前面的数比后面的数大，也就是
     * nums[j]nums[j] 比栈顶元素小，我们可以知道 nums[j]nums[j] 一定不在正确的位置上。
     */
    public int findUnsortedSubarray2(int[] nums) {
        Stack < Integer > stack = new Stack< Integer >();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

}
