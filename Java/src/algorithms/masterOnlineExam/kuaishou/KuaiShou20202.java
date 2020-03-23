package algorithms.masterOnlineExam.kuaishou;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/22.
 */
public class KuaiShou20202 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int[] digit = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                digit[i] = Integer.parseInt(line[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digit.length; i++) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (digit[i] < digit[j]) {
                        count++;
                    }
                }
                if (count == 1) {
                    sb.append(i + " ");
                }
            }
            if (sb.toString().equals("")) {
                System.out.println(-1);
            } else {
                System.out.println(sb.substring(0, sb.length() - 1));
            }
        }
    }
}
