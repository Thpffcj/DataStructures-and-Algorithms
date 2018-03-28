package algorithms.onlineExam;

/**
 * Created by Thpffcj on 2018/3/22.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在十进制表示中，任意一个正整数都可以用字符‘0’-‘9’表示出来。但是当‘0’-‘9’这些字符每种字符的数量有限时，可能有些正整数就
 * 无法表示出来了。比如你有两个‘1’ ，一个‘2’ ，那么你能表示出 11，12，121 等等，但是无法表示出 10，122，200 等数。
 * 现在你手上拥有一些字符，它们都是‘0’-‘9’的字符。你可以选出其中一些字符然后将它们组合成一个数字，那么你所无法组成的最小的
 * 正整数是多少？
 *
 * 输入
 * 第一行包含一个由字符’0’-‘9’组成的字符串，表示你可以使用的字符。
 * 1 ≤字符串长度≤ 1000
 * 输出
 * 输出你所无法组成的最小正整数。
 *
 * 样例输入
 * 55
 * 样例输出
 * 1
 *
 * Hint
 * Input Sample 2
 * 123456789
 * Output Sample 2
 * 10
 */
public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] number = new int[10];
        Arrays.fill(number, 0);
        for (int i = 0; i < line.length(); i++) {
            number[line.charAt(i) - '0']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < number.length; i++) {
            if (number[i] < min) {
                min = number[i];
            }
        }
        int pos = -1;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == min) {
                pos = i;
                break;
            }
        }
        String res = "";
        boolean flag = true;
        if (pos == 0) {
            for (int j = 0; j < number.length - 1; j++) {
                if (number[j] != number[j + 1]) {
                    flag = false;
                }
            }
            if (flag) {
                for (int j = 0; j <= min; j++) {
                    res = res + "1";
                }
            } else {
                res = "1";
                for (int j = 0; j <= min; j++) {
                    res = res + "0";
                }
            }
        } else {
            for (int j = 0; j <= min; j++) {
                res = res + String.valueOf(pos);
            }
        }
        System.out.println(res);
    }
}
