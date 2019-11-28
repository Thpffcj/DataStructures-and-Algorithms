package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description A班
 * Given an array of positive integers and many queries for divisibility. In every query Q[i], we are given an
 * integer K , we need to count all elements in the array which are perfectly divisible by K.
 *
 * Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 * Each test case consists of three lines. First line of each test case contains two integers N & M, second line
 * contains N space separated array elements and third line contains M space separated queries.
 *
 * Output
 * For each test case,In new line print the required count for each query Q[i].
 *
 * Sample Input 1
 * 2
 * 6 3
 * 2 4 9 15 21 20
 * 2 3 5
 * 3 2
 * 3 4 6
 * 2 3
 *
 * Sample Output 1
 * 3 3 2
 * 2 2
 */
public class DivisibleQuery {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] digits1 = new int[n];
            for (int i = 0; i < n; i++) {
                digits1[i] = sc.nextInt();
            }

            int[] digits2 = new int[m];
            for (int i = 0; i < m; i++) {
                digits2[i] = sc.nextInt();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits2.length; i++) {
                int result = 0;
                for (int j = 0; j < digits1.length; j++) {
                    if (digits1[j] % digits2[i] == 0) {
                        result++;
                    }
                }
                sb.append(result).append(" ");
            }

            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
