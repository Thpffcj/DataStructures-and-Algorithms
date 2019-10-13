package algorithms.advancedAlgorithm.exercise;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/12.
 */
public class APlusBForInputOutputPractice6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int result = 0;
            for (int i = 0; i < number; i++) {
                result += scanner.nextInt();
            }
            System.out.println(result);
        }
    }
}
