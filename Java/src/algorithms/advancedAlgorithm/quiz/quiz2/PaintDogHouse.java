package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * Description
 * Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An].
 * He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
 * The problem is to find the minimum time to get this job done under the constraints that any painter
 * will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but
 * not board {2, 4, 5}.
 * Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500
 *
 * Input
 * The first line consists of a single integer T, the number of test cases. For each test case, the first
 * line contains an integer k denoting the number of painters and integer n denoting the number of boards.
 * Next line contains n- space separated integers denoting the size of boards.
 *
 * Output
 * For each test case, the output is an integer displaying the minimum time for painting that house.
 *
 * Sample Input 1
 * 2
 * 2 4
 * 10 10 10 10
 * 2 4
 * 10 20 30 40
 *
 * Sample Output 1
 * 20
 * 60
 */
public class Searching_1 {

    // TODO 考试
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {

            String[] line = sc.nextLine().split(" ");
            int k = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);

            String[] infos = sc.nextLine().split(" ");
            int[] digit = new int[infos.length];
            for (int i = 0; i < infos.length; i++) {
                digit[i] = Integer.parseInt(infos[i]);
            }

            int result= findMax(digit, n, k);
            System.out.println(result);

            numbers--;
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
