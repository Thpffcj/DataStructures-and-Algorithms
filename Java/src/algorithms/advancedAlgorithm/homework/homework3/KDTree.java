package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.*;

/**
 * Description
 * 对给定的点集合构造KD树，要求如下：将方差最大的维度作为当前的分割维度，将数据集在分割维度上排序后的中位数作为分割点。程序
 * 要检索给定点对应的最近的K个点的坐标。
 * <p>
 * Input
 * 输入第一行为测试用例个数，后面为测试用例，每一个用例包含三行，第一行为点集合（点之间用逗号隔开，两个坐标用空格隔开），第二
 * 行为检索的点，第三行为K值。
 * <p>
 * Output
 * 输出每一个用例的最近K个点，按照距离从小到大的顺序打印。
 * <p>
 */
public class KDTree {

    public static class Point {

        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static double getDistance(Point p1, Point p2) {
            return Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2);
        }

        public String toString() {
            String result = "";
            if (x == (int) x) {
                result += (int) x;
            } else {
                result += x;
            }

            result += " ";

            if (y == (int) y) {
                result += (int) y;
            } else {
                result += y;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {
            String[] line = sc.nextLine().split(",");
            Point[] point = new Point[line.length];

            for (int i = 0; i < line.length; i++) {
                point[i] = new Point(Double.parseDouble(line[i].split(" ")[0]),
                        Double.parseDouble(line[i].split(" ")[1]));
            }

            String[] s = sc.nextLine().split(" ");
            Point queryPoint = new Point(Double.parseDouble(s[0]), Double.parseDouble(s[1]));

            int k = Integer.parseInt(sc.nextLine());

            double[] distance1 = new double[point.length];
            List<Double> distance2 = new ArrayList<>();
            for (int i = 0; i < point.length; i++) {
                double d = Point.getDistance(point[i], queryPoint);
                distance1[i] = d;
                distance2.add(d);
            }

            Arrays.sort(distance1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(point[distance2.indexOf(distance1[i])]).append(",");
                distance2.set(distance2.indexOf(distance1[i]), (double) Integer.MAX_VALUE);
            }

            System.out.println(sb.substring(0, sb.length() - 1));

            numbers--;
        }
    }
}
