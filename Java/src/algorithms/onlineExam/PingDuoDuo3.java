package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */

//4
//0 0
//0 1
//1 0
//1 1
public class PingDuoDuo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            Triangle[] t = new Triangle[n];
            for (int i = 0; i < n; i++) {
                Triangle triangle = new Triangle();
                triangle.x = sc.nextDouble();
                triangle.y = sc.nextDouble();
                t[i] = triangle;
            }
            int res = 0;
            for (int i = 0; i < t.length - 2; i++) {
                for (int j = i + 1; j < t.length - 1; j++) {
                    for (int m = j + 1; m < t.length; m++) {
                        if (isTriangle(t[i], t[j], t[m])) {
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static boolean isTriangle(Triangle a, Triangle b, Triangle c) {
        if (a.x == b.x && b.x == c.x) {
            return false;
        }
        if (a.y == b.y && b.y == c.y) {
            return false;
        }
        if (((b.y - a.y) / (b.x - a.x)) == ((c.y - b.y) / (c.x - b.x))) {
            return false;
        }
        return true;
    }

    static class Triangle {
        double x;
        double y;
    }
}
