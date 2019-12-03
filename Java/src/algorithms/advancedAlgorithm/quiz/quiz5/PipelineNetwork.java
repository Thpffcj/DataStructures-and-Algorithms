package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.*;

/**
 * Description
 * Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and
 * taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a
 * tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap. Find
 * the efficient way for the construction of the network of pipes.
 * <p>
 * Input
 * The first line contains an integer T denoting the number of test cases. For each test case, the first line
 * contains two integer n & p denoting the number of houses and number of pipes respectively. Next, p lines
 * contain 3 integer inputs a, b & d, d denoting the diameter of the pipe from the house a to house b.
 * Constraints:1<=T<=50，1<=n<=20，1<=p<=50，1<=a, b<=20，1<=d<=100
 * <p>
 * Output
 * For each test case, the output is the number of pairs of tanks and taps installed i.e n followed by n lines
 * that contain three integers: house number of tank, house number of tap and the minimum diameter of pipe between
 * them.
 * <p>
 * Sample Input 1
 * 1
 * 9 6
 * 7 4 98
 * 5 9 72
 * 4 6 10
 * 2 8 22
 * 9 7 17
 * 3 1 66
 * <p>
 * Sample Output 1
 * 3
 * 2 8 22
 * 3 1 66
 * 5 6 10
 */
public class PipelineNetwork {

    // TODO Greedy
    // 房屋数量和管道数量
    static int n, p;

    // 数组start存储管道的起始端
    static int start[] = new int[1100];

    // 数组end存储管道的终点
    static int end[] = new int[1100];

    // diameter数组存储两个管道之间的直径值
    static int diameter[] = new int[1100];

    static List<Integer> a = new ArrayList<Integer>();
    static List<Integer> b = new ArrayList<Integer>();
    static List<Integer> c = new ArrayList<Integer>();

    static int ans;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            for (int j = 0; j < 1100; j++) {
                end[j] = start[j] = diameter[j] = 0;
            }

            String[] s = sc.nextLine().trim().split(" ");
            n = Integer.parseInt(s[0]);
            p = Integer.parseInt(s[1]);

            int[][] arr = new int[p][3];
            for (int j = 0; j < p; j++) {
                String[] s1 = sc.nextLine().trim().split(" ");
                arr[j][0] = Integer.parseInt(s1[0]);
                arr[j][1] = Integer.parseInt(s1[1]);
                arr[j][2] = Integer.parseInt(s1[2]);
            }
            solve(arr);

            numbers--;
        }
    }

    static void solve(int arr[][]) {
        int i = 0;

        while (i < p) {
            int q = arr[i][0];
            int h = arr[i][1];
            int t = arr[i][2];

            start[q] = h;
            diameter[q] = t;
            end[h] = q;
            i++;
        }

        a = new ArrayList<Integer>();
        b = new ArrayList<Integer>();
        c = new ArrayList<Integer>();

        for (int j = 1; j <= n; j++) {
            // 如果管道没有结束顶点但具有起始顶点，即是输出管道，那么我们需要从该顶点开始DFS
            if (end[j] == 0 && start[j] > 0) {
                ans = 1000000000;
                int w = dfs(j);

                a.add(j);
                b.add(w);
                c.add(ans);
            }
        }

        System.out.println(a.size());

        for (int j = 0; j < a.size(); j++) {
            System.out.println(a.get(j) + " " + b.get(j) + " " + c.get(j));
        }
    }

    static int dfs(int w) {
        if (start[w] == 0) {
            return w;
        }
        if (diameter[w] < ans) {
            ans = diameter[w];
        }

        return dfs(start[w]);
    }
}
