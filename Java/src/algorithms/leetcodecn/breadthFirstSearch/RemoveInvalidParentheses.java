package algorithms.leetcodecn.breadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thpffcj on 2019/12/23.
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 *
 * 示例 2:
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 *
 * 示例 3:
 * 输入: ")("
 * 输出: [""]
 */
public class RemoveInvalidParentheses {

    private Set<String> validExpressions = new HashSet<String>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // 首先，我们找出左括号和右括号错放的数量
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                }

                if (left > 0) {
                   left--;
                }
            }
        }

        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<String>(this.validExpressions);
    }

    /**
     * @param s
     * @param index 它表示我们必须在原始字符串中处理的当前字符
     * @param leftCount 它表示添加到我们正在构建的表达式中的左括号数
     * @param rightCount 它表示添加到我们正在构建的表达式中的右括号数
     * @param leftRem 是要删除的左括号数
     * @param rightRem 表示要删除的右括号数
     * @param expression
     */
    private void recurse(String s, int index, int leftCount, int rightCount,
            int leftRem, int rightRem, StringBuilder expression) {

        // 如果到达字符串的末尾，只需检查结果表达式是否有效，以及是否已经删除了应该删除的左右括号的总数
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                this.validExpressions.add(expression.toString());
            }
        } else {
            char character = s.charAt(index);
            int length = expression.length();

            // 丢弃的情况
            // 请注意，这里有修剪条件。如果该括号的剩余计数为== 0，我们不会递归
            if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                this.recurse(
                        s, index + 1, leftCount, rightCount,
                        leftRem - (character == '(' ? 1 : 0),
                        rightRem - (character == ')' ? 1 : 0),
                        expression);
            }

            expression.append(character);

            // 如果当前字符不是括号，只需简单地进一步递归一步
            if (character != '(' && character != ')') {
                this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            } else if (character == '(') {
                // Consider an opening bracket.
                this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            } else if (rightCount < leftCount) {
                // Consider a closing bracket.
                this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }

            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        List<String> list = r.removeInvalidParentheses("()())()");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
