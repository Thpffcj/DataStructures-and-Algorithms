package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description B班
 * In a given cartesian plane, there are N points. We need to find the Number of Pairs of points(A,B) such that
 *
 * Point A and Point B do not coincide.
 * Manhattan Distance and the Euclidean Distance between the points should be equal.
 * Note : Pair of 2 points(A,B) is considered same as Pair of 2 points(B,A).
 *
 * Manhattan Distance = |x2-x1|+|y2-y1|
 *
 * Euclidean Distance = ((x2-x1)^2 + (y2-y1)^2)^0.5 where points are (x1,y1) and (x2,y2).
 *
 * Constraints:1<=T <= 50, 1<=N <= 2*10 ^ 5, 0<=(|Xi|, |Yi|) <= 10^9
 *
 *
 * Input
 * First Line Consist of T - number of test cases. For each Test case:First Line consist of N , Number of points. Next line contains N pairs contains two integers Xi and Yi，i.e, X coordinate and the Y coordinate of a Point
 *
 *
 * Output
 * Print the number of pairs as asked above.
 *
 * Sample Input 1
 * 1
 * 2
 * 1 1
 * 7 5
 *
 * Sample Output 1
 * 0
 */
public class DistanceProblem {

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
