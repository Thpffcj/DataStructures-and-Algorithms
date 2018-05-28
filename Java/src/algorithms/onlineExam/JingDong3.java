package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/9.
 */
public class JingDong3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                if (isI(line)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static boolean isI(String s) {
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                flag++;
            } else if (s.charAt(i) == ')') {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        if (flag != 1) {
            return false;
        }
        return true;
    }
}
