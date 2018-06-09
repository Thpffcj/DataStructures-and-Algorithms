package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/6/8.
 */

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }
            n = n /2;
        }
        return false;
    }
}
