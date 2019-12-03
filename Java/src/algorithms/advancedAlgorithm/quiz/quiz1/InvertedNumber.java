package algorithms.advancedAlgorithm.quiz.quiz1;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/26.
 */

/**
 * Description
 * 有一个由N个实数构成的数组，如果一对元素A[i]和A[j]是倒序的，即i<j但是A[i]>A[j]则称它们是一个倒置，设计一个计算该数组中所有倒置数量
 * 的算法。要求算法复杂度为O(nlogn)
 *
 * Input
 * 输入有多行，第一行整数T表示为测试用例个数，后面是T个测试用例，每一个用例包括两行，第一行的一个整数是元素个数，第二行为用空格隔开的
 * 数组值。
 *
 * Output
 * 输出每一个用例的倒置个数，一行表示一个用例。
 *
 * Sample Input 1
 * 1
 * 8
 * 8 3 2 9 7 1 5 4
 *
 * Sample Output 1
 * 17
 */
public class InvertedNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int j = 0; j < n; j++) {
                digit[j] = sc.nextInt();
            }

            find(digit);

            numbers--;
        }
    }

    public static void find(int[] digit) {
        int num = 0;
        for (int i = 0; i < digit.length - 1; i++) {
            for (int j = i + 1; j < digit.length; j++) {
                if (digit[j] < digit[i]) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
