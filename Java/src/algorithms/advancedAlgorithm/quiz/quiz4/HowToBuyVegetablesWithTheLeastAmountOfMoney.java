package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.Scanner;

/**
 * Description
 * Rahul wanted to purchase vegetables mainly brinjal, carrot and tomato. There are N different vegetable
 * sellers in a line. Each vegetable seller sells all three vegetable items, but at different prices.
 * Rahul, obsessed by his nature to spend optimally, decided not to purchase same vegetable from adjacent
 * shops. Also, Rahul will purchase exactly one type of vegetable item (only 1 kg) from one shop. Rahul
 * wishes to spend minimum money buying vegetables using this strategy. Help Rahul determine the minimum
 * money he will spend.
 *
 * Input
 * First line indicates number of test cases T. Each test case in its first line contains N denoting the number of vegetable sellers in Vegetable Market. Then each of next N lines contains three space separated integers denoting cost of brinjal, carrot and tomato per kg with that particular vegetable seller.
 *
 * Output
 * For each test case, output the minimum cost of shopping taking the mentioned conditions into account in a separate line.
 *
 * Constraints:1 <= T <= 101 <= N <= 100000 Cost of each vegetable(brinjal/carrot/tomato) per kg does not exceed 10^4
 *
 * Sample Input 1
 * 1
 * 3
 * 1 50 50
 * 50 50 50
 * 1 50 50
 *
 * Sample Output 1
 * 52
 */
public class HowToBuyVegetablesWithTheLeastAmountOfMoney {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            int n = Integer.parseInt(sc.nextLine());

            int[][] dp = new int[n][3];

            String[] info = sc.nextLine().split(" ");
            dp[0][0] = Integer.parseInt(info[0]);
            dp[0][1] = Integer.parseInt(info[1]);
            dp[0][2] = Integer.parseInt(info[2]);

            for (int i = 1; i < n; i++) {
                int[] digit = new int[3];

                String[] digits = sc.nextLine().split(" ");
                digit[0] = Integer.parseInt(digits[0]);
                digit[1] = Integer.parseInt(digits[1]);
                digit[2] = Integer.parseInt(digits[2]);

                dp[i][0] = digit[0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = digit[1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = digit[2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            int result = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

            System.out.println(result);

            numbers--;
        }
    }
}
