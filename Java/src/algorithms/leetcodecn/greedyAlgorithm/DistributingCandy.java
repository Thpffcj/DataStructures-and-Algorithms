package algorithms.leetcodecn.greedyAlgorithm;

/**
 * Created by thpffcj on 2019/10/16.
 */

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class DistributingCandy {

    /**
     * 规则定义： 设学生 AA 和学生 BB 左右相邻，AA 在 BB 左边；
     * 左规则： 当 ratings_B>ratings_A时，B 的糖比 A 的糖数量多。
     * 右规则： 当 ratings_A>ratings_B时，A 的糖比 B 的糖数量多。
     * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 0) {
            return 0;
        }

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = right[right.length - 1] = 1;

        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
