package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/9.
 */
public class JingDong1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int res = 0;
            for (int i = 0; i < line.length(); i++) {
                res++;
                for (int j = 1; j < line.length(); j++) {
                    String s = "" + line.charAt(i);
                    for (int k = j; i + k < line.length(); k += j) {
                        s = s + line.charAt(i + k);
                        if (isP(s)) {
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static boolean isP(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
