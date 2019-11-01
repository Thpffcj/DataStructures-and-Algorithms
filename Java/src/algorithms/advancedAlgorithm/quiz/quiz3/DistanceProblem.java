package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */
public class DistanceProblem {

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int numbers = Integer.parseInt(sc.nextLine());
//        for (int number = 0; number < numbers; number++) {
//
//            int pointNumber = Integer.parseInt(sc.nextLine());
//
//            Point[] points = new Point[pointNumber];
//            for (int i = 0; i < pointNumber; i++) {
//                String[] line = sc.nextLine().split(" ");
//                points[i] = new Point(Long.parseLong(line[0]), Long.parseLong(line[1]));
//            }
//
//            int result = 0;
//            for (int i = 0; i < points.length - 1; i++) {
//                for (int j = i + 1; j < points.length; j++) {
//                    if (Point.manhattan(points[i], points[j]).equals(Point.euclid(points[i], points[j]))) {
//                        result++;
//                    }
//                }
//            }
//            System.out.println(result);
//        }
//    }
//
//    public static class Point {
//        public long x;
//        public long y;
//
//        public Point(long x, long y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public static Double manhattan(Point p1, Point p2) {
//            return Double.valueOf(Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));
//        }
//
//        public static Double euclid(Point p1, Point p2) {
//            return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
//        }
//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            int n = sc.nextInt();
            int xans = 0;
            int yans = 0;
            int xyans = 0;

            HashMap<Integer, Integer> X = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> Y = new HashMap<Integer, Integer>();
            HashMap<String, Integer> XY = new HashMap<String, Integer>();

            while (n-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (!X.containsKey(x))
                    X.put(x, 0);
                X.put(x, X.get(x) + 1);
                if (!Y.containsKey(y))
                    Y.put(y, 0);
                Y.put(y, Y.get(y) + 1);
                String s = x + " " + y;
                if (!XY.containsKey(s))
                    XY.put(s, 0);
                XY.put(s, XY.get(s) + 1);
            }
            for (int i : X.keySet()) {
                int d = X.get(i);
                xans += (d * (d - 1)) / 2;
            }
            for (int i : Y.keySet()) {
                int d = Y.get(i);
                yans += d * (d - 1) / 2;
            }
            for (String i : XY.keySet()) {
                int d = XY.get(i);
                xyans += d * (d - 1);
            }

            System.out.println(xans + yans - xyans);
        }
    }
}
