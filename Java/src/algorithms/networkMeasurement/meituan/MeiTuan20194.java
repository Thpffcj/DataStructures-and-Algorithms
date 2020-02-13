package algorithms.networkMeasurement.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/12.
 *
 * 公园里有N个花园，初始时每个花园里都没有种花，园丁将花园从1到N编号并计划在编号为i的花园里恰好种A_i朵花，他每天会选择一个区间
 * [L，R]（1≤L≤R≤N）并在编号为L到R的花园里各种一朵花，那么园丁至少要花多少天才能完成计划？
 *
 * 输入描述:
 * 第一行包含一个整数N，1≤N≤10^5。
 * 第二行包含N个空格隔开的整数A_1到A_N，0≤A_i≤10^4。
 *
 * 输出描述:
 * 输出完成计划所需的最少天数。
 *
 * 输入例子1:
 * 5
 * 4 1 8 2 5
 *
 * 输出例子1:
 * 14
 */
public class MeiTuan20194 {

    /**
     * 实际上这样做会制造一个单调递增序列，
     * 比如题目用例，[4, 1, 8, 2, 5]，如果我们在执行上面的代码同时update整个序列，会得到
     * 1: [1, 1, 8, 2, 5], sum = 3
     * 2: [1, 1, 8, 2, 5], sum = 3
     * 3: [1, 1, 2, 2, 5], sum = 3 + 6
     * 此时序列已经递增，最后一个数字是5，那么5天就可以种完， sum = 3 + 6 + 5 = 14.
     *
     * 举一个复杂的例子，[5, 3, 7, 1, 6]
     * 1: [3, 3, 7, 1, 6], sum = 2
     * 2: [3, 3, 7, 1, 6], sum = 2
     * 下一步比较特殊，因为第三位之前的序列是单调递增的，我们执行7 - 1天种植之后，第一位和第二位的3也会变成1
     * 3: [1, 1, 1, 1, 6], sum = 2 + 6
     * 4: 此时序列单调递增，sum = 2 + 6 + 6 = 14。其实也可以这样考虑，在数列最后添加0，变成[1, 1, 1, 1, 6, 0], 最后执行
     * 6 - 0天种植, 数列会全部归零，sum = 2 + 6 + 6 = 14.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] flower = new int[n];
            for (int i = 0; i < n; i++) {
                flower[i] = sc.nextInt();
            }

            int day = 0;
            for (int i = 1; i < n; i++) {
                if (flower[i - 1] > flower[i]) {
                    day += flower[i - 1] - flower[i];
                }
            }
            day += flower[n - 1];
            System.out.println(day);
        }
    }
}
