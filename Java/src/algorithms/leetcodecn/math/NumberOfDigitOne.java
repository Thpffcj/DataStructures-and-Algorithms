package algorithms.leetcodecn.math;

/**
 * Created by thpffcj on 2020/1/20.
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例:
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
public class NumberOfDigitOne {

    public int countDigitOne(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        int high = Integer.parseInt(String.valueOf(n).substring(0, 1));
        int last = Integer.parseInt(String.valueOf(n).substring(1));
        int power = (int) Math.pow(10, String.valueOf(n).length() - 1);

        if (high == 1) {
            return countDigitOne(last) + countDigitOne(power - 1) + last + 1;
        } else {
            return power + high * countDigitOne(power - 1) + countDigitOne(last);
        }
    }
}
