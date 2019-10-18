package algorithms.leetcodecn.math;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class NumberOfTracts {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int current = x;
        int y = 0;
        int remainder = 0;
        while (current != 0) {
            remainder = current % 10;
            current = current / 10;
            y = y * 10 + remainder;
        }
        if (x == y) {
            return true;
        }
        return false;
    }
}
