package algorithms.leetcodecn.string;

/**
 * Created by thpffcj on 2019/10/18.
 */

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"

 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class BinarySummation {

    public String addBinary(String a, String b) {

        if (a == null && b == null) {
            return "";
        }

        int length = Math.max(a.length(), b.length());
        a = addZero(a, length);
        b = addZero(b, length);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(a.charAt(i) + "") + Integer.parseInt(b.charAt(i) + "") + carry;
            carry = 0;
            if (digit >= 2) {
                digit -= 2;
                carry = 1;
            }
            sb.insert(0, digit);
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public String addZero(String s, int length) {
        int n = s.length();
        for (int i = 0; i < length - n; i++) {
            s = "0".concat(s);
        }
        return s;
    }

    public static void main(String[] args) {
        BinarySummation b = new BinarySummation();
        b.addBinary("101111", "10");
    }
}
