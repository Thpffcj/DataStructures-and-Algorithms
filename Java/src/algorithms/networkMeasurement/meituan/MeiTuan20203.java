package algorithms.networkMeasurement.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/8.
 *
 * 有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，成本为这两堆金币块数之和。经过N-1
 * 次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。
 * 其中，1 <= N <= 30，1 <= C[i] <= 100
 *
 * 输入描述:
 * 第一行输入一个数字 N 表示有 N 堆金币
 * 第二行输入 N 个数字表示每堆金币的数量 C[i]
 *
 * 输出描述:
 * 输出一个数字 S 表示最小的合并成一堆的成本
 *
 * 输入例子1:
 * 4
 * 3 2 4 1
 * 输出例子1:
 * 20
 *
 * 输入例子2:
 * 30
 * 10 20 30 40 50 60 70 80 90 100 99 89 79 69 59 49 39 29 19 9 2 12 22 32 42 52 62 72 82 92
 * 输出例子2:
 * 7307
 */
public class MeiTuan20203 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++){
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        int money[][] = new int[N + 1][N + 1];
        //先设置最大值
        for (int i = 1; i <= N; i++){
            Arrays.fill(money[i],Integer.MAX_VALUE);
        }

        for (int len = 0; len < N; len++){
            for (int i = 1; i <= N - len; i++){
                int j = i + len;
                if (len == 0) {  // i==j的情况
                    money[i][j] = 0;
                }
                for (int k = i; k < j; k++){
                    money[i][j] = Math.min(
                            money[i][j], money[i][k] + money[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }
        System.out.println(money[1][N]);
    }
}
