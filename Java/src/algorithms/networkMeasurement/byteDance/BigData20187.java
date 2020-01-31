package algorithms.networkMeasurement.byteDance;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/29.
 *
 * 二阶魔方又叫小魔方，是2*2*2的立方形结构。每一面都有4个块，共有24个块。每次操作可以将任意一面逆时针或者顺时针旋转90°
 *
 * Nero在小魔方上做了一些改动，用数字替换每个块上面的颜色，称之为数字魔方。魔方上每一面的优美度就是这个面上4个数字的乘积，而魔方的总优美度
 * 就是6个面优美度总和。
 * 现在Nero有一个数字魔方，他想知道这个魔方在操作不超过5次的前提下能达到的最大优美度是多少。
 * 魔方展开后每一块的序号如下图：
 *
 * 输入描述:
 * 输入一行包含24个数字，按序号顺序给出魔方每一块上面的数字。所有数大小范围为[-100,100]。
 *
 * 输出描述:
 * 输出一行包含一个数字，表示最大优美度。
 *
 * 输入例子1:
 * 2 -3 -2 3 7 -6 -6 -7 9 -5 -9 -3 -2 1 4 -9 -1 -10 -5 -5 -10 -4 8 2
 *
 * 输出例子1:
 * 8281
 */
public class BigData20187 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] num = new int[24];
            for (int i = 0; i < 24; i++) {
                num[i] = scanner.nextInt();
            }
            System.out.println(maxGrace(num, 5));
        }
    }

    public static int maxGrace(int[] num, int times) {
        int grace = calculateGrace(num);
        if (times == 0) {
            return grace;
        }

        int[] numcp = new int[24];
        for (int i = 0; i < 24; i++) {
            numcp[i] = num[i];
        }
        turnLeft(numcp);
        grace = Math.max(maxGrace(numcp, times - 1), grace);

        for (int i = 0; i < 24; i++) {
            numcp[i] = num[i];
        }
        turnRight(numcp);
        grace = Math.max(maxGrace(numcp, times - 1), grace);

        for (int i = 0; i < 24; i++) {
            numcp[i] = num[i];
        }
        turnTop(numcp);
        grace = Math.max(maxGrace(numcp, times - 1), grace);

        for (int i = 0; i < 24; i++) {
            numcp[i] = num[i];
        }
        turnBottom(numcp);
        grace = Math.max(maxGrace(numcp, times - 1), grace);

        for (int i = 0; i < 24; i++) {
            numcp[i] = num[i];
        }
        turnFront(numcp);
        grace = Math.max(maxGrace(numcp, times - 1), grace);

        for (int i = 0; i < 24; i++) {
            numcp[i] = num[i];
        }
        turnBack(numcp);
        grace = Math.max(maxGrace(numcp, times - 1), grace);

        return grace;
    }

    public static int calculateGrace(int[] n) {
        return n[0] * n[1] * n[2] * n[3]
                + n[4] * n[5] * n[10] * n[11]
                + n[8] * n[9] * n[14] * n[15]
                + n[6] * n[7] * n[12] * n[13]
                + n[16] * n[17] * n[18] * n[19]
                + n[20] * n[21] * n[22] * n[23];
    }

    public static void turnLeft(int[] num) {
        change(num, 0, 6, 16, 20);
        change(num, 2, 12, 18, 22);
        change(num, 4, 5, 11, 10);
    }

    public static void turnRight(int[] num) {
        change(num, 1, 7, 17, 21);
        change(num, 3, 13, 19, 23);
        change(num, 9, 8, 14, 15);
    }

    public static void turnTop(int[] num) {
        change(num, 4, 6, 8, 23);
        change(num, 5, 7, 9, 22);
        change(num, 2, 3, 1, 0);
    }

    public static void turnBottom(int[] num) {
        change(num, 10, 12, 14, 21);
        change(num, 11, 13, 15, 20);
        change(num, 16, 17, 19, 18);
    }

    public static void turnFront(int[] num) {
        change(num, 11, 2, 8, 17);
        change(num, 5, 3, 14, 16);
        change(num, 6, 7, 13, 12);
    }

    public static void turnBack(int[] num) {
        change(num, 10, 0, 9, 19);
        change(num, 4, 1, 15, 18);
        change(num, 22, 23, 21, 20);
    }

    public static void change(int[] num, int i, int j, int k, int m) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = num[k];
        num[k] = num[m];
        num[m] = temp;
    }
}
