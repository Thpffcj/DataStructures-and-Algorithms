package algorithms.networkMeasurement.netease;

/**
 * Created by Thpffcj on 2018/3/27.
 */

import java.util.Scanner;

/**
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 *
 * 输入描述:
 * 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
 * 输出描述:
 * 输出一个数，表示最少需要的转换次数
 *
 * 输入例子1:
 * 4 1 1 1 3
 * 输出例子1:
 * 2
 */
public class PalindromeSequence {

    // 利用递归，两端不论怎样都要相等或者最终合成为同一个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }
            int head = 0;
            int tail = n - 1;
            int times = 0;
            while (head < tail) {
                if (numbers[head] == numbers[tail]) {
                    head++;
                    tail--;
                } else if (numbers[head] < numbers[tail]) {
                    numbers[head + 1] = numbers[head + 1] + numbers[head];
                    head++;
                    times++;
                } else {
                    numbers[tail - 1] = numbers[tail - 1] + numbers[tail];
                    tail--;
                    times++;
                }
            }
            System.out.println(times);
        }
    }
}
