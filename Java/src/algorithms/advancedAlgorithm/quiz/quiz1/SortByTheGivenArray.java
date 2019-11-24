package algorithms.advancedAlgorithm.quiz.quiz1;

/**
 * Created by thpffcj on 2019/9/26.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same
 * as those in A2. For the elements not present in A2. Append them at last in sorted order. It is also given that
 * the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all
 * distinct elements.
 *
 * Input:A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8} A2[] = {2, 1, 8, 3}
 * Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
 *
 * Since 2 is present first in A2[], all occurrences of 2s should appear first in A[], then all occurrences 1s as
 * 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3. Finally we print all those
 * elements of A1[] that are not present in A2[]
 *
 * Constraints:1 ≤ T ≤ 501 ≤ M ≤ 501 ≤ N ≤ 10 & N ≤ M1 ≤ A1[i], A2[i] ≤ 1000
 */
public class SortByTheGivenArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int first[] = new int[m];
            int second[] = new int[n];
            for (int j = 0; j < m; j++) {
                first[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                second[j] = scanner.nextInt();
            }

            int result[] = new int[m];
            int position = 0;
            for (int j = 0; j < n; j++) {
                int digit = second[j];
                for (int k = 0; k < m; k++) {
                    if (first[k] == digit) {
                        result[position] = digit;
                        first[k] = -999;
                        position++;
                    }
                }
            }
            Arrays.sort(first);
            for (int j = 0; j < m; j++) {
                if (first[j] != -999) {
                    result[position] = first[j];
                    position++;
                }
            }
            for (int j = 0; j < m - 1; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println(result[m - 1]);
        }
    }
}
