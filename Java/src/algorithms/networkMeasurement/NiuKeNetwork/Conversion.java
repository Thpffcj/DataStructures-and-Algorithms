package algorithms.networkMeasurement.NiuKeNetwork;

/**
 * Created by Thpffcj on 2018/3/16.
 */

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 输入例子1:
 * 0xA
 *
 * 输出例子1:
 * 10
 */
public class Conversion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int n = line.length();
            int result = 0;
            int j = 0;
            for (int i = n - 1; i > 1; i--) {
                result = result + getNumber(line.charAt(i)) * (int) Math.pow(16, j);
                j++;
            }
            System.out.println(result);
        }
    }

    public static int getNumber(char c) {
        String number = "0123456789ABCDEF";
        return number.indexOf(c);
    }
}
