package algorithms.leetcodecn.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thpffcj on 2020/1/3.
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedSubarray {

    /**
     * 执行结果：解答错误
     * 输入:
     * [0,1,1,1,1]
     * [1,0,1,0,1]
     *
     * 输出
     * 3
     *
     * 预期结果
     * 2
     */
//    public int findLength(int[] A, int[] B) {
//
//        int m = A.length;
//        int n = B.length;
//        if (m <= 0 || n <= 0) {
//            return 0;
//        }
//
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (A[i - 1] == B[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//
//        return dp[m][n];
//    }

    public int findLength(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) {
                    int length = 0;
                    int a = i;
                    int b = j;
                    while (a < m && b < n && A[a] == B[b]) {
                        length++;
                        a++;
                        b++;
                    }
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }

        return maxLength;
    }

    /**
     * 二分查找的下界为 0，上界为 min(len(A), len(B))。在二分查找的每一步中，我们仍然使用最简单的判断方法，即找出数组 A 和 B 中
     * 所有长度为 mid 的子数组，判断是否存在一个子数组在 A 和 B 中都出现过。
     */
    public int findLength2(int[] A, int[] B) {
        int lo = 0;
        int hi = Math.min(A.length, B.length) + 1;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (check(mi, A, B)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo - 1;
    }

    public boolean check(int length, int[] A, int[] B) {
        Set<String> seen = new HashSet();

        for (int i = 0; i + length <= A.length; i++) {
            seen.add(Arrays.toString(Arrays.copyOfRange(A, i, i+length)));
        }

        for (int j = 0; j + length <= B.length; j++) {
            if (seen.contains(Arrays.toString(Arrays.copyOfRange(B, j, j+length)))) {
                return true;
            }
        }
        return false;
    }

    public int findLength3(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j]) {
                        ans = memo[i][j];
                    }
                }
            }
        }
        return ans;
    }

    public int findLength4(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
