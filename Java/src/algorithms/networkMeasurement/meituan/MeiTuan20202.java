package algorithms.networkMeasurement.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/8.
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串（回文串是一个正读和反读都一样的字符串）。
 * 具有不同开始位置或结束位置的回文串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 输入描述:
 * 输入仅包含一个字符串，长度不会超过 1000。
 *
 * 输出描述:
 * 输出仅包含一个非负整数， 代表输入字符串有多少个回文子串。
 *
 * 输入例子1:
 * abc
 * 输出例子1:
 * 3
 *
 * 输入例子2:
 * aaa
 * 输出例子2:
 * 6
 */
public class MeiTuan20202 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += palindrome(s, i, i);
            count += palindrome(s, i, i + 1);
        }
        System.out.println(count);
    }

    public static int palindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
