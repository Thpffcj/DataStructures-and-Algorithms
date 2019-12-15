package algorithms.leetcodeTag.usingArray;

/**
 * Created by Thpffcj on 2018/3/12.
 */

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted
 * order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            p.add(nums[i]);
            if (p.size() > k) {
                p.poll();
            }
        }
        return p.poll();
    }

    /**
     * 跟快速排序一个思路。先取一个枢纽值，将数组中小于枢纽值的放在左边，大于枢纽值的放在右边，具体方法是用左右两个指针，
     * 如果他们小于枢纽值则将他们换到对面，一轮过后记得将枢纽值赋回分界点。如果这个分界点是k，说明分界点的数就是第k个数。
     * 否则，如果分界点大于k，则在左半边做同样的搜索。如果分界点小于k，则在右半边做同样的搜索。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    private int quickSelect(int[] arr, int k, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int orgL = left;
        int orgR = right;
        while (left <= right) {
            // 从右向左找到第一个小于枢纽值的数
            while (arr[left] > pivot) {
                left++;
            }
            // 从左向右找到第一个大于枢纽值的数
            while (arr[right] < pivot) {
                right--;
            }
            // 将两个数互换
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        // 最后退出的情况应该是右指针在左指针左边一格
        // 这时如果右指针还大于等于k，说明kth在左半边
        if (orgL < right && k <= right) {
            return quickSelect(arr, k, orgL, right);
        }
        // 这时如果左指针还小于等于k，说明kth在右半边
        if (left < orgR && k >= left) {
            return quickSelect(arr, k, left, orgR);
        }
        return arr[k];
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1] + arr[idx2];
        arr[idx1] = tmp - arr[idx1];
        arr[idx2] = tmp - arr[idx2];
    }
}
