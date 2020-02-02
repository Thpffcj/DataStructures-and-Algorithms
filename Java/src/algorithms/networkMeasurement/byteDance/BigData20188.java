package algorithms.networkMeasurement.byteDance;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/29.
 *
 * 有一个推箱子的游戏, 一开始的情况如下图:
 *
 * 上图中, '.' 表示可到达的位置, '#' 表示不可到达的位置，其中 S 表示你起始的位置, 0表示初始箱子的位置, E表示预期箱子的位置，你可以走
 * 到箱子的上下左右任意一侧, 将箱子向另一侧推动。如下图将箱子向右推动一格;
 * ..S0.. -> ...S0.
 * 注意不能将箱子推动到'#'上, 也不能将箱子推出边界;
 * 现在, 给你游戏的初始样子, 你需要输出最少几步能够完成游戏, 如果不能完成, 则输出-1。
 *
 * 输入描述:
 * 第一行为2个数字,n, m, 表示游戏盘面大小有n 行m 列(5< n, m < 50);
 * 后面为n行字符串,每行字符串有m字符, 表示游戏盘面;
 *
 * 输出描述:
 * 一个数字,表示最少几步能完成游戏,如果不能,输出-1;
 *
 * 输入例子1:
 * 3 6
 * .S#..E
 * .#.0..
 * ......
 * 
 * 输出例子1:
 * 11
 */
public class BigData20188 {

    private static class Status{
        int x, y;
        int bx, by;
        int st;
        public Status(int x, int y, int bx, int by, int st) {
            this.x = x;
            this.y = y;
            this.bx = bx;
            this.by = by;
            this.st = st;
        }
    }

    private static final int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            char[][] map = new char[n][m];
            for(int i = 0; i < n; i++) {
                String tmp = sc.next();
                map[i] = tmp.toCharArray();
            }
            System.out.println(pushBox(map));
        }
    }

    private static int pushBox(char[][] map) {

        int px = -1, py = -1;
        int bx = -1, by = -1;

        // visited[px][py][bx][by]标记这个状态是否出现过
        boolean[][][][] visited = new boolean[n][m][n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'S') {
                    px = i;
                    py = j;
                }
                else if(map[i][j] == '0') {
                    bx = i;
                    by = j;
                }
            }
        }

        int st = 0;
        Status s = new Status(px, py, bx, by, st);
        LinkedList<Status> queue = new LinkedList<>();
        queue.addLast(s);
        visited[px][py][bx][by] = true;

        while(!queue.isEmpty()) {
            s = queue.pollFirst();
            px = s.x;
            py = s.y;
            bx = s.bx;
            by = s.by;
            st = s.st;
            for(int i = 0; i < 4; i++) {
                int nextX = px + step[i][0];
                int nextY = py + step[i][1];
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if(!(map[nextX][nextY] == '#') && !visited[nextX][nextY][bx][by]) {
                        // 推箱子
                        if(nextX == bx && nextY == by) {
                            int nextBx = bx + step[i][0];
                            int nextBy = by + step[i][1];
                            if(nextBx >= 0 && nextBx < n && nextBy >= 0 && nextBy < m
                                    && !(map[nextBx][nextBy] == '#')){
                                Status news = new Status(nextX, nextY, nextBx, nextBy, st + 1);
                                queue.addLast(news);
                                visited[nextX][nextY][nextBx][nextBy] = true;
                                if(map[nextBx][nextBy] == 'E') {
                                    return st + 1;
                                }
                            }
                        } else{
                            Status news = new Status(nextX, nextY, bx, by, st + 1);
                            queue.addLast(news);
                            visited[nextX][nextY][bx][by] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
