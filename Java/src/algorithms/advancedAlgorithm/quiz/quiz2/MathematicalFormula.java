package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * Description
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 *
 * Input
 * The first line of input consists number of the test cases. The following T lines consist of 3 numbers
 * each separated by a space and in the following order:A B C'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5
 *
 * Output
 * In each separate line print the modular exponent of the given numbers in the test case.
 *
 * Sample Input 1
 * 3
 * 3 2 4
 * 10 9 6
 * 450 768 517
 *
 * Sample Output 1
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
