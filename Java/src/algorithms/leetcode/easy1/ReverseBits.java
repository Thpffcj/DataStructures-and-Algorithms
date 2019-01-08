package algorithms.leetcode.easy1;

/**
 * Created by Thpffcj on 2018/6/5.
 */

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 *              return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {

    /**
     * 对于这道题，我们只需要把要翻转的数从右向左一位位的取出来，如果取出来的是1，我们将结果res左移一位并且加上1。
     * 如果取出来的是0，我们将结果res左移一位，然后将n右移一位即可
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result = (result << 1) + 1;
            } else {
                result = result << 1;
            }
            n = n >> 1;
        }
        return result;
    }
}
