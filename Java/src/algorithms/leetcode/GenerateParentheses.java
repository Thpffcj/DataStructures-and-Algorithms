package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/27.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    // 对于这种列出所有结果的题首先还是考虑用递归Recursion来解
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(n, n, "", res);
        return res;
    }

    public void generateParenthesis(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        generateParenthesis(left - 1, right, out + "(", res);
        generateParenthesis(left, right - 1, out + ")", res);
    }
}
