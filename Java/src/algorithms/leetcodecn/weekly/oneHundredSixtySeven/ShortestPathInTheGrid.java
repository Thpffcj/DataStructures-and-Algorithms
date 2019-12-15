package algorithms.leetcodecn.weekly.oneHundredSixtySeven;

/**
 * Created by thpffcj on 2019/12/15.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的
 * 路径，则返回 -1。
 *
 * 示例 1：
 * 输入：
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 在位置 (3,2) 处消除一个障碍后的最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *
 * 示例 2：
 * 输入：
 * grid =
 * [[0,1,1],
 *  [1,1,1],
 *  [1,0,0]],
 * k = 1
 * 输出：-1
 * 解释：
 * 我们至少需要消除两个障碍才能找到这样的道路。
 *
 * 提示：
 * grid.length == m
 * grid[0].length == n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 */
public class ShortestPathInTheGrid {

    public static List<Integer> list = new ArrayList<>();

    // TODO 超时
    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        list = new ArrayList<>();

        getPath(grid, m, n, k, 0, 0, visit, 0);

        Collections.sort(list);
        if (list.size() == 0) {
            return -1;
        } else {
            return list.get(0);
        }

    }

    public void getPath(int[][] grid, int m, int n, int k, int x, int y, boolean[][] visit, int step) {

        if (x < 0 || x >= m || y < 0 || y >= n || k < 0) {
            return;
        }

        if (visit[x][y]) {
            return;
        }

        if (x == m - 1 && y == n - 1) {
            list.add(step);
            return;
        }

        visit[x][y] = true;
        if (grid[x][y] == 0) {
            getPath(grid, m, n, k, x + 1, y, visit, step + 1);
            getPath(grid, m, n, k, x - 1, y, visit, step + 1);
            getPath(grid, m, n, k, x, y + 1, visit, step + 1);
            getPath(grid, m, n, k, x, y - 1, visit, step + 1);
        } else {
            getPath(grid, m, n, k - 1, x + 1, y, visit, step + 1);
            getPath(grid, m, n, k - 1, x - 1, y, visit, step + 1);
            getPath(grid, m, n, k - 1, x, y + 1, visit, step + 1);
            getPath(grid, m, n, k - 1, x, y - 1, visit, step + 1);
        }
        visit[x][y] = false;
    }

    public static void main(String[] args) {
        ShortestPathInTheGrid s = new ShortestPathInTheGrid();
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        s.shortestPath(grid, 1);
    }
}
