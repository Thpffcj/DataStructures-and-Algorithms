package algorithms.leetcode.medium1;

/**
 * Created by Thpffcj on 2018/5/24.
 */

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may
 * want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] res = new String[numRows];
        Arrays.fill(res, "");
        int pos = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            res[pos] = res[pos] + s.charAt(i);
            if (pos == numRows - 1) {
                flag = 1;
            } else if (pos == 0) {
                flag = 0;
            }
            if (flag == 0) {
                pos++;
            } else {
                pos--;
            }
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result = result += res[i];
        }
        return result;
    }
}
