package algorithms.leetcodecn.binarySearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by thpffcj on 2020/2/11.
 *
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 * 示例 1：
 * 输入：A = [1], K = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：A = [1,2], K = 4
 * 输出：-1
 *
 * 示例 3：
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 */
public class ShortestSubarrayWithSumAtLeastK {

    public int shortestSubarray(int[] A, int K) {

        int N = A.length;
        long[] P = new long[N + 1];
        for (int i = 0; i < N; i++) {
            P[i + 1] = P[i] + (long) A[i];
        }

        int ans = N + 1;
        Deque<Integer> monoq = new LinkedList<>();

        for (int y = 0; y < P.length; y++) {

            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()]) {
                monoq.removeLast();
            }
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K) {
                ans = Math.min(ans, y - monoq.removeFirst());
            }

            monoq.addLast(y);
        }

        return ans < N + 1 ? ans : -1;
    }
}
