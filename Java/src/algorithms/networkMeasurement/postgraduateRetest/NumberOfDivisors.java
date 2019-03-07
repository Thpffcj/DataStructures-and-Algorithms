package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-05.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 输入n个整数,依次输出每个数的约数的个数
 *
 * 输入描述:
 * 输入的第一行为N，即数组的个数(N<=1000)
 * 接下来的1行包括N个整数，其中每个数的范围为(1<=Num<=1000000000)
 * 当N=0时输入结束。
 *
 * 输出描述:
 * 可能有多组输入数据，对于每组输入数据，
 * 输出N行，其中每一行对应上面的一个数的约数的个数。
 *
 * 示例1
 * 输入
 * 5
 * 1 3 4 6 12
 *
 * 输出
 * 1
 * 2
 * 3
 * 4
 * 6
 */
public class NumberOfDivisors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int digit = sc.nextInt();
                int result = getDivisorsNumber(digit);
                System.out.println(result);
            }
        }
    }

    private static int getDivisorsNumber(int digit) {
        int result = 0;
        for (int i = 1; i <= Math.sqrt(digit); i++) {
            if (digit % i == 0) {
                result = result + 2;
            }
            if (i * i == result) {
                result = result - 1;
            }
        }
        return result;
    }
}
