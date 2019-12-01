package algorithms.advancedAlgorithm.homework.homework2;

/**
 * Created by thpffcj on 2019/10/26.
 */

import java.util.*;

/**
 * Description
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入为两行，一行一个字符串
 *
 * Output
 * 如果没有公共子序列，不输出，如果有多个则分为多行，按字典序排序。
 *
 * Sample Input 1
 * 1
 * 1A2BD3G4H56JK
 * 23EFG4I5J6K7
 *
 * Sample Output 1
 * 23G456K
 * 23G45JK
 */
public class LongestCommonSubsequence {

    /**
     * TODO String
     * 两个序列的最长公共子序列不止一个，所以难点是如何得到它们，不难猜到，需要用回溯法来解决。
     * 具体做法是在计算长度的时候，用一个数组保存当前点是从哪个状态转移过来的
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            int dp = LCS(line1, line2);
            numbers--;
        }
    }

    public static int LCS(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        // dp[i][j]表示a长度为i和b长度为j时的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // d[i][j]表示方向
        char[][] direction = new char[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 左上
                    direction[i][j] = '↖';
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    // 上
                    direction[i][j] = '↑';
                } else if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                    // 左
                    direction[i][j] = '←';
                } else {
                    dp[i][j] = dp[i][j - 1];
                    // 可向左可向上
                    direction[i][j] = '┘';
                }
            }
        }

        String lcs = "";
        Set<String> lcsSet = new HashSet<>();
        backTrace(direction, s1, lcs, m, n, dp[m][n], lcsSet);

        List<String> list = new ArrayList<>();
        for (String s : lcsSet) {
            list.add(s);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        return dp[m][n];
    }

    public static void backTrace(char[][] d, String s1, String lcs, int i, int j, int maxSubLength, Set<String> lcsSet) {

        if (i == 0 || j == 0) {
            StringBuilder sb = new StringBuilder(lcs);
            lcs = sb.reverse().toString();

            // 可能有些提早出来了，一定要判断长度是最长的，但是这样还是会有重复的字符串，所以还要做去重处理
            if (lcs.length() == maxSubLength) {
                lcsSet.add(lcs);
            }
            return;
        }

        switch (d[i][j]) {
            case '↖':
                lcs += s1.charAt(i - 1);
                backTrace(d, s1, lcs, i - 1, j - 1, maxSubLength, lcsSet);
                break;
            case '↑':
                backTrace(d, s1, lcs, i - 1, j, maxSubLength, lcsSet);
                break;
            case '←':
                backTrace(d, s1, lcs, i, j - 1, maxSubLength, lcsSet);
                break;
            case '┘':
                backTrace(d, s1, lcs, i - 1, j, maxSubLength, lcsSet);
                backTrace(d, s1, lcs, i, j - 1, maxSubLength, lcsSet);
                break;
        }
    }
}
