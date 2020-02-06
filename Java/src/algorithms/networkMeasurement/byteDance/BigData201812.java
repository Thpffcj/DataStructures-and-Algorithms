package algorithms.networkMeasurement.byteDance;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/1.
 *
 * 存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到房间pi(1<=pi<=i),现在路人甲从
 * 房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
 *     A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
 *     B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
 * 现在路人甲想知道移动到房间n+1一共需要多少次移动；
 *
 * 输入描述:
 * 第一行包括一个数字n(30%数据1<=n<=100，100%数据 1<=n<=1000)，表示房间的数量，接下来一行存在n个数字 pi(1<=pi<=i), pi表示从房
 * 间i可以传送到房间pi。
 *
 * 输出描述:
 * 输出一行数字，表示最终移动的次数，最终结果需要对1000000007 (10e9 + 7) 取模。
 *
 * 输入例子1:
 * 2
 * 1 2
 *
 * 输出例子1:
 * 4
 *
 * 例子说明1:
 * 开始从房间1 只访问一次所以只能跳到p1即 房间1， 之后采用策略A跳到房间2，房间2这时访问了一次因此采用策略B跳到房间2，之后采用策略A跳到
 * 房间3，因此到达房间3需要 4 步操作。
 */
public class BigData201812 {

    /**
     * 思路：我想去更高的i+1房间，我一定需要偶数次访问i房间，我在访问i房间的时候，我必然是访问了偶数次i-1房间。
     * 递归方程：dp[i+1] = dp[i] + 1 + dp[Pi~i] + 1。
     * 这个方程的意思是：我第一次来到i+1房间，我必然是已经先第一次来到过i房间（dp[i]），然后跳转到Pi房间(1)，然后从Pi到i（dp[Pi~i]）,
     * 然后再从i到i+1（1）。
     * 这里有一个dp[Pi~i]，就需要用到刚刚的思路，因为Pi到i的每一次迭代都是一次状态重启的迭代，所以dp[Pi~i] = dp[i]-dp[Pi]。
     * dp[i+1] = 2 * dp[i] + 2 - dp[Pi]
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long mod = 1000000007;
        int n = sc.nextInt();
        int[] next = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            next[i] = sc.nextInt();
        }

        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = ((dp[i - 1] * 2) % mod - dp[next[i] - 1] + 2) % mod;
        }
        System.out.println((dp[n]) % mod);
    }
}