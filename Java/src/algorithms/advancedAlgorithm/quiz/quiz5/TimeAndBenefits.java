package algorithms.advancedAlgorithm.quiz.quiz5;

/**
 * Created by thpffcj on 2019/11/28.
 */

import java.util.Scanner;

/**
 * Description
 * Given a set of n jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of
 * time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is
 * completed by its deadline. The task is to find the maximum profit and the number of jobs done.
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases.Each test case consist of an
 * integer N denoting the number of jobs and the next line consist of Job id, Deadline and the Profit associated
 * to that Job.
 *
 * Constraints:1<=T<=100，1<=N<=100，1<=Deadline<=100，1<=Profit<=500
 *
 * Output
 * Output the number of jobs done and the maximum profit.
 *
 * Sample Input 1
 * 2
 * 4
 * 1 4 20 2 1 10 3 1 40 4 1 30
 * 5
 * 1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
 *
 * Sample Output 1
 * 2 60
 * 2 127
 */
public class TimeAndBenefits {

    // TODO Greedy
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {
            int N = Integer.parseInt(sc.nextLine());
            int[] jobId = new int[N];
            int[] deadline = new int[N];
            int[] value = new int[N];

            String[] line = sc.nextLine().split(" ");
            int p = 0;
            for (int i = 0; i < line.length; i += 3) {
                jobId[p] = Integer.parseInt(line[i]);
                deadline[p] = Integer.parseInt(line[i + 1]);
                value[p] = Integer.parseInt(line[i + 2]);
                p++;
            }

            int result = 0;
            int number = 0;
            // i应该等于最大的deadline
            for (int i = N; i > 0; i--) {
                int max = 0;
                int position = -1;

                for (int j = 0; j < N; j++) {
                    if (deadline[j] >= i) {
                        int v = value[j];
                        if (v > max) {
                            max = v;
                            position = j;
                        }
                    }
                }
                if (position != -1) {
                    result += max;
                    number++;
                    deadline[position] = 0;
                }
            }

            System.out.println(number + " " + result);

            numbers--;
        }
    }
}
