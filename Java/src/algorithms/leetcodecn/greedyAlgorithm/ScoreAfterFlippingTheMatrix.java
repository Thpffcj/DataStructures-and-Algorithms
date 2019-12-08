package algorithms.leetcodecn.greedyAlgorithm;

/**
 * Created by thpffcj on 2019/12/8.
 */

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *  
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 *
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 * 提示：
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class ScoreAfterFlippingTheMatrix {

    public int matrixScore(int[][] A) {

        if (A == null || A.length <= 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }

        for (int j = 1; j < A[0].length; j++) {
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                result += A[i][j];
            }
            // 如果1少于一半就翻转
            if (result < A.length / 2.0) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int digit = 0;
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    digit += Math.pow(2, A[i].length - j - 1);
                }
            }
            result += digit;
        }

        return result;
    }

    public int matrixScore2(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {
            int col = 0;
            for (int r = 0; r < R; ++r)
                col += A[r][c] ^ A[r][0];
            ans += Math.max(col, R - col) * (1 << (C-1-c));
        }
        return ans;
    }
}
