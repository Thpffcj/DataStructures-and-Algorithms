package algorithms.masterOnlineExam.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/12.
 */
public class MeiTuan20205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] digit = new int[N];
        for (int i = 0; i < N; i++) {
            digit[i] = sc.nextInt();
        }

        int fenmu = (int) Math.pow(2, N);
        int[] fenzi = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            fenzi[i] = find(N, i);
        }

        long x = 998244353;
        long[] result = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            int mul = 1;
            while ((mul * x + fenzi[i]) % fenmu != 0) {
                mul++;
            }
            result[i] = (mul * x + fenzi[i]) / fenmu;
        }
        for (int i = 0; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int find(int N, int c) {
        if (c == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < c; i++) {
            result *= N;
            N--;
        }
        return result / c;
    }
}
