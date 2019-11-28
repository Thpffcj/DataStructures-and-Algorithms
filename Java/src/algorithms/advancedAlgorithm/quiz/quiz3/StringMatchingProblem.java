package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description A班
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that
 * prints all occurrences of pat[] in txt[]. You may assume that n > m.
 *
 * Input
 * 输入第一行是用例个数，后面一行表示一个用例；用例包括两部分，第一部分为给定文本，第二部分为搜索串，两部分使用","隔开。
 *
 * Output
 * 每一个用例输出一行，每行按照找到的位置先后顺序排列，使用空格隔开。
 *
 * Sample Input 1
 * 2
 * THIS IS A TEST TEXT,TEST
 * AABAACAADAABAABA,AABA
 *
 * Sample Output 1
 * 10
 * 0 9 12
 */
public class StringMatchingProblem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String[] line = sc.nextLine().split(",");
            String s = line[0];
            String target = line[1];

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= s.length() - target.length(); i++) {
                int result = findTarget(s, target, i, target.length());
                if (result != -1) {
                    sb.append(result).append(" ");
                }
            }
            if (sb.length() > 0) {
                System.out.println(sb.substring(0, sb.length() - 1));
            } else {
                System.out.println();
            }
        }
    }

    public static int findTarget(String s, String target, int position, int length) {

        for (int i = 0; i < length; i++) {
            if (s.charAt(position + i) != target.charAt(i)) {
                return -1;
            }
        }
        return position;
    }
}
