package algorithms.leetcodecn.greedyAlgorithm;

import java.util.Stack;

/**
 * Created by thpffcj on 2020/1/27.
 *
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对
 * 位置）。
 *
 * 示例 1:
 * 输入: "bcabc"
 * 输出: "abc"
 *
 * 示例 2:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        int[] position = new int[26];
        for (int i = 0; i < s.length(); i++) {
            position[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (!stack.contains(current)) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        Character c = stack.peek();
                        if (position[c - 'a'] > i && c > current) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
                stack.add(current);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
