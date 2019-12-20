package algorithms.leetcodecn.design;

/**
 * Created by thpffcj on 2019/12/19.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * 说明:
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class WordDictionary {

    Map<Integer, Set<String>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (map.containsKey(word.length())) {
            map.get(word.length()).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(word.length(), set);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (!map.containsKey(word.length())) {
            return false;
        }

        if (map.get(word.length()).contains(word)) {
            return true;
        }

        for (String s : map.get(word.length())) {
            if (isEqual(s, word)) {
                return true;
            }
        }

        return false;
    }

    private boolean isEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!(s1.charAt(i) == '.' || s2.charAt(i) == '.' || s1.charAt(i) == s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
