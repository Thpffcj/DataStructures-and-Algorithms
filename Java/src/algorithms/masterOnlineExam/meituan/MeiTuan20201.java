package algorithms.masterOnlineExam.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/12.
 */
public class MeiTuan20201 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        char[][] road = new char[n][2];
        for (int j = 0; j < n; j++) {
            road[j][1] = line1.charAt(j);
        }
        for (int j = 0; j < n; j++) {
            road[j][0] = line2.charAt(j);
        }

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j >= 0; j--) {
                if (road[i][j] != 'X') {
                    if (i == 0 && j == 1) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j];
                    } else if (j == 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j= 0; j < 2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        if (dp[n - 1][0] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1][0]);
        }
    }
}
