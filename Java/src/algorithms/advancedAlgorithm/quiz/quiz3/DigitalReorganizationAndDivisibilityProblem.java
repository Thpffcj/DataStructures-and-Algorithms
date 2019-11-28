package algorithms.advancedAlgorithm.quiz.quiz3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description B班
 * Babul’s favourite number is 17. He likes the numbers which are divisible by 17. This time what he does is that
 * he takes a number N and tries to find the largest number which is divisible by 17, by rearranging the digits.
 * As the number increases he gets puzzled with his own task. So you as a programmer have to help him to
 * accomplish his task.Note: If the number is not divisible by rearranging the digits, then print “Not Possible”.
 * N may have leading zeros.
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases. Each of the next T lines contains
 * the number N.
 *
 * Output
 * For each test case in a new line print the desired output.
 *
 * Sample Input 1
 * 4
 * 17
 * 43
 * 15
 * 16
 *
 * Sample Output 1
 * 17
 * 34
 * 51
 * Not Possible
 */
public class DigitalReorganizationAndDivisibilityProblem {

//    public static List<String> list = new ArrayList<>();
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int numbers = Integer.parseInt(sc.nextLine());
//        for (int number = 0; number < numbers; number++) {
//            list = new ArrayList<>();
//            String digit = sc.nextLine();
//
//            boolean[] flag = new boolean[digit.length()];
//            findAll(digit, "", digit.length(), flag);
//
//            int max = 0;
//            for (int i = 0; i < list.size(); i++) {
//                if (Integer.parseInt(list.get(i)) % 17 == 0) {
//                    if (Integer.parseInt(list.get(i)) > max) {
//                        max = Integer.parseInt(list.get(i));
//                    }
//                }
//            }
//            if (max == 0) {
//                System.out.println("Not Possible");
//            } else {
//                System.out.println(max);
//            }
//        }
//    }
//
//    public static void findAll(String s, String target, int length, boolean[] flag) {
//
//        if (target.length() == length) {
//            list.add(target);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            if (!flag[i]) {
//                flag[i] = true;
//                target = target + s.charAt(i);
//                findAll(s, target, length, flag);
//                target = target.substring(0, target.length() - 1);
//                flag[i] = false;
//            }
//        }
//    }

    static int max = 0;
    static HashMap<Integer, Integer> hm;

    public static void rec(String s, String n) {
        if (s.length() == n.length() && Integer.parseInt(s) % 17 == 0) {
            if (Integer.parseInt(s) > max) {
                max = Integer.parseInt(s);
            }
            return;
        }
        for (int i = 0; i < n.length(); i++) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
                rec(s + n.charAt(i), n);
                hm.remove(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {

            max = 0;
            String n = sc.nextLine().trim();

            hm = new HashMap<>();
            rec("", n);
            if (max == 0) {
                System.out.println("Not Possible");
            } else {
                System.out.println(max);
            }
        }
    }
}
