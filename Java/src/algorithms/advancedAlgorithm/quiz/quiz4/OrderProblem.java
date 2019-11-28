package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.Scanner;

/**
 * Description A班
 * Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders.
 * The amount of tips may differ when handled by different waiters, if Rahul takes the ith order, he would
 * be tipped Ai rupees and if Ankit takes this order, the tip would be Bi rupees.In order to maximize the
 * total tip value they decided to distribute the order among themselves. One order will be handled by one
 * person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take
 * more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the
 * orders can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money
 * after processing all the orders.
 * <p>
 * Input
 * • The first line contains one integer, number of test cases.
 * <p>
 * • The second line contains three integers N, X, Y.
 * <p>
 * • The third line contains N integers. The ith integer represents Ai.
 * <p>
 * • The fourth line contains N integers. The ith integer represents Bi.
 * <p>
 * <p>
 * Output
 * Print a single integer representing the maximum tip money they would receive.
 * <p>
 * Sample Input 1
 * 1
 * 5 3 3
 * 1 2 3 4 5
 * 5 4 3 2 1
 * <p>
 * Sample Output 1
 * 21
 */
public class OrderProblem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {

            int N = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int A[] = new int[N];
            int B[] = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                B[i] = sc.nextInt();
            }

            // dp[i][j] 代表i个任务分配给第一个人，j个任务分配给第2个任务
            int dp[][] = new int[X + 1][Y + 1];

            for (int i = 1; i <= X; i++) {
                dp[i][0] = A[i - 1] + dp[i - 1][0];
            }
            for (int i = 1; i <= Y; i++) {
                dp[0][i] = B[i - 1] + dp[0][i - 1];
            }

            for (int i = 1; i <= X; i++) {
                for (int j = 1; j <= Y; j++) {
                    if (i + j <= N) {
                        // 将第i+j个任务分配给第一个人
                        int op1 = A[i + j - 1] + dp[i - 1][j];
                        // 将第i+j个任务分配给第二个人
                        int op2 = B[i + j - 1] + dp[i][j - 1];

                        dp[i][j] = Math.max(op1, op2);
                    } else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            System.out.println(dp[X][Y]);

            numbers--;
        }
    }
}
