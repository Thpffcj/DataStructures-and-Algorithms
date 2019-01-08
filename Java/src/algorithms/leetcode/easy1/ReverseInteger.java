package algorithms.leetcode.easy1;

/**
 * Created by Thpffcj on 2018/5/25.
 */

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x <= Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(Math.abs(x));
        stringBuffer.append(Math.abs(x));
        stringBuffer.reverse();
        long result = Long.parseLong(stringBuffer.toString()) * (x / Math.abs(x));
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(-2147483648);
        System.out.println(result);
    }
}
