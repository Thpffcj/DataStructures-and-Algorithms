package algorithms.advancedAlgorithm.homework.homework1;

/**
 * Created by thpffcj on 2019/10/11.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * 从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入是一个数组，数值通过空格隔开。
 * Output
 * 输出筛选之后的数组，用空格隔开。如果有多种结果，则一行一种结果， 单个输入的所有结果按从小到大排序，排序的key的优先级随
 * index递增而递减 例如 3 4 7 6； 1 3 7 5； 1 2 7 6； 1 3 7 6 排序成 1 2 7 6；1 3 7 5；1 3 7 6； 3 4 7 6；
 *
 * 4
 * 1 2 4 7 11 10 9 15 3 5 8 6
 * 1 3 5 4 7 6 4 5 3
 * 1 2 3
 * 3 2 1
 *
 * 1 2 4 7 11 10 9 8 6
 * 1 3 4 7 6 4 3
 * 1 3 4 7 6 5 3
 * 1 3 5 7 6 4 3
 * 1 3 5 7 6 5 3
 * 1 2 3
 * 3 2 1
 */
public class FirstRiseAndThenFall {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {

            String[] line = sc.nextLine().split(" ");
            int[] digit = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                digit[i] = Integer.parseInt(line[i]);
            }

            int increase[] = new int[digit.length];
            int decrease[] = new int[digit.length];
            Arrays.fill(increase, 1);
            Arrays.fill(decrease, 1);

            for (int i = 1; i < digit.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (digit[i] > digit[j]) {
                        increase[i] = Math.max(increase[i], increase[j] + 1);
                    }
                }
            }

            for (int i = digit.length - 2; i >= 0; i--) {
                for (int j = digit.length - 1; j > i; j--) {
                    if (digit[i] > digit[j]) {
                        decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                    }
                }
            }

//            for (int i = 0; i < increase.length; i++) {
//                System.out.print(increase[i]);
//            }
//            System.out.println();
//            for (int i = 0; i < decrease.length; i++) {
//                System.out.print(decrease[i]);
//            }
            int[] sum = new int[digit.length];
            for (int i = 0; i < digit.length; i++) {
                sum[i] = increase[i] + decrease[i];
            }

            int max = 0;
            int position = -1;
            for (int i = 0; i < digit.length; i++) {
                if (sum[i] > max) {
                    max = sum[i];
                    position = i;
                }
            }

            int incr = increase[position];
            int decr = decrease[position];


        }
    }

//    public static void findIncreaseList(List<Integer> list, int[] increase, int[] digit, int target, int incr, int pos) {
//
//        if (list.size() == incr) {
//            List<Integer> temp = new ArrayList<>(list);
//            increaseResult.add(temp);
//            return;
//        }
//        for (int i = 0; i <= pos; i++) {
//            if (increase[i] == target) {
//                list.add(digit[i]);
//                findIncreaseList(list, increase, digit, target + 1, incr, pos);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//
//    public static void findDecreaseList(List<Integer> list, int[] decrease, int[] digit, int target, int decr, int pos) {
//
//        if (list.size() == decr - 1) {
//            List<Integer> temp = new ArrayList<>(list);
//            decreaseResult.add(temp);
//            return;
//        }
//        for (int i = pos; i < digit.length; i++) {
//            if (decrease[i] == target) {
//                list.add(digit[i]);
//                findDecreaseList(list, decrease, digit, target - 1, decr, pos);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}

//10 9 2 5 3 7 101 18