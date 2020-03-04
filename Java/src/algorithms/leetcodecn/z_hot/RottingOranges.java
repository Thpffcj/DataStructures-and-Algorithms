package algorithms.leetcodecn.z_hot;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thpffcj on 2020/3/4.
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class RottingOranges {

    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;
    public int orangesRotting(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * n + j);
                }
            }
        }

        int time = 0;
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int position = queue.poll();
                int x = position / n;
                int y = position % n;
                for (int j = 0; j < 4; j++) {
                    int newX = x + direction[j][0];
                    int newY = y + direction[j][1];
                    if (inArea(newX, newY) && grid[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        grid[newX][newY] = 2;
                        queue.add(newX * n + newY);
                    }
                }
            }
            time++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        if (time == 0) {
            return 0;
        }
        return time;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        RottingOranges r = new RottingOranges();
        int[][] grid = new int[][]{{1},{2},{1},{1}};
        r.orangesRotting(grid);
    }
}
