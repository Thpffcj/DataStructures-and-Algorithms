package algorithms.leetcodecn.string;

/**
 * Created by thpffcj on 2019/12/28.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {

        if (numRows <= 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int position = -1;
        int direction = 1;
        for (char c : s.toCharArray()) {
            if (position == 0) {
                direction = 1;
            }
            if (position == numRows - 1) {
                direction = -1;
            }
            position += direction;
            list.get(position).append(c);
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }
}

