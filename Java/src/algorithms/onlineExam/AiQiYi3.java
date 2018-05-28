package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/19.
 */

//3 5
//0 3
//0 3
//0 3
public class AiQiYi3 {

    public static long res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] number = new int[n][2];
            for (int i = 0; i < n; i++) {
                number[i][0] = sc.nextInt();
                number[i][1] = sc.nextInt();
            }
            long result = ways(0, number, m) - 1;
            System.out.println(result);
        }
    }

    public static long ways(int pos, int[][] number, int r) {
        if (r < 0 || pos > number.length) {
            return 0;
        }
        if (pos == number.length) {
            if (r == 0 ) {
                return 1;
            } else {
                return 0;
            }
        }
        int min = number[pos][0];
        int max = number[pos][1];
        for (int i = min; i <= max; i++) {
            long temp = ways(pos + 1, number, r - i);
            if (temp == 1) {
                res = res + 1;
                System.out.println(res);
            }
        }
        return res;
    }
}
