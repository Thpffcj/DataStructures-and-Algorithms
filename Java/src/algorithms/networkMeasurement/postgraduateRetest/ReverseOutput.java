package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-06.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 输入任意4个字符(如：abcd)， 并按反序输出(如：dcba)
 *
 * 输入描述:
 * 题目可能包含多组用例，每组用例占一行，包含4个任意的字符。
 *
 * 输出描述:
 * 对于每组输入,请输出一行反序后的字符串。
 *
 * 示例1
 * 输入
 * Upin
 * cvYj
 * WJpw
 * cXOA
 *
 * 输出
 * nipU
 * jYvc
 * wpJW
 * AOXc
 */
public class ReverseOutput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            StringBuffer stringBuffer = new StringBuffer(input);
            System.out.println(stringBuffer.reverse());
        }
    }
}
