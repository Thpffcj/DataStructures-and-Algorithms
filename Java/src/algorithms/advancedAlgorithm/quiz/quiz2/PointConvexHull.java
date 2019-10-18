package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/17.
 */

public class PointConvexHull {

    public static class Point {
        private int x;
        private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setX(int x){
            this.x = x;
        }

        public int getX(){
            return x;
        }

        public void setY(int y){
            this.y = y;
        }

        public int getY(){
            return y;
        }
    }

    // 蛮力法解决凸包问题，返回点集合中凸多边形的点集合
    public static void getConvexPoint(Point[] A) {
        Point[] result = new Point[A.length];
        int len = 0;  //用于计算最终返回结果中是凸包中点的个数
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == i)     //除去选中作为确定直线的第一个点
                    continue;

                int[] judge = new int[A.length];   //存放点到直线距离所使用判断公式的结果

                for (int k = 0; k < A.length; k++) {
                    int a = A[j].getY() - A[i].getY();
                    int b = A[i].getX() - A[j].getX();
                    int c = (A[i].getX()) * (A[j].getY()) - (A[i].getY()) * (A[j].getX());

                    judge[k] = a * (A[k].getX()) + b * (A[k].getY()) - c;  //根据公式计算具体判断结果
                }

                if (JudgeArray(judge)) {  // 如果点均在直线的一边,则相应的A[i]是凸包中的点
                    result[len++] = A[i];
                    break;
                }
            }
        }
        Point[] result1 = new Point[len];
        for (int m = 0; m < len; m++) {
            result1[m] = result[m];
        }

        String output = "";
        for (int i = 0; i < result1.length; i++) {
            output += result1[i].x + " " + result1[i].y + ", ";
        }
        System.out.println(output.substring(0, output.length() - 2));
    }

    // 判断数组中元素是否全部大于等于0或者小于等于0，如果是则返回true，否则返回false
    public static boolean JudgeArray(int[] Array){
        boolean judge = false;
        int len1 = 0, len2 = 0;

        for(int i = 0;i < Array.length;i++){
            if(Array[i] >= 0)
                len1++;
        }
        for(int j = 0;j < Array.length;j++){
            if(Array[j] <= 0)
                len2++;
        }

        if(len1 == Array.length || len2 == Array.length)
            judge = true;
        return judge;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            int n = sc.nextInt();
            Point points[] = new Point[n];
            int position = 0;
            for (int i = 0; i < n; i++) {
                points[position] = new Point(sc.nextInt(), sc.nextInt());
                position++;
            }
            getConvexPoint(points);
        }
    }
}

//        hull.sort(new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                if (o1.x > o2.x) {
//                    return 1;
//                } else if (o1.x == o2.x) {
//                    if (o1.y > o2.y) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                } else {
//                    return -1;
//                }
//            }
//        });