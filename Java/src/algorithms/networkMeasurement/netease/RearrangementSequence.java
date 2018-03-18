package algorithms.networkMeasurement.netease;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/17.
 */

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 *
 * 输入描述:
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 *
 * 输出描述:
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 */
public class RearrangementSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int total = sc.nextInt();
            for (int i = 0; i < total; i++) {
                int number = sc.nextInt();
                boolean isEven = false;
                int four = 0;
                int odd = 0;
                System.out.println(i + " group " + number);
                for (int j = 0; j < number; j++) {
                    int num = sc.nextInt();
                    System.out.print(num + " ");
                    if (num % 4 == 0) {
                        four++;
                    } else if (num % 2 == 0) {
                        isEven = true;
                    } else {
                        odd++;
                    }
                }
                System.out.println();
                if (isEven) {
                    if (four >= odd) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else {
                    if (four >= (odd - 1)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
        }
    }
}
