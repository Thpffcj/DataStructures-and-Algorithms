package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-04.
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 题目描述
 * 将一个长度最多为30位数字的十进制非负整数转换为二进制数输出。
 * <p>
 * 输入描述:
 * 多组数据，每行为一个长度不超过30位的十进制非负整数。（注意是10进制数字的个数可能有30个，而非30bits的整数）
 * <p>
 * 输出描述:
 * 每行输出对应的二进制数。
 * <p>
 * 示例1
 * 输入
 * 0
 * 1
 * 3
 * 8
 * 输出
 * 0
 * 1
 * 11
 * 1000
 */
public class BinaryConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            BigInteger digit = new BigInteger(line, 10);
            System.out.println(digit.toString(2));
        }
    }
}
