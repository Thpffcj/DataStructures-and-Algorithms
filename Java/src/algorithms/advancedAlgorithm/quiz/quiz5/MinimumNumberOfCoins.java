package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * Given the list of coins of distinct denominations and total amount of money. Output the minimum number of coins
 * required to make up that amount. Output -1 if that money cannot be made up using given coins. You may assume
 * that there are infinite numbers of coins of each type.
 *
 * Input
 * The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each
 * cases begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins
 * and total amount of money respectively. The second line contains N space-separated integers A1, A2, ..., AN
 * denoting the values of coins.
 *
 * Constraints:1<=T<=30，1<=n<=100，1<=Ai<=1000，1<=amount<=100000
 *
 * Output
 * Print the minimum number of coins required to make up that amount or return -1 if it is impossible to make that
 * amount using given coins.
 *
 * Sample Input 1
 * 2
 * 3 11
 * 1 2 5
 * 2 7
 * 2 6
 *
 * Sample Output 1
 * 3
 * -1
 */
public class MinimumNumberOfCoins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String[] infos = sc.nextLine().split(" ");
            int n = Integer.parseInt(infos[0]);
            int amount = Integer.parseInt(infos[1]);

            String[] line = sc.nextLine().split(" ");
            int[] coin = new int[n];
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(line[i]);
            }

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, 10000);
            for (int i = 0; i < n; i++) {
                dp[coin[i]] = 1;
            }

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + coin[j] <= amount) {
                        dp[i + coin[j]] = Math.min(dp[i] + 1, dp[i + coin[j]]);
                    }
                }
            }

            if (dp[amount] >= 10000) {
                dp[amount] = -1;
            }
            System.out.println(dp[amount]);

            numbers--;
        }
    }
}
