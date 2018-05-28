package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/19.
 */
public class AiQiYi2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] numbers = sc.nextLine().split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);
            int max = Math.max(Math.max(a, b), c);
            int total = a + b + c;
            while ((max * 3 - total) % 2 != 0) {
                max++;
            }
            int res = (max * 3 - total) / 2;
            System.out.println(res);
        }
    }
}
