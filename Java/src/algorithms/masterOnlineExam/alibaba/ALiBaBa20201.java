package algorithms.masterOnlineExam.alibaba;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/23.
 */
public class ALiBaBa20201 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                dp[i] += dp[j - 1] * i;
            }
            dp[i] = dp[i] + i;
        }
        System.out.println(dp[n] & 1000000007);
    }
}
