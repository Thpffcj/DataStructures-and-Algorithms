package algorithms.masterOnlineExam.zhaohang;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/27.
 */
public class ZhaoHang20201 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = sc.nextInt();
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (digit[i] >= 2) {
                    count++;
                }
                if (digit[i] == 1) {
                    count++;
                    digit[i]--;
                }
            }
            boolean canFind = false;
            for (int i = 0; i < n; i++) {
                if (digit[i] >= 2) {
                    count++;
                    canFind = true;
                    break;
                }
            }

            if (canFind) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
        }
    }
}
