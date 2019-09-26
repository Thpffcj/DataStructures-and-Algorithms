package algorithms.advancedAlgorithm;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/26.
 */

/**
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 */
public class InvertedNumber {

    public static void find(int[] digit) {
        int num = 0;
        for (int i = 0; i < digit.length - 1; i++) {
            for (int j = i + 1; j < digit.length; j++) {
                if (digit[j] < digit[i]) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nummber = sc.nextInt();
        for (int i = 0; i < nummber; i++) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int j = 0; j < n; j++) {
                digit[j] = sc.nextInt();
            }
            find(digit);
        }
    }
}
