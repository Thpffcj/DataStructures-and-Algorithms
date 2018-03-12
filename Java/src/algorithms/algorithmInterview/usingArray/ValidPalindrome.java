package algorithms.algorithmInterview.usingArray;

/**
 * Created by Thpffcj on 2018/3/9.
 */

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = actual.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (actual.charAt(l) != actual.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
