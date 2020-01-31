package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/29.
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 *
 * 输出
 * 2147483647
 * 0
 */
public class Offer20_2 {

    public static int StrToInt(String str) {

        if (str == null) {
            return 0;
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = str.length();

        // limit 默认初始化为负的最大正整数，假如字符串表示的是正数那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来
        // 比较，判断是否溢出
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    // 在负号的情况下，判断溢出的值就变成了整数的最小负数了
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')  // 第一位不是数字和-只能是+
                    return 0;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }

            multmin = limit / 10;
            while (i < len) {
                // 负积累可避免在MAX_VALUE附近出现意外
                digit = str.charAt(i++) - '0';  // char转int
                if (digit < 0 || digit > 9)  // 0到9以外的数字
                    return 0;

                // 判断溢出
                if (result < multmin) {
                    return 0;
                }

                result *= 10;

                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        // 如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(Offer20_2.StrToInt("-2147483649"));
//        System.out.println(-2147483647 - 9);
    }
}
