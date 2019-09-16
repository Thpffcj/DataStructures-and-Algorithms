package algorithms.advancedAlgorithm;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/12.
 */
public class APlusBForInputOutputPractice2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            System.out.println(a + b);
        }
    }
}
