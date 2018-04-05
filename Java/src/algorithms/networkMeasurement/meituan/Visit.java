package algorithms.networkMeasurement.meituan;

/**
 * Created by Thpffcj on 2018/3/21.
 */

/**
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，
 * 他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 * 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，
 * 保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 * <p>
 * 测试样例：
 * [[0,1,0],[2,0,0]],2,3
 * 返回：2
 */
public class Visit {

    public int countPath(int[][] map, int n, int m) {
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
            }
        }

        int dirX = startX > endX ? -1 : 1;
        int dirY = startY > endY ? -1 : 1;

        int[][] plan = new int[n][m];
        for (int x = startX; x != endX + dirX; x = x + dirX) {
            for (int y = startY; y != endY + dirY; y = y + dirY) {
                if (map[x][y] == -1) {
                    plan[x][y] = 0;
                } else {
                    if (x == startX && y == startY) {
                        plan[x][y] = 1;
                    } else if (x == startX) {
                        plan[x][y] = plan[x][y - dirY];
                    } else if (y == startY) {
                        plan[x][y] = plan[x - dirX][y];
                    } else {
                        plan[x][y] = plan[x][y - dirY] + plan[x - dirX][y];
                    }
                }
            }
        }
        return plan[endX][endY];
    }

    public static void main(String[] args) {
        Visit visit = new Visit();
        int[][] map = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,2}};
        visit.countPath(map, 7, 5);
    }
}
