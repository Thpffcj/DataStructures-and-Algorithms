package algorithms.masterOnlineExam.kuaishou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/22.
 */
public class KuaiShou20204 {

    // 6.67%
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long[][] digit = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                digit[i][j] = sc.nextLong();
            }
        }

        boolean[][] visited = new boolean[n - a + 1][m - b + 1];
        long[][] energy = new long[n - a + 1][m - b + 1];

        for (int i = 0; i <= n - a; i++) {
            for (int j = 0; j <= m - b; j++) {
                List<Long> list = new ArrayList<>();
                for (int p = 0; p < a; p++) {
                    for (int q = 0; q < b; q++) {
                        list.add(digit[i + p][j + q]);
                    }
                }
                Collections.sort(list);
                long e = 0;
                long first = list.get(0);
                for (int k = 1; k < list.size(); k++) {
                    e += list.get(k) - first;
                }
                energy[i][j] = e;
            }
        }

        List<String> list = new ArrayList<>();
        while (true) {
            long min = Integer.MAX_VALUE;
            int col = -1;
            int row = -1;
            for (int i = 0; i <= n - a; i++) {
                for (int j = 0; j <= m - b; j++) {
                    if (!visited[i][j] && energy[i][j] < min) {
                        col = i;
                        row = j;
                        min = energy[i][j];
                    }
                }
            }

            if (col == -1) {
                break;
            }


            visited[col][row] = true;

            list.add((col + 1) + " " + (row + 1) + " " + min);
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
