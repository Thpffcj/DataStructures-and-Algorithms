package algorithms.advancedAlgorithm.homework.homework3;

import java.util.*;

/**
 * Created by thpffcj on 2019/11/18.
 */

/**
 * Description
 * 给定有向无环图中所有边，计算图的拓扑排序解的个数。
 *
 * Input
 * 输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。
 *
 * Output
 * 输出拓扑排序解的个数。
 *
 * Sample Input 1
 * 1
 * a c,b c,c d,d e,d f,e g,f g
 *
 * Sample Output 1
 * 4
 */
public class NumberOfTopologicallyOrderedSolutions {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            list = new ArrayList<>();
            String[] infos = sc.nextLine().split(",");

            List<String> edges = new ArrayList<>();
            Set<String> points = new HashSet<>();
            for (int i = 0; i < infos.length; i++) {
                edges.add(infos[i]);
                points.add(infos[i].split(" ")[0]);
                points.add(infos[i].split(" ")[1]);
            }

            findTopological("", points, edges);

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println(list.size());

            numbers--;
        }
    }

    public static void findTopological(String s, Set<String> points, List<String> edges) {

        if (points.size() == 0) {
            list.add(s);
            return;
        }

        Set<String> outPoint = new HashSet<String>();
        List<String> inPoint = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {
            String[] line = edges.get(i).split(" ");
            outPoint.add(line[1]);
        }

        inPoint.addAll(points);
        // 删掉所有有边到达的点
        inPoint.removeAll(outPoint);

        for (int i = 0; i < inPoint.size(); i++) {

            List<String> curEdges = new ArrayList<>();
            // TODO 因为创建了新变量，所以不需要回溯
//            Set<String> allPoint = new HashSet<String>(points);
//            String sTemp = s + inPoint.get(i) + " ";

            s = s + inPoint.get(i) + " ";
            points.remove(inPoint.get(i));

            for (int j = 0; j < edges.size(); j++) {
                String[] line = edges.get(j).split(" ");
                if (!line[0].equals(inPoint.get(i))) {
                    curEdges.add(edges.get(j));
                }
            }

            findTopological(s, points, curEdges);

            // 如果使用了新变量，则不需要回溯
            s = s.substring(0, s.length() - 2);
            points.add(inPoint.get(i));
        }
    }
}
