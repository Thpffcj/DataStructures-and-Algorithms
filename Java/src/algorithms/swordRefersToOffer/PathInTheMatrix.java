package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-08-14.
 */

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵
 * 中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了
 * 矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathInTheMatrix {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || rows <= 0 || cols <= 0) {
            return false;
        }

        boolean[] visited = new boolean[matrix.length];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPath(matrix, rows, cols, row, col, str, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, int row, int col, char[] str, int pos, boolean[] visited) {
        if (str.length == pos) {
            return true;
        }
        boolean result = false;
        if (row >=0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pos]
                && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            pos++;

            result = (hasPath(matrix, rows, cols, row - 1, col, str, pos, visited)
            || hasPath(matrix, rows, cols, row, col - 1, str, pos, visited)
            || hasPath(matrix, rows, cols, row + 1, col, str, pos, visited)
            || hasPath(matrix, rows, cols, row, col + 1, str, pos, visited));

            if (!result) {
                pos--;
                visited[row * cols + col] = false;
            }
        }

        return result;
    }
}
