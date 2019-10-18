package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * 3
 * 3 2 4
 * 10 9 6
 * 450 768 517
 * <p>
 * 1
 * 4
 * 34
 */
public class MathematicalFormula {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String[] line = sc.nextLine().split(" ");

            long a = Long.parseLong(line[0]);
            long b = Long.parseLong(line[1]);
            long c = Long.parseLong(line[2]);

            System.out.println(fastPow(a, b, c));
        }
    }

    private static long fastPow(long a, long b, long c) {
        long ans = 1;
        do {
            if (b % 2 == 1) {
                ans = ans * a % c;
            }
            b = b >> 1;
            a = a * a % c;
        } while (b != 0);
        return ans;
    }
}
