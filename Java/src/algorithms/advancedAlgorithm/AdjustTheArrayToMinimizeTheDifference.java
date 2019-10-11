package algorithms.advancedAlgorithm;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与
 * [序列 b 元素的和]之间的差最小。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入为两行，分别为两个数组，每个值用空格隔开。
 * Output
 * 输出变化之后的两个数组内元素和的差绝对值。
 *
 * 1
 * 100 99 98 1 2 3
 * 1 2 3 4 5 40
 *
 * 48
 */
public class AdjustTheArrayToMinimizeTheDifference {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String[] line1 = sc.nextLine().split(" ");
            String[] line2 = sc.nextLine().split(" ");



        }
    }

    public static void permutation(List<Integer> list) {

    }
}
