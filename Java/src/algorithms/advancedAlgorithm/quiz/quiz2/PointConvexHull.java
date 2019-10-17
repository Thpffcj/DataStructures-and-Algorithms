package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/17.
 */

public class PointConvexHull {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // To find orientation of ordered triplet (p, q, r).
    // The function returns following values
    // 0 --> p, q and r are colinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    // Prints convex hull of a set of n points.
    public static void convexHull(Point points[], int n) {
        // There must be at least 3 points
        if (n < 3) return;

        // Initialize Result
        List<Point> hull = new ArrayList<>();

        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        // Start from leftmost point, keep moving
        // counterclockwise until reach the start point
        // again. This loop runs O(h) times where h is
        // number of points in result or output.
        int p = l, q;
        do {
            // Add current point to result
            hull.add(points[p]);

            // Search for a point 'q' such that
            // orientation(p, x, q) is counterclockwise
            // for all points 'x'. The idea is to keep
            // track of last visited most counterclock-
            // wise point in q. If any point 'i' is more
            // counterclock-wise than q, then update q.
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                // If i is more counterclockwise than
                // current q, then update q
                if (orientation(points[p], points[i], points[q])
                        == 2)
                    q = i;
            }

            // Now q is the most counterclockwise with
            // respect to p. Set p as q for next iteration,
            // so that q is added to result 'hull'
            p = q;

        } while (p != l);  // While we don't come to first
        // point

        // Print Result
        // 正数代表第二个值大于第一个值
        hull.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y > o2.y) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        String result = "";
        for (Point temp : hull) {
            result += temp.x + " " + temp.y + ", ";
        }
        if (result.equals("")) {
            System.out.println(-1);
        } else {
            System.out.println(result.substring(0, result.length() - 2));
        }
    }
    /* Driver program to test above function */

    /**
     * 2
     * 3
     * 1 2 3 1 5 6
     * 3
     * 1 2 4 4 5 1
     * @param args
     */
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
            convexHull(points, n);
        }
    }
}

