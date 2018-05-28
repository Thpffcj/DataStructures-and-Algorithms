package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/28.
 */

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';
                result[i + j + 1] = result[i + j + 1] + m * n;
            }
        }
        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] + carry;
            carry = result[i] / 10;
            result[i] = result[i] % 10;
        }
        String res = "";
        int pos = 0;
        while (pos < result.length) {
            if (result[pos] != 0) {
                break;
            }
            pos++;
        }
        if (pos == result.length) {
            return "0";
        }
        for (int i = pos; i < result.length; i++) {
            if (result[i] == 0 && res.equals("")) {
                continue;
            }
            res += result[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        multiplyStrings.multiply("0", "0");
    }
}
