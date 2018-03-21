package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

/**
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 * 给定数组A及它的大小n，请返回最大差值。
 *
 * 测试样例：
 * [10,5],2
 * 返回：0
 */
public class LongestDistance {

    public int getDis(int[] A, int n) {
        if (A.length == 0) {
            return 0;
        }
        int min = A[0];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int curMax = A[i] - min;
            if (curMax > max) {
                max = curMax;
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        return max;
    }
}
