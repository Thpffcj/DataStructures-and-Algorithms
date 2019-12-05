package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Description A班
 * Given an array, the task is to complete the function which finds the maximum sum subarray, where you
 * may remove at most one element to get the maximum sum.
 *
 * Input
 * 第一行为测试用例个数T；后面每两行表示一个用例，第一行为用例中数组长度N，第二行为数组具体内容。
 *
 * Output
 * 每一行表示对应用例的结果。
 *
 * Sample Input 1
 * 1
 * 5
 * 1 2 3 -4 5
 *
 * Sample Output 1
 * 11
 */
public class BatchQuery {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            List<Integer> digit = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                digit.add(sc.nextInt());
            }

            System.out.println(maxSum2(digit));

            numbers--;
        }
    }

    public static int maxSum2(List<Integer> digit) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < digit.size(); i++) {
            for (int j = i + 1; j <= digit.size(); j++) {
                int sum = findSum(digit.subList(i, j));
                if (sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static int findSum(List<Integer> digit) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digit.size(); i++) {
            list.add(digit.get(i));
        }

        Collections.sort(list);

        if (list.get(0) < 0 && list.get(list.size() - 1) > 0) {
            list.set(0, 0);
        }

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    public static void maxSum(int[] digit) {
        int n = digit.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = digit[0];
        g[0] = 0;

        int res = f[0];
        for (int i = 1; i < n ; i++) {
            f[i] = Math.max(f[i - 1] + digit[i], digit[i]);
            // 选f[i - 1]说明跳过i
            g[i] = Math.max(g[i - 1] + digit[i], f[i - 1]);
            res = Math.max(res, Math.max(f[i], g[i]));
        }

        System.out.println(res);
    }
}
