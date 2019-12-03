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

    public static TreeSet<String> result = new TreeSet<>();

    /**
     * TODO String
     * 两个序列的最长公共子序列不止一个，所以难点是如何得到它们，不难猜到，需要用回溯法来解决。
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            result.clear();
            char[] arr1 = sc.nextLine().toCharArray();
            char[] arr2 = sc.nextLine().toCharArray();
            longestStr(arr1, arr2);
        }
    }

    public static void longestStr(char[] arr1, char[] arr2) {

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int longest = dp[arr1.length][arr2.length];
        findPath(dp, arr1, arr2, arr1.length, arr2.length, "", longest);

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void findPath(int[][] dp, char[] arr1, char[] arr2, int i, int j, String path, int longest) {

        if (i == 0 || j == 0) {
            if (path.length() == longest) {
                result.add(new StringBuilder(path).reverse().toString());
            }
            return;
        }

        if (arr1[i - 1] == arr2[j - 1]) {
            path += arr1[i - 1];
        }

        if (dp[i][j] == dp[i - 1][j]) {
            findPath(dp, arr1, arr2, i - 1, j, path, longest);
        }

        if (dp[i][j] == dp[i][j - 1]) {
            findPath(dp, arr1, arr2, i, j - 1, path, longest);
        }

        if (dp[i][j] > dp[i - 1][j - 1]) {
            findPath(dp, arr1, arr2, i - 1, j - 1, path, longest);
        }
    }
}
