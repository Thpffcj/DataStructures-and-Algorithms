package algorithms.networkMeasurement.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/12.
 *
 * 一条直线上等距离放置了n台路由器。路由器自左向右从1到n编号。第i台路由器到第j台路由器的距离为| i-j |。  每台路由器都有自己的信号强度，
 * 第i台路由器的信号强度为ai。所有与第i台路由器距离不超过ai的路由器可以收到第i台路由器的信号（注意，每台路由器都能收到自己的信号）。问
 * 一共有多少台路由器可以收到至少k台不同路由器的信号。
 *
 * 输入描述:
 * 输入第一行两个数n , k（1≤n , k≤10^5）
 * 第二行n个数, a1 , a2 , a3……… , an（0≤ai≤10^9）
 *
 * 输出描述:
 * 输出一个数，一共有多少台路由器可以收到至少k台不同路由器的信号。
 *
 * 输入例子1:
 * 4 4
 * 3 3 3 3
 *
 * 输出例子1:
 * 4
 */
public class MeiTuan20196 {

    /**
     * res 和 dp
     * res 的作用是记录每个路由器能到达的左边界。
     * res[i][0] = 0的话，表示路由器i最左边能到达坐标 0 。
     * 也说明了能到达 坐标 1, 2, ... 。但是最右能到达哪呢？这个在res[i][1] 记录着。
     *
     * dp数组累加表示坐标 i 有几个路由器能到达。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] router = new int[n];
        for (int i = 0; i < n; i++) {
            router[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int r = router[i];
            dp[Math.max(0, i - r)]++;
            dp[Math.min(n, i + r + 1)]--;
        }

        int digit = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            digit += dp[i];
            if (digit >= k) {
                result++;
            }
        }
        System.out.println(result);
    }
}
