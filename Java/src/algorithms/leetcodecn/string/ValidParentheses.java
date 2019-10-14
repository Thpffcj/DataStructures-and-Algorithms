package algorithms.leetcodecn.string;

/**
 * Created by thpffcj on 2019/10/13.
 */

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if (s == null || s.equals("")) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char current;
        char last;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                last = stack.pop();
                if ((last == '(' && current != ')')
                || (last == '[' && current != ']')
                || (last == '{' && current != '}')) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
