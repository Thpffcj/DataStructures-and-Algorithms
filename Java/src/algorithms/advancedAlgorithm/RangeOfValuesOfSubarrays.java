package algorithms.advancedAlgorithm;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.Scanner;

/**
 * Description
 * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 * Input
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为数组，每一个数用空格隔开，第二行为num。
 * Output
 * 输出一个值。
 *
 * 1
 * 3 6 4 3 2
 * 2
 *
 * 6
 */
public class RangeOfValuesOfSubarrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String[] digit = sc.nextLine().split(" ");
            int num = Integer.parseInt(sc.nextLine());

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;

        }
    }
}
