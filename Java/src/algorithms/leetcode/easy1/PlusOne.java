package algorithms.leetcode.easy1;

/**
 * Created by Thpffcj on 2018/5/29.
 */

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in
 * the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int result[] = new int[digits.length];
        int carry = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            int digit = digits[i] + carry;
            if (digit == 10) {
                result[i] = 0;
                carry = 1;
            } else {
                result[i] = digit;
                carry = 0;
            }
        }
        if (carry == 1) {
            int newResult[] = new int[result.length + 1];
            for (int j = 1; j < newResult.length; j++) {
                newResult[j] = result[j - 1];
            }
            newResult[0] = 1;
            return newResult;
        }
        return result;
    }
}
