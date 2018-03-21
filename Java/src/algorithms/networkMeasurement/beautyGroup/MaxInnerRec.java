package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

/**
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],它所包含的
 * 最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 * 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 *
 * 测试样例：
 * [2,7,9,4,1],5
 * 返回：14
 */
public class MaxInnerRec {

    public int countArea(int[] A, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = A[i];
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, A[j]);
                max = Math.max(max, minHeight * (j - i + 1));
            }
        }
        return max;
    }
}
