package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/8/24.
 */

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位
 * 之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class RobotRangeOfMotion {

    int movingCount(int threshold, int rows, int cols) {

        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];

        int result = count(0, 0, threshold, rows, cols, visited);

        return result;
    }

    int count(int row, int col, int threshold, int rows, int cols, boolean[][] visited) {

        if ((row >= 0 && row < rows)
                && (col >=0 && col < cols)
                && !visited[row][col]) {
            if (calculateSum(row, col) <= threshold) {
                visited[row][col] = true;
                return count(row - 1, col, threshold, rows, cols, visited)
                        + count(row + 1, col, threshold, rows, cols, visited)
                        + count(row, col - 1, threshold, rows, cols, visited)
                        + count(row, col + 1, threshold, rows, cols, visited)
                        + 1;
            }
        }

        return 0;
    }

    int calculateSum(int m, int n) {
        int result = 0;
        while (m >= 10) {
            result += (m % 10);
            m = m / 10;
        }
        result += m;

        while (n >= 10) {
            result += (n % 10);
            n = n / 10;
        }
        result += n;

        return result;
    }
}
