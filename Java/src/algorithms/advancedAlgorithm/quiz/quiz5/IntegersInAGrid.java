package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.*;

/**
 * Description
 * Given a square grid of size n, each cell of which contains integer cost which represents a cost to traverse
 * through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred
 * is minimum.
 *
 * Note : It is assumed that negative cost cycles do not exist in input matrix.
 *
 *
 * Input
 * The first line of input will contain number of test cases T. Then T test cases follow . Each test case contains
 * 2 lines. The first line of each test case contains an integer n denoting the size of the grid. Next line of
 * each test contains a single line containing N*N space separated integers depecting cost of respective cell
 * from (0,0) to (n,n).
 *
 * Constraints:1<=T<=50，1<= n<= 50
 *
 *
 * Output
 * For each test case output a single integer depecting the minimum cost to reach the destination.
 *
 * Sample Input 1
 * 2
 * 5
 * 31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20
 * 2
 * 42 93 7 14
 *
 * Sample Output 1
 * 327
 * 63
 */
public class IntegersInAGrid {

    // TODO Greedy
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            list = new ArrayList<>();
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            boolean[][] visit = new boolean[n][n];
            findPath(grid, visit, 0, 0, 0);
            Collections.sort(list);

            System.out.println(list.get(0));

            numbers--;
        }
    }

    public static void findPath(int[][] grid, boolean[][] visit, int x, int y, int cost) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        cost += grid[x][y];
        if (x == m - 1 && y == n - 1) {
            list.add(cost);
            return;
        }

        visit[x][y] = true;
        if (x - 1 >= 0 && !visit[x - 1][y]) {
            findPath(grid, visit, x - 1, y, cost);
        }
        if (x + 1 < m && !visit[x + 1][y]) {
            findPath(grid, visit, x + 1, y, cost);
        }
        if (y - 1 >= 0 && !visit[x][y - 1]) {
            findPath(grid, visit, x, y - 1, cost);
        }
        if (y + 1 < n && !visit[x][y + 1]) {
            findPath(grid, visit, x, y + 1, cost);
        }
        visit[x][y] = false;
    }
}
