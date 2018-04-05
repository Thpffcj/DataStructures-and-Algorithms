package algorithms.networkMeasurement.jingdong;

/**
 * Created by Thpffcj on 2018/3/28.
 */

import java.util.Scanner;

/**
 * 小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，
 * 二进制数也很常用。现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。 f(x)表示把x这个数用十进制写出后各个数位上的
 * 数字之和。如f(123)=1+2+3=6。 g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么，
 * g(123)=1+1+1+1+0+1+1=6。 小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数称为幸运数，现在他想知道，小于等于n的
 * 幸运数有多少个？
 *
 * 输入描述:
 * 每组数据输入一个数n(n<=100000)
 * 输出描述:
 * 每组数据输出一行，小于等于n的幸运数个数。
 *
 * 输入例子1:
 * 21
 * 输出例子1:
 * 3
 */
public class LuckyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (fx(i) == gx(i)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static int fx(int number) {
        int res = 0;
        while (number > 0) {
            int n = number % 10;
            res += n;
            number = number / 10;
        }
        return res;
    }

    public static int gx(int number) {
        int res = 0;
        while (number > 0) {
            int n = number % 2;
            res += n;
            number = number / 2;
        }
        return res;
    }
}
