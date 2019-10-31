package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * 2
 * THIS IS A TEST TEXT,TEST
 * AABAACAADAABAABA,AABA
 *
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
