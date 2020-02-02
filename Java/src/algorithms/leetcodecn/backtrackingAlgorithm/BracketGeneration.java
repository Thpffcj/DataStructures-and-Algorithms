package algorithms.leetcodecn.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thpffcj on 2019/10/9.
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class BracketGeneration {

    // 这个回溯写的很混乱
    public static String LEFT = "(";
    public static String RIGHT = ")";
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return null;
        }
        generateParenthesis("", LEFT, n, n, 0);
        return result;
    }

    public void generateParenthesis(String s, String bracket, int left, int right, int pos) {
        if (left == 0 && right == 0 && pos == 0) {
            result.add(s);
        }

        if (bracket.equals(LEFT)) {
            s = s + LEFT;
            pos++;
        } else {
            s = s + RIGHT;
            pos--;
            if (pos < 0) {
                return;
            }
        }

        if (left > 0) {
            generateParenthesis(s, LEFT, left - 1, right, pos);
        }
        if (right > 0) {
            generateParenthesis(s, RIGHT, left, right - 1, pos);
        }
    }

    // 回溯法
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

    /**
     * 把结果集保存在动态规划的数组里
     * 定义状态 dp[i]：使用 i 对括号能够生成的组合。
     * dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     * dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
     * @param n
     * @return
     */
    public List<String> generateParenthesis3(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        BracketGeneration b = new BracketGeneration();
        b.generateParenthesis(3);
    }
}
