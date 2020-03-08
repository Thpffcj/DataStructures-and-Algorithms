package algorithms.leetcodecn.z_hot;

/**
 * Created by thpffcj on 2020/3/6.
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class SearchA2dMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m <= 0) {
            return false;
        }
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
