package algorithms.networkMeasurement.tencent;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/26.
 *
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 *
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 *
 * 输出描述:
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 *
 * 输入例子1:
 * abcda
 * google
 *
 * 输出例子1:
 * 2
 * 2
 */
public class ConstructingAPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = new StringBuilder(s1).reverse().toString();

            int n = s1.length();
            int[][] dp = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            System.out.println(n - dp[n][n]);
        }
    }
}
