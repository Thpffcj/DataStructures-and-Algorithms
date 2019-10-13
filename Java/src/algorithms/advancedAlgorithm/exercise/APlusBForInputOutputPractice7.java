package algorithms.advancedAlgorithm.exercise;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/12.
 */
public class APlusBForInputOutputPractice7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            System.out.println(a + b);
            if (scanner.hasNext()) {
                System.out.println();
            }
        }
    }
}
