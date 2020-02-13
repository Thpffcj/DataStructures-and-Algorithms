package algorithms.networkMeasurement.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by thpffcj on 2019/12/11.
 *
 * 你打开了美了么外卖，选择了一家店，你手里有一张满X元减10元的券，店里总共有n种菜，第i种菜一份需要A_i元，因为你不想吃太多份同一种菜，
 * 所以每种菜你最多只能点一份，现在问你最少需要选择多少元的商品才能使用这张券。
 *
 * 输入描述:
 * 第一行两个正整数n和X，分别表示菜品数量和券的最低使用价格。（1≤n≤100, 1≤X≤10000） 接下来一行n个整数，第i个整数表示第i种菜品的价格。
 * （1≤A_i≤100）
 *
 * 输出描述:
 * 一个数，表示最少需要选择多少元的菜才能使用这张满X元减10元的券，保证有解。
 *
 * 输入例子1:
 * 5 20
 * 18 19 17 6 7
 *
 * 输出例子1:
 * 23
 */
public class MeiTuan20193 {

    public static List<Integer> list = new ArrayList<>();

    /**
     * 01背包：找大于等于X的最小可达状态
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int X = sc.nextInt();
            int[] digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = sc.nextInt();
            }

            System.out.println(getMinCost(n, X, digit));
        }
    }

    public static int getMinCost(int n, int X, int[] digit) {

        int[][] v = new int[n + 1][X + 1];
        for (int i = 0; i <= X; i++) {
            v[0][i] = 10001;
        }

        // 循环求解，求放入背包的最小值
        // 从第一个物品开始
        for (int i = 1; i <= n; i++) {
            // 从背包容量为1开始
            for (int j = 1; j <= X; j++) {
                // 当前物品价格 > 背包容量
                if (digit[i - 1] >= j) {
                    // 选之前和当前价格最小的
                    v[i][j] = Math.min(digit[i - 1], v[i - 1][j]);
                } else { // 当前物品价格 < 背包容量
                    // 选 min（之前的策略，把当前物品装入后剩余背包能装最少的物品） 两者最小值
                    v[i][j] = Math.min(
                            v[i - 1][j],
                            digit[i - 1] + v[i - 1][j - digit[i - 1]]);
                }
            }
        }

        return v[n][X];
    }

    public static int getMinCost2(int n, int X, int[] digit) {

        int[] xs = new int[X + 1];
        for (int i = 0; i <= X; i++) {
            xs[i] = 10001;
        }

        for (int i = 0; i < n; i++) {
            int price = digit[i];
            for (int j = X; j >= 0; j--) {
                if (j > price) {
                    // 如果凑单价格大于当前price，那么就看下原来的凑单价最小还是
                    // 当前菜品的价格，加上j-price的价格最少需要多少元凑单
                    xs[j] = Math.min(xs[j], xs[j - price] + price);
                } else {
                    // 如果当前凑单价格小于等于price，必须点当前price的菜，除非有比当前价格更小的菜
                    xs[j] = Math.min(xs[j], price);
                }
            }
        }

        return xs[X];
    }

    // 超时
    public static void getArrangement(int[] digit, int position, int cost, int X) {
        if (cost >= X) {
            list.add(cost);
            return;
        }
        if (position == digit.length) {
            return;
        }
        getArrangement(digit, position + 1, cost + digit[position], X);
        getArrangement(digit, position + 1, cost, X);
    }
}
