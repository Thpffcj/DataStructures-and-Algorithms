package algorithms.advancedAlgorithm.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/12.
 */
public class APlusBForInputOutputPractice8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            int result = 0;
            for (int j = 0; j < number; j++) {
                result += scanner.nextInt();
            }
            System.out.println(result);
            if (i != n - 1) {
                System.out.println();
            }
        }
    }
}
