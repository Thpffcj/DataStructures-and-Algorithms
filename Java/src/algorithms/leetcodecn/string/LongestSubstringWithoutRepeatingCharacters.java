package algorithms.leetcodecn.string;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        int current = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
                current++;
                if (current > max) {
                    max = current;
                }
            } else {
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                    current--;
                }
                // 整体前移
                start++;
                end++;
            }
        }
        return max;
    }
}
