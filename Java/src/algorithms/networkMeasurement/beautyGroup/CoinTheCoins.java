package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

import java.util.Scanner;

/**
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）
 * 的不同组合的个数。
 *
 * 输入描述:
 * 输入包括一个整数n(1 ≤ n ≤ 10000)
 * 输出描述:
 * 输出一个整数,表示不同的组合方案数
 *
 * 输入例子1:
 * 1
 * 输出例子1:
 * 1
 */
public class CoinTheCoins {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if(n <= 0) {
                System.out.println(0);
            }
            int[] coins = new int[]{1,5,10,20,50,100};
            long[] method = new long[n + 1];
            method[0] = 1L;
            for (int i = 0; i < coins.length; i++) {
                for(int j = coins[i]; j <= n; j++) {
                    method[j] = method[j] + method[j - coins[i]];
                }
            }
            long result = method[n];
            System.out.println(result);
        }
    }
}
