package algorithms.advancedAlgorithm.quiz.quiz3;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description B班
 * Given an array of strings A[ ], determine if the strings can be chained together to form a circle. A string X
 * can be chained together with another string Y if the last character of X is same as first character of Y. If
 * every string of the array can be chained, it will form a circle. For example, for the array
 * arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as
 * "for", "rig", "geek" and "kaf".
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 * The first line of each test case contains a positive integer N, denoting the size of the array.
 * The second line of each test case contains a N space seprated strings, denoting the elements of the array A[ ].
 *
 * 1 <= T
 * 0 < N
 * 0 < A[i]
 *
 * Output
 * If chain can be formed, then print 1, else print 0.
 *
 * Sample Input 1
 * 2
 * 3
 * abc bcd cdf
 * 4
 * ab bc cd da
 *
 * Sample Output 1
 * 0
 * 1
 */
public class CanItBeLooped {

    public static boolean findOut = false;

    // TODO String
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            findOut = false;
            int n = Integer.parseInt(sc.nextLine());

            String[] line = sc.nextLine().split(" ");
            boolean[] flag = new boolean[line.length];
            for (int i = 0; i < line.length; i++) {
                line[i] = line[i].substring(0, 1) + line[i].substring(line[i].length() - 1);
            }

            if (line.length == 1) {
                if (line[0].charAt(0) == line[0].charAt(line[0].length() - 1)) {
                    findOut = true;
                }
            } else {
                findAll("", line, flag);
            }

            if (findOut) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            numbers--;
        }
    }

    public static void findAll(String s, String[] line, boolean[] flag) {

        if (s.length() == line.length * 2) {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                findOut = true;
                return;
            }
        }

        for (int i = 0; i < line.length; i++) {
            if (!flag[i]) {
                if (s.equals("") || s.charAt(s.length() - 1) == line[i].charAt(0)) {
                    s = s + line[i];
                    flag[i] = true;
                    findAll(s, line, flag);
                    flag[i] = false;
                    s = s.substring(0, s.length() - 2);
                }
            }
        }
    }
}
