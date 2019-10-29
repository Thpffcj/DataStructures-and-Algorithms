package algorithms.advancedAlgorithm.homework.homework2;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/27.
 */
public class NonRecursiveMergeSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int[] digits = new int[line.length];

            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(line[i]);
            }

            for (int sz = 1; sz < digits.length; sz += sz) {
                for (int lo = 0; lo < digits.length - sz; lo += sz + sz) {
                    merge(digits, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, digits.length - 1));
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                sb.append(digits[i]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    public static void merge(int[] num, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;

        int[] current = new int[right + 1];
        for (int k = left; k <= right; k++) {
            current[k] = num[k];
        }

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                num[k] = current[j];
                j++;
            } else if (j > right) {
                num[k] = current[i];
                i++;
            } else if (current[i] <= current[j]) {
                num[k] = current[i];
                i++;
            } else {
                num[k] = current[j];
                j++;
            }
        }
    }
}
