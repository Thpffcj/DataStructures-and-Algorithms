package algorithms.leetcodecn.binarySearch;

/**
 * Created by thpffcj on 2019/12/29.
 */

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length + nums2.length;
        int[] digit = new int[n];
        for (int i = 0; i < nums1.length; i++) {
            digit[i] = nums1[i];
        }
        for (int i = nums1.length; i < n; i++) {
            digit[i] = nums2[i - nums1.length];
        }
        Arrays.sort(digit);

        if (n % 2 == 0) {
            return (digit[n / 2 - 1] + digit[n / 2]) / 2.0;
        } else {
            return digit[n / 2];
        }
    }
}
