package algorithms.advancedAlgorithm;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/12.
 */
public class APlusBForInputOutputPractice4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            int result = 0;
            for (int i = 0; i < number; i++) {
                result += scanner.nextInt();
            }
            System.out.println(result);
        }
    }
}
