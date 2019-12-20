package algorithms.leetcodecn.weekly.oneHundredSixtySeven;

/**
 * Created by thpffcj on 2019/12/15.
 */

import java.util.*;

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

    public static int result = Integer.MAX_VALUE;

    // TODO 超时，因为状态太多了？
    public int shortestPath2(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        result = m * n;

        getPath(grid, m, n, k, 0, 0, visit, 0);

        if (result == m * n) {
            return -1;
        } else {
            return result;
        }
    }

    public void getPath(int[][] grid, int m, int n, int k, int x, int y, boolean[][] visit, int step) {

        if (x < 0 || x >= m || y < 0 || y >= n || k < 0 || step >= result) {
            return;
        }

        if (visit[x][y]) {
            return;
        }

        if (x == m - 1 && y == n - 1) {
            result = step;
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

    private int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Point {

        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * 广度优先遍历
     * @param grid
     * @param k
     * @return
     */
    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));

        // 访问记录二维扩展为三维
        visited[0][0][0] = true;

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;

            int size = queue.size();

            // 一层的distance都应该一致
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int z = point.z;

                // 广度优先找到的一定是最小的
                if (x == m - 1 && y == n - 1) {
                    return distance - 1;
                }

                // 4个方向移动
                for (int j = 0; j < 4; j++) {
                    int newX = x + dir[j][0];
                    int newY = y + dir[j][1];
                    int newZ = z;

                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }

                    if (grid[newX][newY] == 1) {
                        // 没有消除 k 个障碍物，可以继续消除
                        if (z < k) {
                            newZ = z + 1;
                        } else {
                            // 已经消除 k 个障碍物
                            continue;
                        }
                    }

                    if (!visited[newX][newY][newZ]) {
                        queue.add(new Point(newX, newY, newZ));
                        visited[newX][newY][newZ] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInTheGrid s = new ShortestPathInTheGrid();
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        s.shortestPath(grid, 1);
    }
}
