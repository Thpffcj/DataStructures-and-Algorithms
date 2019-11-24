package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */
public class InfiniteRecursiveStringQuery {

    // TODO
    public static char[] digits =  new char[]{'1', '2', '3', '4', '5', '$', '5', '4', '3', '2', '1'};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            long n = sc.nextLong();

            boolean isDollar = false;
            long end = 11;
            int round = 1;
            while (n > end) {
                round++;
                if (n < end + round) {
                    System.out.println("$");
                    isDollar = true;
                }
                end = end * 2 + round;
            }

            if (!isDollar) {
                while (n > 11) {
                    n = (int) (n - ((n - round) / 2 + round));
                    round--;
                }
                System.out.println(digits[(int) (n - 1)]);
            }
        }
    }

}
