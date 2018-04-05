package algorithms.networkMeasurement.pinduoduo;

/**
 * Created by Thpffcj on 2018/3/28.
 */

import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 输入描述:
 * 无序整数数组A[n]
 * 输出描述:
 * 满足条件的最大乘积
 *
 * 输入例子1:
 * 3 4 1 2
 * 输出例子1:
 * 24
 */
public class MaximumProduct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 输入和描述不一致
            int n = sc.nextInt();
            long[] number = new long[n];
            for (int i = 0; i < n ; i++) {
                number[i] = sc.nextLong();
            }
            long max1 = Integer.MIN_VALUE;
            long max2 = Integer.MIN_VALUE;
            long max3 = Integer.MIN_VALUE;
            long min1 = Integer.MAX_VALUE;
            long min2 = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (number[i] > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = number[i];
                } else if (number[i] > max2) {
                    max3 = max2;
                    max2 = number[i];
                } else if (number[i] > max3) {
                    max3 = number[i];
                }
                if (number[i] < min1) {
                    min2 = min1;
                    min1 = number[i];
                } else if (number[i] < min2) {
                    min2 = number[i];
                }
            }
            long res = Math.max(max1 * max2 * max3, max1 * min1 * min2);
            System.out.println(res);
        }
    }
}
