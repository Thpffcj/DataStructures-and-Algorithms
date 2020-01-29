package algorithms.networkMeasurement.tencent;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/26.
 *
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 *
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N - 本组测试数据有n个数
 * a1,a2...an - 需要计算的数据
 * 保证：1<=N<=100000,0<=ai<=INT_MAX.
 *
 * 输出描述:
 * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 *
 * 输入例子1:
 * 6
 * 45 12 45 32 5 6
 *
 * 输出例子1:
 * 1 2
 */
public class InterestingNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = sc.nextInt();
            }


        }
    }
}
