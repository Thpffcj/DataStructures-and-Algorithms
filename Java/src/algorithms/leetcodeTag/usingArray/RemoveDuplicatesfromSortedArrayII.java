package algorithms.leetcodeTag.usingArray;

/**
 * Created by Thpffcj on 2017/11/20.
 */


/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end;
        int times = 1;
        for (end = 1; end < nums.length; end++) {
            if (nums[start] == nums[end]) {
                if (times < 2) {
                    start++;
                    times++;
                    nums[start] = nums[end];
                }
            } else {
                times = 1;
                start++;
                nums[start] = nums[end];
            }
        }
        return start + 1;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII removeDuplicatesfromSortedArrayII = new RemoveDuplicatesfromSortedArrayII();
        int[] nums = {1,1,1,1,2,2};
        System.out.println(removeDuplicatesfromSortedArrayII.removeDuplicates2(nums));
    }
}
