package algorithms.leetcodecn.string;

/**
 * Created by thpffcj on 2019/10/13.
 */

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class StringAddition {

    public String addStrings(String num1, String num2) {

        if (num1 == null && num2 == null) {
            return "";
        }

        if (num1 == null || num1.equals("")) {
            return num2;
        }

        if (num2 == null || num2.equals("")) {
            return num1;
        }

        int l1 = num1.length();
        int l2 = num2.length();
        int max = Math.max(l1, l2);

        StringBuilder sb = new StringBuilder(num1);
        while (l1 < max) {
            sb.insert(0, "0");
            l1++;
        }
        num1 = sb.toString();
        System.out.println(num1);
        sb = new StringBuilder(num2);
        while (l2 < max) {
            sb.insert(0, "0");
            l2++;
        }
        num2 = sb.toString();
        System.out.println(num2);

        int carry = 0;
        sb = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            int digit = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
            carry = 0;
            if (digit >= 10) {
                digit -= 10;
                carry = 1;
            }
            sb.insert(0, digit);
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        StringAddition s = new StringAddition();
        s.addStrings("1", "9999");
    }
}
