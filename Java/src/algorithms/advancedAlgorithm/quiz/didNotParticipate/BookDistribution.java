package algorithms.advancedAlgorithm.quiz.didNotParticipate;

/**
 * Created by thpffcj on 2019/11/6.
 */

import java.util.Scanner;

/**
 * Description
 * You are given N number of books. Every ith book has Pi number of pages. You have to allocate books to
 * M number of students. There can be many ways or permutations to do so. In each permutation one of the
 * M students will be allocated the maximum number of pages. Out of all these permutations, the task is
 * to find that particular permutation in which the maximum number of pages allocated to a student is
 * minimum of those in all the other permutations, and print this minimum value. Each book will be
 * allocated to exactly one student. Each student has to be allocated atleast one book.
 *
 * Input
 * The first line contains 'T' denoting the number of testcases. Then follows description of T
 * testcases:Each case begins with a single positive integer N denoting the number of books.The second
 * line contains N space separated positive integers denoting the pages of each book.And the third line
 * contains another integer M, denoting the number of students
 * Constraints:1<= T <=70，1<= N <=50，1<= A [ i ] <=250，1<= M <=50，
 * Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous
 * order (see explanation for better understanding)
 *
 * Output
 * For each test case, output a single line containing minimum number of pages each student has to read
 * for corresponding test case.
 *
 * Sample Input 1
 * 1
 * 4
 * 12 34 67 90
 * 2
 *
 * Sample Output 1
 * 113
 */
public class BookDistribution {

    // TODO 和PaintDogHouse是一道题
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] infos = sc.nextLine().split(" ");

            int[] digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = Integer.parseInt(infos[i]);
            }

            int m = Integer.parseInt(sc.nextLine());

            System.out.println(findPages(digit, n, m));

            numbers--;
        }
    }

    /**
     * 二分查找可以分配的额度
     */
    public static int findPages(int digit[], int n, int m) {

        if (n < m) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += digit[i];
        }

        int start = 0;
        int end = sum;
        int result = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(digit, n, m, mid)) {
                result = Math.min(result, mid);

                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int digit[], int n, int m, int currMin) {

        int studentsRequired = 1;
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            if (digit[i] > currMin) {
                return false;
            }

            // 如果大于分配额度，将任务分配给下一个人
            if (currSum + digit[i] > currMin) {
                studentsRequired++;
                currSum = digit[i];

                // 如果需要的人数大于m，则不符合要求
                if (studentsRequired > m) {
                    return false;
                }
            } else {
                currSum += digit[i];
            }
        }
        return true;
    }
}
