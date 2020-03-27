package algorithms.masterOnlineExam.alibaba;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/23.
 */
public class ALiBaBa20202 {

    private static int startX;
    private static int startY;
    private static int row;
    private static int col;
    private static int step;
    private static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        row = n + 1;
        col = m + 1;
        step = Integer.MAX_VALUE;
        String[][] road = new String[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                road[i][j] = line.charAt(j - 1) + "";
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (road[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        boolean[][] visited = new boolean[n + 1][m + 1];

        getStep(road, visited, startX, startY, 0, 5);

        if (step == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(step);
        }
    }

    public static void getStep(String[][] road, boolean[][] visited, int x, int y, int curStep, int k) {

        if (road[x][y].equals("E")) {
            if (curStep < step) {
                step = curStep;
            }
            return;
        }

        if (curStep > step) {
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && !road[newX][newY].equals("#")) {
                getStep(road, visited, newX, newY, curStep + 1, k);
            }
        }
        if (k >= 0) {
            int newX = row + 1 - x;
            int newY = col + 1 - y;
            if (inArea(newX, newY) && !visited[newX][newY] && !road[newX][newY].equals("#")) {
                getStep(road, visited, newX, newY, curStep + 1, k - 1);
            }
        }
        visited[x][y] = false;
    }

    public static boolean inArea(int x, int y) {
        return x >= 1 && x < row && y >= 1 && y < col;
    }
}
//4 4
//#S..
//E#..
//#...
//....
