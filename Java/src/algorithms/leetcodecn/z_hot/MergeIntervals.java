package algorithms.leetcodecn.z_hot;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * Created by thpffcj on 2020/2/24.
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int start = 0;
        for (int end = 1; end <= intervals.length; end++) {
            if (end == intervals.length || intervals[start][1] < intervals[end][0]) {
                int[] interval = new int[2];
                interval[0] = intervals[start][0];
                interval[1] = intervals[end - 1][1];
                list.add(interval);
                start = end;
            } else {
                if (intervals[start][1] > intervals[end][1]) {
                    intervals[end][1] = intervals[start][1];
                } else {
                    intervals[start][1] = intervals[end][1];
                }
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = new int[][]{{2,6},{1,3},{15,18},{8,10}};
        m.merge(intervals);
    }
}
