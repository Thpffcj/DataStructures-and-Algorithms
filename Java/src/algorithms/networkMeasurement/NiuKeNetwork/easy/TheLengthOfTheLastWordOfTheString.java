package algorithms.networkMeasurement.NiuKeNetwork.easy;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/18.
 */

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 */
public class TheLengthOfTheLastWordOfTheString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int length = line[line.length - 1].length();
            System.out.println(length);
        }
    }
}
