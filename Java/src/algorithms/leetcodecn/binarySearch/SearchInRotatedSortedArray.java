package algorithms.leetcodecn.binarySearch;

/**
 * Created by thpffcj on 2020/1/31.
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {

        int index;
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[left]) {
            if (nums[left] <= target && target < nums[mid]) {
                index = binarySearch(nums, left, mid - 1, target);
            } else {
                index = binarySearch(nums, mid + 1, right, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                index = binarySearch(nums, mid + 1, right, target);
            } else {
                index = binarySearch(nums, left, mid - 1, target);
            }
        }

        return index;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                // target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = new int[]{3, 1};
        System.out.println(s.search(nums, 1));
    }
}
