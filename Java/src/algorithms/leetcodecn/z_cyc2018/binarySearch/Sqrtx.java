package algorithms.leetcodecn.z_cyc2018.binarySearch;

/**
 * Created by thpffcj on 2020/2/14.
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrtx {

    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long num = mid * mid;
            if (num == x) {
                return (int) mid;
            } else if (num < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        Sqrtx s = new Sqrtx();
        System.out.println(s.mySqrt(8));
    }
}
