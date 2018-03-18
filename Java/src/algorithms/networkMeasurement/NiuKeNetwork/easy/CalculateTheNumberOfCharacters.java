package algorithms.networkMeasurement.NiuKeNetwork.easy;

/**
 * Created by Thpffcj on 2018/3/18.
 */

import java.util.Scanner;

/**
 * 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 */
public class CalculateTheNumberOfCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine().toLowerCase();
            char target = sc.nextLine().charAt(0);
            int number = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == target) {
                    number++;
                }
            }
            System.out.println(number);
        }
    }
}
