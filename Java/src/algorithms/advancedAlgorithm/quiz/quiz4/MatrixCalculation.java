package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.Scanner;

/**
 * Description
 * Let's define a Series Whose recurrence formula is as follows :
 * C(n)= 3C(i-1) + 4C(i-2) + 5C(i-3) + 6C(i-4)
 *
 * C(0)= 2
 * C(1)= 0
 * C(2)= 1
 * C(3)= 7
 *
 * Now based on this Series a Matrix Mi,j of size nn is to be formed.The top left cell is(1,1) and the bottom
 * right corner is (n,n). Each cell (i,j) of the Matrix contains either 1 or 0. If C( (i*j)^3 ) is odd, Mi,j is 1,
 * otherwise, it's 0.Count the total number of ones in the Matrix.
 *
 * Input
 * First Line Of the input will contain an integer 'T'- the number of test cases . Each of the next 'T' lines
 * consists of an integer 'n'.-denoting the size of the matrix.
 *
 * Constraints :
 * 1 ≤ T ≤ 1000
 * 1 ≤ n ≤ 1000
 *
 * Output
 * For each test case, output a single Integer -the taste value fo the dish of size-n*n.
 *
 * Sample Input 1
 * 1
 * 2
 *
 * Sample Output 1
 * 0
 */
public class MatrixCalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int max = (int) Math.pow((n * n), 3);

            int[] dp = new int[max + 1];
            dp[0] = 2;
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 7;
            for (int i = 4; i <= max; i++) {
                dp[i] = 3 * dp[i - 1] + 4 * dp[i - 2] + 5 * dp[i - 3] + 6 * dp[i - 4];
                String s = String.valueOf(dp[i]);
                dp[i] = Integer.parseInt(s.substring(s.length() - 1));
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int c = dp[(int) Math.pow((i * j), 3)];
                    if (c % 2 != 0) {
                        result += 1;
                    }
                }
            }
            result = result * 2;
            for (int i = 1; i <= n; i++) {
                int c = dp[(int) Math.pow((i * i), 3)];
                if (c % 2 != 0) {
                    result += 1;
                }
            }

            System.out.println(result);

            numbers--;
        }
    }
}
