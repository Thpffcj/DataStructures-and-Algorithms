package algorithms.networkMeasurement.NiuKeNetwork;

/**
 * Created by Thpffcj on 2018/3/18.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * 输出到长度为8的新字符串数组
 * <p>
 * 输入
 * abc
 * 123456789
 * <p>
 * 输出
 * abc00000
 * 12345678
 * 90000000
 */
public class StringSeparation {

    // 自己的解法
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            String line = "";
//            while (s1.length() > 8) {
//                line = s1.substring(0, 8);
//                s1 = s1.substring(8);
//                System.out.println(line);
//            }
//            line = "";
//            for (int i = 0; i < 8; i++) {
//                if (i < s1.length()) {
//                    line = line + s1.charAt(i);
//                } else {
//                    line = line + "0";
//                }
//            }
//            System.out.println(line);
//
//            while (s2.length() > 8) {
//                line = s2.substring(0, 8);
//                s2 = s2.substring(8);
//                System.out.println(line);
//            }
//            line = "";
//            for (int i = 0; i < 8; i++) {
//                if (i < s2.length()) {
//                    line = line + s2.charAt(i);
//                } else {
//                    line = line + "0";
//                }
//            }
//            System.out.println(line);
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = new String(sc.nextLine());
            if (s.length() % 8 != 0) {
                s = s + "00000000";
            }

            while (s.length() >= 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }
}
