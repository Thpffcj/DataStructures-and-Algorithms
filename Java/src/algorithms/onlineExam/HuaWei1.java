package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */

/**
 * 题目描述
 * 输入一个字符串，输出该字符串中对称的子字符串的最大长度。比如输入字符串“12213”，由于该字符串里最长的对称子字符串是“1221”，因此输出4。
 * 输入描述:
 * 连续的字符串，字符串长度不会超过64，只包含数字和字母。
 * 输出描述:
 * 最长的对称字符串长度
 * 示例1
 * 输入
 * 12321abc
 * 输出
 * 5
 * 说明
 * 最长对称字符串为“12321”，因此长度为5
 */
public class HuaWei1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int n = line.length();
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j <= n; j++) {
                    if (isPalindrome(line.substring(i, j)) && j - i > res) {
                        res = j - i;
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
