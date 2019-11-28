package algorithms.advancedAlgorithm.homework.homework1;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 *
 * Input
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为数组，每一个数用空格隔开，第二行为num。
 *
 * Output
 * 输出一个值。
 *
 * Sample Input 1
 * 1
 * 3 6 4 3 2
 * 2
 *
 * Sample Output 1
 * 6
 */
public class RangeOfValuesOfSubArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String[] line = sc.nextLine().split(" ");
            int num = Integer.parseInt(sc.nextLine());
            int[] digit = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                digit[i] = Integer.parseInt(line[i]);
            }

            int max;
            int min;
            int result = 0;
            for (int i = 0; i < digit.length; i++) {
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for (int j = i; j < digit.length; j++) {
                    if (digit[j] > max) {
                        max = digit[j];
                    }
                    if (digit[j] < min) {
                        min = digit[j];
                    }
                    if ((max - min) > num) {
                        result++;
                    }
                }
            }
            System.out.println(result);

            numbers--;
        }
    }
}
