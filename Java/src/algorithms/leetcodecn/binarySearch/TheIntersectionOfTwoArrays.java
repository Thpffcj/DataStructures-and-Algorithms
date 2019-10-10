package algorithms.leetcodecn.binarySearch;

/**
 * Created by thpffcj on 2019/10/9.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class TheIntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m];
        int pos = 0;
        for (int i = 0; i < m; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(nums2[i])) {
                set.remove(nums2[i]);
                result[pos] = nums2[i];
                pos++;
            }
        }
        return Arrays.copyOf(result, pos);
    }
}
