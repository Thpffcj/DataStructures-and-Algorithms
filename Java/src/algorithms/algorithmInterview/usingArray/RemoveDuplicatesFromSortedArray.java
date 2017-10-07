package algorithms.algorithmInterview.usingArray;

/**
 * Created by Thpffcj on 2017/9/23.
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't
 * matter what you leave beyond the new length.
 */

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for ( int j = 1; j < nums.length; j++) {
            if ( nums[j] != nums[i] ) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray  = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,1,1,2,2};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
    }
}
