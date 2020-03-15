package algorithms.masterOnlineExam.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/12.
 */
public class MeiTuan20203 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        int[] digit = new int[n];

        long position = R - L + 1;
        long result = (long) (Math.pow(position, n) % 1000000007);

        System.out.println(result);
    }

}
