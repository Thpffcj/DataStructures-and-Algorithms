package algorithms.advancedAlgorithm.homework.homework3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/11/18.
 */

/**
 * Description
 * 按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。
 *
 * Input
 * 输入第一行为测试用例个数，后面每一个用例用多行表示，用例第一行是节点个数n和开始顶点，用空格隔开，后面n+1行为图的邻接矩阵，
 * 其中第一行为节点名称。值之间使用空格隔开。
 *
 * Output
 * 输出遍历顺序，用空格隔开
 *
 * Sample Input 1
 * 1
 * 4 a
 * a b c d
 * a 0 1 1 0
 * b 1 0 1 0
 * c 1 1 0 1
 * d 0 0 1 0
 *
 * Sample Output 1
 * a b c d
 */
public class BreadthFirstTraversalMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            int n = sc.nextInt();
            String start = sc.next();

            Queue<String> queue = new LinkedList<>();

            String[][] graph = new String[n][n];


            numbers--;
        }
    }
}
