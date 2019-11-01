package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */
public class PrimeNumberAndroblem {

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
