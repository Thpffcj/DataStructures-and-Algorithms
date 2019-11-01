package algorithms.advancedAlgorithm.quiz.quiz3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by thpffcj on 2019/10/31.
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
