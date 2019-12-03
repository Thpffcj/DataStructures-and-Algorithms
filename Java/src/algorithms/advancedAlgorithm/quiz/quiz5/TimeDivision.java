package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.Scanner;

/**
 * Description
 * Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum
 * number of platforms required for the railway station so that no train waits.
 *
 * Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure
 * times must not be same for a train.
 *
 * Input
 * The first line of input contains T, the number of test cases. For each test case, first line will contain an
 * integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting
 * arrival and departure times respectively.
 *
 * Note: Time intervals are in the 24-hourformat(hhmm), preceding zeros are insignificant. 200 means 2:00.
 * Consider the example for better understanding of input.
 *
 * Constraints:1 <= T <= 100，1 <= N <= 1000，1 <= A[i] < D[i] <= 2359
 *
 * Output
 * For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.
 *
 * Sample Input 1
 * 1
 * 6
 * 900 940 950 1100 1500 1800
 * 910 1200 1120 1130 1900 2000
 *
 * Sample Output 1
 * 3
 */
public class TimeDivision {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {
            int N = Integer.parseInt(sc.nextLine().trim());
            String[] arrival = sc.nextLine().split(" ");
            String[] departure = sc.nextLine().split(" ");

            boolean[] left = new boolean[N];
            int result = 1;
            int maxNeed = 1;

            for (int i = 1; i < arrival.length; i++) {
                int arrive = Integer.parseInt(arrival[i]);
                int j = i;
                while (j >= 0) {
                    if (!left[j]) {
                        if (arrive > Integer.parseInt(departure[j])) {
                            result--;
                            left[j] = true;
                        }
                    }
                    j--;
                }

                result++;
                if (result > maxNeed) {
                    maxNeed = result;
                }
            }
            System.out.println(maxNeed);

            numbers--;
        }
    }
}

//1
//6
//900 940 950 1100 1500 1800
//910 1200 1120 1130 1900 2000