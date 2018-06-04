package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/6/4.
 */

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        int pos = 0;
        int digit;
        for (int i = s.length() - 1; i >= 0; i--) {
            digit = s.charAt(i) + 1 - 'A';
            result += digit * Math.pow(26, pos);
            pos++;
        }
        return result;
    }
}
