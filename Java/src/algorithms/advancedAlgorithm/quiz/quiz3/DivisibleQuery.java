package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
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
