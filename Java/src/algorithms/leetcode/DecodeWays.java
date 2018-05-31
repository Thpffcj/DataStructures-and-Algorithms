package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/31.
 */

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
//                System.out.println("first " + i + " " + dp[i]);
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
//                System.out.println("second " + second + " " + i + " " + dp[i]);
            }
//            System.out.println(i + " " + dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        int result = decodeWays.numDecodings("226");
        System.out.println(result);
    }
}
