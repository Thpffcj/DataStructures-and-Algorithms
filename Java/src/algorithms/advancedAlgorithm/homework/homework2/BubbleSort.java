package algorithms.advancedAlgorithm.homework.homework2;

/**
 * Created by thpffcj on 2019/10/26.
 */

import java.util.Scanner;

/**
 * Description
 * 实现冒泡排序。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 *
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */
public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] digits = new int[number];
        for (int i = 0; i < number; i++) {
            digits[i] = sc.nextInt();
        }

        for (int i = digits.length - 1; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                if (digits[j] < digits[j - 1]) {
                    int temp = digits[j];
                    digits[j] = digits[j - 1];
                    digits[j - 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1).toString());
    }


//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        int[] digits = new int[number];
//        for (int i = 0; i < number; i++) {
//            digits[i] = sc.nextInt();
//        }
//    }
}
