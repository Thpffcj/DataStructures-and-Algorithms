package algorithms.leetcodecn.array;

/**
 * Created by thpffcj on 2019/10/24.
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分
 * 别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;
        int area = 0;
        while (start < end) {
            if (height[start] <= height[end]) {
                area = (end - start) * height[start];
                start++;
            } else {
                area = (end - start) * height[end];
                end--;
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Integer.min(height[i], height[j]);
                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }
}
