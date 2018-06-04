package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/6/1.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    /**
     * 由于加上了时间复杂度必须是O(n)，并且空间复杂度为O(1)，使得不能用排序方法，也不能使用map数据结构。那么只能另辟蹊径，
     * 需要用位操作Bit Operation来解此题
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
