package algorithms.advancedAlgorithm.homework.homework2;

/**
 * Created by thpffcj on 2019/10/26.
 */

import java.util.*;

/**
 * Description
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 * <p>
 * Input
 * 输入第一行为用例个数， 每个测试用例输入为两行，一行一个字符串
 * <p>
 * Output
 * 如果没有公共子序列，不输出，如果有多个则分为多行，按字典序排序。
 * <p>
 * 1
 * 1A2BD3G4H56JK
 * 23EFG4I5J6K7
 * <p>
 * 23G456K
 * 23G45JK
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();

            int dp = LCS(line1, line2);
        }
    }

    public static int LCS(String a, String b) {
        int n = a.length(), m = b.length();
        // c[i][j]表示a长度为i和b长度为j时的最长公共子序列长度
        int[][] c = new int[n+1][m+1];
        // d[i][j]表示方向
        char[][] d = new char[n+1][m+1];
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    // 左上
                    d[i][j] = '↖';
                } else if(c[i-1][j] > c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    // 上
                    d[i][j] = '↑';
                } else if(c[i-1][j] < c[i][j-1]){
                    c[i][j] = c[i][j-1];
                    // 左
                    d[i][j] = '←';
                } else {
                    c[i][j] = c[i][j-1];
                    // 可向左可向右
                    d[i][j] = '┘';
                }
            }
        }
        String lcs = "";
        Set<String> lcsSet = new HashSet<>();
        backTrace(d,a,lcs,n,m,c[n][m],lcsSet);
        List<String> list = new ArrayList<>();
        for (String s : lcsSet) {
            list.add(s);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return c[n][m];
    }

    public static void backTrace(char[][] d, String a, String lcs, int i , int j, int maxSublen, Set<String> lcsSet){
        if(i == 0 || j == 0) {
            StringBuilder sb = new StringBuilder(lcs);
            lcs = sb.reverse().toString();
            // 可能有些提早出来了，一定要判断长度是最长的，但是这样还是会有重复的字符串，所以还要做去重处理
            if (lcs.length() == maxSublen) {
                lcsSet.add(lcs);
            }
            return;
        }

        switch (d[i][j]){
            case '↖':
                lcs += a.charAt(i-1);
                backTrace(d,a,lcs,i-1,j-1,maxSublen,lcsSet);
                break;
            case '↑':
                backTrace(d,a,lcs,i-1,j,maxSublen,lcsSet);
                break;
            case '←':
                backTrace(d,a,lcs,i,j-1,maxSublen,lcsSet);
                break;
            case '┘':
                backTrace(d,a,lcs,i-1,j,maxSublen,lcsSet);
                backTrace(d,a,lcs,i,j-1,maxSublen,lcsSet);
                break;
        }
    }


//    public static int[][] findLCS(String A, int n, String B, int m) {
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (A.charAt(i - 1) == B.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp;
//    }
}
