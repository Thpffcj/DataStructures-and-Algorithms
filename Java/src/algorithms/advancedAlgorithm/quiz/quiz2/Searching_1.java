package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * 2
 * 2 4
 * 10 10 10 10
 * 2 4
 * 10 20 30 40
 */
public class Searching_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String[] kAndN = sc.nextLine().split(" ");
            String[] line = sc.nextLine().split(" ");
            int[] digit = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                digit[i] = Integer.parseInt(line[i]);
            }
            int result= findMax(digit, Integer.parseInt(kAndN[1]), Integer.parseInt(kAndN[0]));
            System.out.println(result);
        }
    }

    // function to calculate sum between two indices
// in array
    static int sum(int arr[], int from, int to)
    {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    // bottom up tabular dp
    static int findMax(int arr[], int n, int k)
    {
        // initialize table
        int dp[][] = new int[k+1][n+1];

        // base cases
        // k=1
        for (int i = 1; i <= n; i++)
            dp[1][i] = sum(arr, 0, i - 1);

        // n=1
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        // 2 to k partitions
        for (int i = 2; i <= k; i++) { // 2 to n boards
            for (int j = 2; j <= n; j++) {

                // track minimum
                int best = Integer.MAX_VALUE;

                // i-1 th separator before position arr[p=1..j]
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum(arr, p, j - 1)));

                dp[i][j] = best;
            }
        }

        // required
        return dp[k][n];
    }
}
