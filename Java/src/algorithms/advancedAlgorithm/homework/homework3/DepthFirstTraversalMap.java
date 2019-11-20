package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.*;

/**
 * Description
 * 按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。
 *
 * Input
 * 输入第一行是用例个数，后面每个用例使用多行表示，用例的第一行是图中节点的个数n和起始点，用空格隔开，后面n+1行为图的邻接矩阵，
 * 其中第一行为节点名称。值之间使用空格隔开。
 *
 * Output
 * 输出深度优先遍历中遇到的最大深度。
 */
public class DepthFirstTraversalMap {

    public static List<String> vertexList;
    public static Integer[][] edges;
    public static int maxDepth;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            int n = sc.nextInt();
            String start = sc.next();
            maxDepth = 0;

            // 存储点
            vertexList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vertexList.add(sc.next());
            }

            // 存储边
            edges = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                String temp = sc.next();
                for (int j = 0; j < n; j++) {
                    edges[i][j] = Integer.parseInt(sc.next());
                }
            }

            int startPoint = vertexList.indexOf(start);
            boolean[] visit = new boolean[n];

            depthFirstSearch(startPoint, visit);
            System.out.println(maxDepth);

            numbers--;
        }
    }

    public static void depthFirstSearch(int i, boolean[] visit) {

        visit[i] = true;
        maxDepth++;

        int neighbor = getFirstNeighbor(i);
        while (neighbor != -1) {
            if (!visit[neighbor]) {
                depthFirstSearch(neighbor, visit);
            }
            neighbor = getNextNeighbor(i, neighbor);
        }
    }

    // 返回结点i的数据
    public static String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 得到第一个邻接结点的下标
    public static int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根据前一个邻接结点的下标来取得下一个邻接结点
    public static int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
}
