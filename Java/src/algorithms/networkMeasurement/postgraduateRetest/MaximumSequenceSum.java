package algorithms.networkMeasurement.postgraduateRetest;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019-03-12.
 */

/**
 * 题目描述
 * 给出一个整数序列S，其中有N个数，定义其中一个非空连续子序列T中所有数的和为T的“序列和”。 对于S的所有非空连续子序列T，求最大的
 * 序列和。 变量条件：N为正整数，N≤1000000，结果序列和在范围（-2^63,2^63-1）以内。
 * 输入描述:
 * 第一行为一个正整数N，第二行为N个整数，表示序列中的数。
 * 输出描述:
 * 输入可能包括多组数据，对于每一组输入数据，
 * 仅输出一个数，表示最大序列和。
 *
 * 示例1
 * 输入
 * 5
 * 1 5 -3 2 4
 *
 * 6
 * 1 -2 3 4 -10 6
 *
 * 4
 * -3 -1 -2 -5
 *
 * 输出
 * 9
 * 7
 * -1
 */
public class MaximumSequenceSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] number = new int[n];
            for (int i = 0; i < n; i++) {
                number[i] = sc.nextInt();
            }
            int sum = 0;
            int max = number[0];
            for (int i = 0; i < n; i++) {
                sum += number[i];
                if (sum > max) {
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            System.out.println(max);
        }
    }
}
