package algorithms.networkMeasurement.NiuKeNetwork;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/27.
 */
public class Test1 {

    // 30%
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digit = new int[n];
        for (int i = 0 ; i < n; i++) {
            digit[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
           if (digit[i] <= digit[i + 1]) {
               while (i < n - 1 && digit[i] <= digit[i + 1]) {
                   i++;
               }
               result++;
           }

           if (i < n - 1 && digit[i] >= digit[i + 1]) {
               while (i < n - 1 && digit[i] >= digit[i + 1]) {
                   i++;
               }
               result++;
           }
        }
        System.out.println(result);
    }
}
