package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/3/20.
 */

import java.util.Scanner;

/**
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * 输入描述:
 * 整数N
 * <p>
 * 输出描述:
 * 最少需要几位同学出列
 * <p>
 * 示例1
 * 输入
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 4
 */
public class Choir {

    /**
     * 两遍最长递增子序列，第一遍从左往右，第二遍从右往左，然后把两遍动态规划的结果相加，取最大的那个，
     * 比如8 186 186 150 200 160 130 197 200，第一遍dp的结果是 1 1 1 2 2 1 3 4，
     * 第二遍dp的结果为3 3 2 3 2 1 1 1，那么相加最大是5，所以需要出列的同学个数就是8-5+1=4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if (num <= 2) {
                System.out.println(0);
            }
            int[] members = new int[num]; // 存储每一个数据元素
            int[] leftQueue = new int[num]; // 数据元素从左到右对应的最大递增子序列数
            int[] rightQueue = new int[num]; // 数据元素从右到左对应的最大递增子序列数
            for (int i = 0; i < num; i++) { // 初始化各个数组数据
                members[i] = in.nextInt();
                leftQueue[i] = 1;
                rightQueue[i] = 1;
            }
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < i; j++) {
                    if (members[i] > members[j] && leftQueue[j] + 1 > leftQueue[i])
                        leftQueue[i] = leftQueue[j] + 1;
                }
            }
            for (int i = num - 1; i >= 0; i--) {
                for (int j = num - 1; j > i; j--) {
                    if (members[i] > members[j] && rightQueue[j] + 1 > rightQueue[i])
                        rightQueue[i] = rightQueue[j] + 1;
                }
            }
            int max = 0;
            for (int i = 0; i < num; i++) {
                if (leftQueue[i] + rightQueue[i] > max)
                    max = leftQueue[i] + rightQueue[i];
            }
            System.out.println(num - max + 1);
        }
    }
}