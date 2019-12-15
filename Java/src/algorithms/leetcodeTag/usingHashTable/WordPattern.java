package algorithms.leetcodeTag.usingHashTable;

/**
 * Created by Thpffcj on 2018/3/13.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
 * word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.pattern = "abba", str = "dog dog dog dog"
 * should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by
 * a single space.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if(p.length != s.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            if (map.get(p[i]) != null) {
                if (!map.get(p[i]).equals(s[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(s[i])) {
                    return false;
                } else {
                    map.put(p[i], s[i]);
                }
            }
        }
        return true;
    }
}
