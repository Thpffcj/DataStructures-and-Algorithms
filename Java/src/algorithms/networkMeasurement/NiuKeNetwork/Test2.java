package algorithms.networkMeasurement.NiuKeNetwork;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/27.
 */
public class Test2 {

    // 60%
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digit = new int[3 * n];
        for (int i = 0 ; i < n; i++) {
            digit[3 * i] = sc.nextInt();
            digit[3 * i + 1] = sc.nextInt();
            digit[3 * i + 2] = sc.nextInt();
        }

        Arrays.sort(digit);
        int result = 0;
        for (int i = n; i < 3 * n; i += 2) {
            result += digit[i];
        }
        System.out.println(result);
    }
}
