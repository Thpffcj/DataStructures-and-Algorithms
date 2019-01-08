package algorithms.leetcode.easy1;

/**
 * Created by Thpffcj on 2018/6/4.
 */

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1:
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        int digit;
        char c;
        while (n != 0) {
            n--;
            digit = n % 26;
            c = (char)('A' + digit);
            stringBuffer.append(c);
            n = n / 26;
        }
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
