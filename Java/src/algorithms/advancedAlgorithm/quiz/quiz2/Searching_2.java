package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * Description
 * Find the count of numbers less than N having exactly 9 divisors
 * 1<=T<=1000,1<=N<=10^12
 *
 * Input
 * First Line of Input contains the number of testcases. Only Line of each testcase contains the number of
 * members N in the rival gang.
 *
 * Output
 * Print the desired output.
 *
 * Sample Input 1
 * 2
 * 40
 * 5
 *
 * Sample Output 1
 * 1
 * 0
 */
public class Searching_2 {

    // TODO
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            long n = scan.nextLong();

            int count = countNumbers(n);
            if (n >= Math.pow(29, 8)) {
                count -= 2;
            }
            System.out.println(count);
        }
    }

    public static int countNumbers(long n) {
        int result = 0;

        int limit = (int) Math.sqrt(n);

        // Sieve array
        int prime[] = new int[limit + 1];

        // initially prime[i] = i
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        // use seive concept to store the
        // first prime factor of every number
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                // mark all factors of i
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }

        // check for all numbers if they can be
        // expressed in form p*q
        for (int i = 2; i <= limit; i++) {
            // p prime factor
            int p = prime[i];

            // q prime factor
            int q = prime[i / prime[i]];

            // if both prime factors are different
            // if p*q<=n and q!=
            if (p * q == i && q != 1 && p != q) {
                result += 1;
            } else if (prime[i] == i) {

                // Check if it can be expressed as p^8
                if (Math.pow(i, 8) <= n) {
                    result += 1;
                }
            }
        }
        return result;
    }
}
//3
//40
//5
//1000