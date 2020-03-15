package algorithms.leetcodecn.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thpffcj on 2019/12/14.
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {

        result = new ArrayList<>();
        if (s == null || s.length() <= 0) {
            return result;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) &&
                        (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        partitionHelper(s, 0, dp, new ArrayList<>());

        return result;
    }

    private void partitionHelper(String s, int start, boolean[][] dp, List<String> list) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                partitionHelper(s, i + 1, dp, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
