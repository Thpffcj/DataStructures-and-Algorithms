package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */
public class PingDuoDuo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int[] res = new int[100];
            for (int i = 0; i < n; i++) {
                int low = sc.nextInt();
                int high = sc.nextInt();
                for (int j = low + 50; j <= high + 50; j++) {
                    res[j]++;
                }
            }
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < res.length; i++) {
                if (res[i] >= k) {
                    min = i - 50;
                    break;
                }
            }
            for (int i = res.length - 1; i >= 0; i--) {
                if (res[i] >= k) {
                    max = i - 50;
                    break;
                }
            }
            if (min == Integer.MIN_VALUE) {
                System.out.println("error");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
