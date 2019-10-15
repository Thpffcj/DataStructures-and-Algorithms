package algorithms.leetcodecn.string;

/**
 * Created by thpffcj on 2019/10/14.
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 *  说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length <= 0) {
            return "";
        }

        String s = strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (i >= strs[j].length()
                        || i >= strs[j + 1].length()
                        || strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
