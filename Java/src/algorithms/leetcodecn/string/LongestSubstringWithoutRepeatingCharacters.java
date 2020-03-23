package algorithms.leetcodecn.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by thpffcj on 2019/10/10.
 *
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

        while (end < s.length()) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
                max = Math.max(max, end - start);
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    /**
     * 我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
     * 也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j'重复的字符，我们不需要逐渐增加 i 。
     * 我们可以直接跳过 [i，j'][i，j] 范围内的所有元素，并将 i 变为 j' + 1
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
