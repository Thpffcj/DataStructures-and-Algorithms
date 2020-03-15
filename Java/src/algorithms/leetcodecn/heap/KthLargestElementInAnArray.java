package algorithms.leetcodecn.heap;

import java.util.PriorityQueue;

/**
 * Created by thpffcj on 2019/11/13.
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

        return -1;
    }

    private int partition(int[] nums, int l, int h) {
        int v = nums[l];
        int i = l + 1;
        int j = h;
        while (i <= j) {
            while (nums[i] <= v && i != h) {
                i++;
            }
            while (v < nums[j] && j != l) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int findKthLargest3(int[] nums, int k) {

        int[] digits = new int[nums.length + 1];
        digits[0] = -1;
        for (int i = 0 ; i < nums.length; i++) {
            digits[i + 1] = nums[i];
        }

        // 构建堆
        int n = digits.length - 1;
        for (int i = n / 2; i >= 1; i--) {
            sink(digits, i, n);
        }

        // 找到第K大元素
        for (int i = 0; i < k - 1; i++) {
            int temp = digits[1];
            digits[1] = digits[n];
            digits[n] = temp;
            n--;
            sink(digits, 1, n);
        }
        return digits[1];
    }

    public void sink(int[] digits, int k, int n) {
        while (2 * k <= n) {
            int max = 2 * k;
            if (2 * k + 1 <= n) {
                if (digits[2 * k] < digits[2 * k + 1]) {
                    max = 2 * k + 1;
                }
            }
            if (digits[k] < digits[max]) {
                int temp = digits[k];
                digits[k] = digits[max];
                digits[max] = temp;
            }
            k = max;
        }
    }
}
