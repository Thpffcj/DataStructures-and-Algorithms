package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/19.
 */
public class AiQiYi1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String res = "";
            int pos = findMax(line);
            while (pos != -1) {
                res = res + line.charAt(pos);
                line = line.substring(pos + 1);
                pos = findMax(line);
            }
            System.out.println(res);
        }
    }

    public static int findMax(String line) {
        int res = -1;
        int max = 'a' - 1;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) > max) {
                max = line.charAt(i);
                res = i;
            }
        }
        return res;
    }
}
