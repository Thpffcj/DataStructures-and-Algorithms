package algorithms.leetcodecn.math;

/**
 * Created by thpffcj on 2019/10/12.
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么
 * 就返回 0。

 */
public class IntegerInversion {

    public int reverse(int x) {

        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }

        int remainder = 0;
        int result = 0;
        while (x != 0) {
            remainder = x % 10;
            x = x / 10;
            if (result > (Integer.MAX_VALUE - remainder) / 10.0) {
                return 0;
            }
            result = result * 10 + remainder;
        }
        if (negative) {
            result = -result;
        }
        return result;
    }
}

// 1534236469