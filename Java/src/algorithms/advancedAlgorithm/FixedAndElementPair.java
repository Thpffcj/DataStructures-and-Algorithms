package algorithms.advancedAlgorithm;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入第一行是数组，每一个数用空格隔开；第二行是数字和。
 * Output
 * 输出这样两个数有几对。
 *
 * 1
 * 1 2 4 7 11 0 9 15
 * 11
 *
 * 3
 */
public class FixedAndElementPair {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            int[] digit = Arrays.stream(
                    sc.nextLine().split(" "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Arrays.sort(digit);
            int start = 0;
            int end = digit.length - 1;
            int current = 0;
            int result = 0;
            while (start < end) {
                current = digit[start] + digit[end];
                if (current == target) {
                    result++;
                    start++;
                    end--;
                } else if (current < target) {
                    start++;
                } else {
                    end--;
                }
            }
            System.out.println(result);
        }
    }
}
