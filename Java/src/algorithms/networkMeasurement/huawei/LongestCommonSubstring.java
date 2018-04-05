package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/4/3.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 输入描述:
 * 输入两个字符串
 * 输出描述:
 * 返回重复出现的字符
 *
 * 输入
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出
 * jklmnop
 */
public class LongestCommonSubstring {

    // 暴力解法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String max = s1.length() > s2.length() ? s1 : s2;
            String min = s1.length() > s2.length() ? s2 : s1;
            int maxLength = Integer.MIN_VALUE;
            String res = "";
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j < min.length(); j++) {
                    if (max.contains(min.substring(i, j)) && j - i > maxLength) {
                        res = min.substring(i, j);
                        maxLength = j - i;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
