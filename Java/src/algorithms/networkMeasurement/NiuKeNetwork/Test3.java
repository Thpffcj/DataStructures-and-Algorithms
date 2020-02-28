package algorithms.networkMeasurement.NiuKeNetwork;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/27.
 */
public class Test3 {

    // 10%
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int maxX = 0;
        int maxY = 0;
        int position = 0;
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0 ; i < n; i++) {
           x[i] = sc.nextInt();
           y[i] = sc.nextInt();
           if (x[i] > maxX) {
               maxX = x[i];
               maxY = y[i];
               position = i;
           }
            if (x[i] == maxX && y[i] > maxY) {
                maxX = x[i];
                maxY = y[i];
                position = i;
            }
        }

        result += maxX + maxY;
        for (int i = 0; i < n; i++) {
            if (i != position && result > x[i] && y[i] - x[i] > 0) {
                result += y[i] - x[i];
            }
        }
        System.out.println(result);
    }
}
