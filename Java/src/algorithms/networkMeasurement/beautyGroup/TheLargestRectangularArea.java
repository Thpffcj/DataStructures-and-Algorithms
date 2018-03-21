package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

import java.util.Scanner;

/**
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 在这组柱状图中找到能组成的最大矩形的面积。
 * 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 * <p>
 * 输入描述:
 * 输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000)
 * 第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000)
 * 输出描述:
 * 输出一个整数,表示最大的矩阵面积。
 * <p>
 * 输入例子1:
 * 6
 * 2 1 5 6 2 3
 * <p>
 * 输出例子1:
 * 10
 */
public class TheLargestRectangularArea {

    // TODO 这只是暴力解法
    public static int getMaxArea(int[] height) {
        int len = height.length;
        int max = 0; // 存储最大面积的
        for (int i = 0; i < len; i++) { // i表示依次遍历每一个高度
            int minHeight = height[i]; // 设i为最小高度
            for (int j = i; j < len; j++) {
                minHeight = Math.min(minHeight, height[j]); // 找出i之后的最小高度
                max = Math.max(max, (j - i + 1) * minHeight); // 计算以最小高度为高度的最大面积值
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getMaxArea(arr));
    }
}
