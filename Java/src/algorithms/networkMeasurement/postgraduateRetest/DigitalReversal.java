package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-14.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 12翻一下是21,34翻一下是43,12+34是46,46翻一下是64，现在又任意两个正整数，问他们两个数反转的和是否等于两个数的和的反转。
 * 输入描述:
 * 每行两个正整数a和b（0<a,b<=10000）。
 * 输出描述:
 * 如果满足题目的要求输出a+b的值，否则输出NO。
 *
 * 示例1
 * 输入
 * 12 34
 * 99 1
 * 输出
 * 46
 * NO
 */
public class DigitalReversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a + b;
            int c = Integer.parseInt(new StringBuffer(String.valueOf(a)).reverse().toString());
            int d = Integer.parseInt(new StringBuffer(String.valueOf(b)).reverse().toString());
            int reverseResult = Integer.parseInt(new StringBuffer(String.valueOf(c + d)).reverse().toString());
            if (result == reverseResult) {
                System.out.println(result);
            } else {
                System.out.println("NO");
            }
        }
    }
}
