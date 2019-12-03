package algorithms.advancedAlgorithm.homework.homework2;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/27.
 */

/**
 * 非递归合并排序
 * Description
 * 合并（归并）排序的核心思想是：每次从中间位置将数组分组再分别排序。请实现其非递归方案。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 * Sample Input 1
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 *
 * Sample Output 1
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */
public class NonRecursiveMergeSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int[] digits = new int[line.length - 1];

            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(line[i + 1]);
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
