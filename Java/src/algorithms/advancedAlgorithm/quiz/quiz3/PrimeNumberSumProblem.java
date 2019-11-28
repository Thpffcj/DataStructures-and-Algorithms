package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description B班
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * There are several combinations possible. Print only first such pair.
 *
 * NOTE: A solution will always exist, read Goldbach’s conjecture.Also, solve the problem in linear time
 * complexity, i.e., O(n).
 *
 * Input
 * The first line contains T, the number of test cases. The following T lines consist of a number each, for
 * which we'll find two prime numbers.Note: The number would always be an even number.
 *
 * Output
 * For every test case print two prime numbers space separated, such that the smaller number appears first.
 * Answer for each test case must be in a new line.
 *
 * Sample Input 1
 * 5
 * 74
 * 1024
 * 66
 * 8
 * 9990
 *
 * Sample Output 1
 * 3 71
 * 3 1021
 * 5 61
 * 3 5
 * 17 9973
 */
public class PrimeNumberSumProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numbers = in.nextInt();

        for (int i = 0; i < numbers; i++) {
            int n = in.nextInt();
            findPrime(n);
        }
    }

    public static void findPrime(int n) {

        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int k = 2 * p; k <= n; k += p) {
                    prime[k] = false;
                }
            }
        }

        ArrayList<Integer> rs = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                rs.add(i);
            }
        }

        for (int i = 0; i < rs.size(); ++i) {
            int first = rs.get(i);
            int second = n - first;
            if (prime[first] && prime[second]) {
                System.out.println(first + " " + second);
                break;
            }
        }
    }
}
