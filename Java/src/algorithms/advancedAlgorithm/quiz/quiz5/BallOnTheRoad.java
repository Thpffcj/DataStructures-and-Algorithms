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
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long arr1[] = new long[n];
            long arr2[] = new long[m];
            for (int i = 0; i < n; ++i) {
                arr1[i] = sc.nextLong();
            }
            for (int i = 0; i < m; ++i) {
                arr2[i] = sc.nextLong();
            }

            long mSum = 0;
            int sum1 = 0;
            int sum2 = 0;
            int f = 0;
            int s = 0;
            while (f < arr1.length || s < arr2.length) {
                if (f >= arr1.length) {
                    while (s < arr2.length) {
                        sum2 += arr2[s++];
                    }
                    mSum += Math.max(sum1, sum2);
                } else if (s >= arr2.length) {
                    while (f < arr1.length) {
                        sum1 += arr1[f++];
                    }
                    mSum += Math.max(sum1, sum2);
                } else {
                    if (arr1[f] > arr2[s]) {
                        sum2 += arr2[s];
                        s++;
                    } else if (arr1[f] < arr2[s]) {
                        sum1 += arr1[f];
                        f++;
                    } else {
                        sum1 += arr1[f];
                        sum2 += arr2[s];
                        mSum += Math.max(sum1, sum2);
                        f++;
                        s++;
                        sum1 = 0;
                        sum2 = 0;
                    }
                }
            }
            System.out.println(mSum);

            numbers--;
        }
    }
}
