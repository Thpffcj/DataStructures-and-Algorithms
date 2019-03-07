package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-06.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 求正整数N(N>1)的质因数的个数。 相同的质因数需要重复计算。如120=2*2*2*3*5，共有5个质因数。
 *
 * 输入描述:
 * 可能有多组测试数据，每组测试数据的输入是一个正整数N，(1<N<10^9)。
 *
 * 输出描述:
 * 对于每组数据，输出N的质因数的个数。
 *
 * 示例1
 * 输入
 * 120
 * 输出
 * 5
 */
public class NumberOfPrimeFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            int result = 0;
            while (number > 1) {
                int prime = getPrime(number);
                number = number / prime;
                result += 1;
            }
            System.out.println(result);
        }
    }

    private static int getPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
           if (number % i == 0) {
               return i;
           }
        }
        return -1;
    }
}
