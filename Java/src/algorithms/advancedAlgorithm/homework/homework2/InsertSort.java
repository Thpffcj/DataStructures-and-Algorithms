package algorithms.advancedAlgorithm.homework.homework2;

/**
 * Created by thpffcj on 2019/10/26.
 */

import java.util.Scanner;

/**
 * Description
 * 实现插入排序。
 * <p>
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行代表一个数组，其中的值用空格隔开，第一个值表示数组的长度。
 * <p>
 * Output
 * 输出排序的数组，用空格隔开，末尾不要空格。
 * <p>
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * <p>
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */
public class InsertSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int[] digits = new int[line.length];

            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(line[i]);
            }

            for (int i = 1; i < digits.length; i++) {
                int position = i;
                for (int j = 1; j <= i; j++) {
                    if (digits[i] < digits[i - j]) {
                        position = i - j;
                    }
                }
                int temp = digits[i];
                for (int j = i; j > position; j--) {
                    digits[j] = digits[j - 1];
                }
                digits[position] = temp;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                sb.append(digits[i]).append(" ");
            }

            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
//2
//13 24 3 56 34 3 78 12 29 49 84 51 9 100
//13 24 3 56 34 3 78 12 29 49 84 51 9 100