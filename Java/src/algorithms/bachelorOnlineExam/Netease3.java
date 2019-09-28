package algorithms.bachelorOnlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/27.
 */

/**
 * 牛牛准备参加学校组织的春游，出发前牛牛准备往背包里装入一些零食，牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食，第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下，他一共有多少种零食放发(总体积为0也算一种放发)。
 *
 * 输入描述：
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <=w <= 2 * 10 ^ 9)，表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9)，表示每袋零食的体积。
 * 输出描述：
 * 输出一个正整数，表示牛牛一共有多少种零食放法。
 */
public class Netease3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[] snack = new int[n];
            for (int i = 0; i < n; i++) {
                snack[i] = sc.nextInt();
            }
            int res = 0;
            int result = way(res, snack, 0, w);
            System.out.println(result);
        }
    }

    public static int way(int res, int[] snack, int pos, int w) {
        if (pos == snack.length) {
            return 1;
        }
        if (snack[pos] > w) {
            int temp = way(res, snack, pos + 1, w);
            res = res + temp;
        } else {
            int temp = way(res,  snack, pos + 1, w - snack[pos])
                    + way(res, snack, pos + 1, w);
            res = res + temp;
        }
        return res;
    }
}
