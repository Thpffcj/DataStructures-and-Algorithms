package algorithms.leetcodeTag.usingHashTable;

/**
 * Created by Thpffcj on 2018/3/31.
 */

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
                map.get(keyStr).add(s);
            } else {
                map.get(keyStr).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
