package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.Scanner;

/**
 * Description
 * 实现Shell排序，对给定的无序数组，按照给定的间隔变化（间隔大小即同组数字index的差），打印排序结果，注意不一定是最终排序结果！
 *
 * Input
 * 输入第一行表示测试用例个数，后面为测试用例，每一个用例有两行，第一行为给定数组，第二行为指定间隔，每一个间隔用空格隔开。
 *
 * Output
 * 输出的每一行为一个用例对应的指定排序结果。
 *
 * Sample Input 1
 * 1
 * 49 38 65 97 76 13 27 49 55 4
 * 5 3
 *
 * Sample Output 1
 * 13 4 49 38 27 49 55 65 97 76
 */
public class ImplementShellSorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String[] line = sc.nextLine().split(" ");
            int[] digit = new int[line.length];
            for (int i = 0; i < digit.length; i++) {
                digit[i] = Integer.parseInt(line[i]);
            }

            String[] line2 = sc.nextLine().split(" ");

            for (int n = 0; n < line2.length; n++) {
                int k = Integer.parseInt(line2[n]);

                for (int i = k; i < digit.length; i++) {
                    for (int j = i; j >= k; j -= k) {
                        if (digit[j] < digit[j - k]) {
                            int temp = digit[j];
                            digit[j] = digit[j - k];
                            digit[j - k] = temp;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digit.length; i++) {
                sb.append(digit[i]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));

            numbers--;
        }
    }
}
