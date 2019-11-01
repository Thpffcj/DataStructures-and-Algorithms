package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * 2
 * 3
 * abc bcd cdf
 * 4
 * ab bc cd da
 *
 * 0
 * 1
 */
public class CanItBeLooped {

    public static boolean findOut = false;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            findOut = false;
            int n = Integer.parseInt(sc.nextLine());

            String[] line = sc.nextLine().split(" ");
            boolean[] flag = new boolean[line.length];
            for (int i = 0; i < line.length; i++) {
                line[i] = line[i].substring(0, 1) + line[i].substring(line[i].length() - 1);
//                System.out.println(line[i]);
            }

            findAll("", line, flag);
            if (findOut) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void findAll(String s, String[] line, boolean[] flag) {

        if (line.length == 1) {
            if (line[0].charAt(0) == line[0].charAt(line[0].length() - 1)) {
                findOut = true;
                return;
            } else {
                return;
            }
        }

        if (s.length() == line.length * 2) {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                findOut = true;
            }
            return;
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
