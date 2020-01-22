package algorithms.leetcodecn.greedyAlgorithm;

import java.util.*;

/**
 * Created by thpffcj on 2020/1/21.
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {

    /**
     * 排序：
     * 按高度降序排列。
     * 在同一高度的人中，按 k 值的升序排列。
     * 逐个地把它们放在输出队列中，索引等于它们的 k 值。
     * 返回输出队列
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
