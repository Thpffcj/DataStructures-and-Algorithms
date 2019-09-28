package algorithms.bachelorOnlineExam;

/**
 * Created by Thpffcj on 2018/3/22.
 */

import java.util.Scanner;

/**
 * 给出两个相同长度的由字符 a 和 b 构成的字符串，定义它们的距离为对应位置不同的字符的数量。如串”aab”与串”aba”的距离为 2；
 * 串”ba”与串”aa”的距离为 1；串”baa”和串”baa”的距离为 0。下面给出两个字符串 S 与 MeiTuan2，其中 S 的长度不小于 MeiTuan2 的长度。
 * 我们用|S|代表 S 的长度，|MeiTuan2|代表 MeiTuan2 的长度，那么在 S 中一共有|S|-|MeiTuan2|+1 个与 MeiTuan2 长度相同的子串，现在你需要计算 MeiTuan2 串与
 * 这些|S|-|MeiTuan2|+1 个子串的距离的和。
 *
 * 输入
 * 第一行包含一个字符串 S。
 * 第二行包含一个字符串 MeiTuan2。
 * S 和 MeiTuan2 均由字符 a 和 b 组成，1 ≤ |MeiTuan2| ≤ |S| ≤105 。
 * 输出
 * 输出对应的答案。
 *
 * 样例输入
 * aab
 * aba
 * 样例输出
 * 2
 *
 * Hint
 * Input Sample 2
 * aaabb
 * bab
 * Output Sample 2
 * 5
 * 在样例 2 中，”aaa”与”bab”的距离为 2，”aab”与”bab”的距离为 1，”abb”与”bab”的距离为 2，
 * 所以最后答案为 5。
 */
public class MeiTuan1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int l1 = s1.length();
            int l2 = s2.length();
            int res = 0;
            for (int i = 0; i <= l1 - l2; i++) {
                for (int j = 0; j < l2; j++) {
                    res = res + Math.abs(s2.charAt(j) - s1.charAt(i + j));
                }
            }
            System.out.println(res);
        }
    }
}
