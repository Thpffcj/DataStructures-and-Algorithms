package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.*;

/**
 * Description
 * There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls.
 * The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them.
 * Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are
 * sorted in increasing order, then geek will start from the left side of the road). The geek can change the road
 * only at the point of intersection(which means, buckets with the same number of balls on two roads). Now you
 * need to help Geek to collect the maximum number of balls.
 * <p>
 * <p>
 * Input
 * The first line of input contains T denoting the number of test cases. The first line of each test case contains
 * two integers N and M, denoting the number of buckets on road1 and road2 respectively. 2nd line of each test
 * case contains N integers, number of balls in buckets on the first road. 3rd line of each test case contains M
 * integers, number of balls in buckets on the second road.
 * <p>
 * Constraints:1<= T <= 1000，1<= N <= 10^3，1<= M <=10^3，0<= A[i],B[i]<=10^6
 * <p>
 * <p>
 * Output
 * For each test case output a single line containing the maximum possible balls that Geek can collect.
 * <p>
 * Sample Input 1
 * 1
 * 5 5
 * 1 4 5 6 8
 * 2 3 4 6 9
 * <p>
 * Sample Output 1
 * 29
 */
public class BallOnTheRoad {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {

            String[] infos = sc.nextLine().split(" ");
            int n = Integer.parseInt(infos[0]);
            int m = Integer.parseInt(infos[1]);

            String[] line1 = sc.nextLine().split(" ");
            int[] road1 = new int[line1.length];
            for (int i = 0; i < road1.length; i++) {
                road1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = sc.nextLine().split(" ");
            int[] road2 = new int[line2.length];
            for (int i = 0; i < road2.length; i++) {
                road2[i] = Integer.parseInt(line2[i]);
            }

            int r1 = 0;
            int r2 = 0;
            int sum1 = 0;
            int sum2 = 0;
            int result = 0;
            while (r1 < road1.length || r2 < road2.length) {
                if (r1 >= road1.length) {
                    while (r2 < road2.length) {
                        sum2 += road2[r2];
                        r2++;
                    }
                    result += Math.max(sum1, sum2);
                } else if (r2 >= road2.length) {
                    while (r1 < road1.length) {
                        sum1 += road1[r1];
                        r1++;
                    }
                    result += Math.max(sum1, sum2);
                } else {
                    if (road1[r1] < road2[r2]) {
                        sum1 += road1[r1];
                        r1++;
                    } else if (road1[r1] > road2[r2]) {
                        sum2 += road2[r2];
                        r2++;
                    } else {
                        sum1 += road1[r1];
                        sum2 += road2[r2];
                        result += Math.max(sum1, sum2);
                        sum1 = 0;
                        sum2 = 0;
                        r1++;
                        r2++;
                    }
                }
            }

            System.out.println(result);
            numbers--;
        }
    }
}
