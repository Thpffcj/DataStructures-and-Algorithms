package algorithms.leetcodecn.z_cyc2018.binarySearch;

/**
 * Created by thpffcj on 2020/2/14.
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[h] > nums[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
