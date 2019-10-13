package algorithms.advancedAlgorithm.homework.homework1;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * 找到给定数组的给定区间内的第K小的数值。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个数用空格隔开；第二行是区间（第几个数到第几个数，两头均包含），两个值用空格隔开；第三行为K值。
 * Output
 * 结果。
 *
 * 1
 * 1 2 3 4 5 6 7
 * 3 5
 * 2
 *
 * 4
 */
public class IntervalKMinimum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            int[] digit = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            String[] line = sc.nextLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int k = Integer.parseInt(sc.nextLine());

            int[] newDigit = Arrays.copyOfRange(digit, start - 1, end);
            Arrays.sort(newDigit);

            System.out.println(newDigit[k - 1]);
        }
    }
}

