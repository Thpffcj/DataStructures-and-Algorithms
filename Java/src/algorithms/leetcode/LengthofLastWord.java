package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/28.
 */

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length
 * of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        String[] input = s.split(" ");
        if (input.length == 0) {
            return 0;
        }
        return input[input.length - 1].length();
    }
}
