package algorithms;

/**
 * Created by Thpffcj on 2017/7/28.
 */

import static java.lang.StrictMath.min;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s
 * is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    private int startIndex = 0;
    private int length = 0;

    public String longestPalindrome(String s) {
        int left=0, right=0;
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                left = i;
                right = i+1;
                searchPalindrome(s, left, right);
            }
            left = right = i;
            searchPalindrome(s, left, right);
        }
        if (length == 0) {
            length = s.length();
        }
//        System.out.println(startIndex+" "+length);
        return s.substring(startIndex, startIndex+length);
    }

    public void searchPalindrome(String s, int left, int right) {
        int step = 1;
        while ((left - step) >= 0 && (right + step) < s.length()) {
            if (s.charAt(left - step) != s.charAt(right + step)) {
                break;
            }
            step++;
        }
        int wide = right - left + 2 * step - 1;
        if (length < wide) {
            length = wide;
            startIndex = left - step + 1;
        }
    }

    public String longestPalindrome2(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int left = 0, right = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(s.charAt(j) == s.charAt(i) && (i-j < 2 || dp[j + 1][i - 1] == 1)) {
                    dp[j][i] = 1;
                }
                if (dp[j][i] == 1 && len < i-j+1) {
                    len = i - j + 1;
                    left = j;
                    right = i;
                }
            }
            dp[i][i] = 1;
        }
        return s.substring(left, right + 1);
    }

    public String longestPalindrome3(String s) {
        String t ="$#";
        for (int i = 0; i < s.length(); i++) {
            t += s.charAt(i);
            t += '#';
        }
        t += '*';
//        System.out.println(t+" "+t.length());
        int[] p = new int[t.length()];
        int id = 0, mx = 0, resId = 0, resMx = 0;
        for (int i = 1; i < t.length()-1; i++) {
//            System.out.println("i "+i+" mx "+mx);
            p[i] = mx > i ? min(p[2 * id - i], mx - i) : 1;
            System.out.println(p[i]);
            while (t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resMx < p[i]) {
                resMx = p[i];
                resId = i;
            }
        }
        return s.substring((resId - resMx) / 2, (resId - resMx) / 2 + resMx - 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String s = "acbcda";
        String result = longestPalindromicSubstring.longestPalindrome3(s);
        System.out.println(result);
    }
}
