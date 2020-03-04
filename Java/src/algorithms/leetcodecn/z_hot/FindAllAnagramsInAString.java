package algorithms.leetcodecn.z_hot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thpffcj on 2020/3/1.
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int length = p.length();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            window[cur - 'a']++;
            if (need[cur - 'a'] > 0 && need[cur - 'a'] >= window[cur - 'a']) {
                count++;
            }
            if (i - length >= 0) {
                char last =  s.charAt(i - length);
                window[last - 'a']--;
                if (need[last - 'a'] > 0 && need[last - 'a'] > window[last - 'a']) {
                    count--;
                }
            }

            if (count == length) {
                list.add(i - length + 1);
            }
        }

        return list;
    }
}
