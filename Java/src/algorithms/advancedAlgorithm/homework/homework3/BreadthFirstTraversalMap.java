package algorithms.advancedAlgorithm.homework.homework3;

import java.util.*;

/**
 * Created by thpffcj on 2019/11/18.
 */

/**
 * Description
 * 按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。
 * <p>
 * Input
 * 输入第一行为测试用例个数，后面每一个用例用多行表示，用例第一行是节点个数n和开始顶点，用空格隔开，后面n+1行为图的邻接矩阵，
 * 其中第一行为节点名称。值之间使用空格隔开。
 * <p>
 * Output
 * 输出遍历顺序，用空格隔开
 * <p>
 * Sample Input 1
 * 1
 * 4 a
 * a b c d
 * a 0 1 1 0
 * b 1 0 1 0
 * c 1 1 0 1
 * d 0 0 1 0
 * <p>
 * Sample Output 1
 * a b c d
 */
public class BreadthFirstTraversalMap {

    public static List<String> vertexList;
    public static Integer[][] edges;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            int n = sc.nextInt();
            String start = sc.next();

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
            broadFirstSearch(startPoint, visit);

            numbers--;
        }
    }

    public static void broadFirstSearch(int i, boolean[] visit) {

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(getValueByIndex(i)).append(" ");
        visit[i] = true;
        queue.add(i);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int neighbor = getFirstNeighbor(current);
            while (neighbor != -1) {
                if (!visit[neighbor]) {
                    sb.append(getValueByIndex(neighbor)).append(" ");
                    visit[neighbor] = true;
                    queue.add(neighbor);
                }
                // 寻找下一个邻接节点
                neighbor = getNextNeighbor(current, neighbor);
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));
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
