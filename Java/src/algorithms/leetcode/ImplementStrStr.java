package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/27.
 */

/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's
 * strstr() and Java's indexOf().
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int pos = 0;
            if (haystack.charAt(i) == needle.charAt(pos)) {
                int j = i + 1;
                pos++;
                while (pos < needle.length()) {
                    if (haystack.charAt(j) == needle.charAt(pos)) {
                        j++;
                        pos++;
                    } else {
                        break;
                    }
                }
                if (pos == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
