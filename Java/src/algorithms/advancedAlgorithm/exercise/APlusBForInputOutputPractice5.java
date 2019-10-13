package algorithms.advancedAlgorithm.exercise;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/12.
 */
public class APlusBForInputOutputPractice5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            int n = scanner.nextInt();

            int result = 0;
            for (int j = 0; j < n; j++) {
                result += scanner.nextInt();
            }
            System.out.println(result);
        }
    }
}
