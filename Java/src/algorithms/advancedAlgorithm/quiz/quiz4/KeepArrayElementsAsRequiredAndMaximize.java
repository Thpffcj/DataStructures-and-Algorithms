package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.*;

/**
 * Description A班
 * Given an array of N numbers, we need to maximize the sum of selected numbers. At each step, you need to
 * select a number Ai, delete one occurrence of Ai-1 (if exists) and Ai each from the array. Repeat these
 * steps until the array gets empty. The problem is to maximize the sum of selected numbers.
 *
 * Input
 * The first line of the input contains T denoting the number of the test cases. For each test case, the first line contains an integer n denoting the size of the array. Next line contains n space separated integers denoting the elements of the array.
 *
 * Constraints:1<=T<=100，1<=n<=50，1<=A[i]<=20
 *
 * Note: Numbers need to be selected from maximum to minimum.
 *
 *
 * Output
 * For each test case, the output is an integer displaying the maximum sum of selected numbers.
 *
 * Sample Input 1
 * 2
 * 3
 * 1 2 3
 * 6
 * 1 2 2 2 3 4
 *
 * Sample Output 1
 * 4
 * 10
 */
public class KeepArrayElementsAsRequiredAndMaximize {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            List<Integer> digit = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                digit.add(sc.nextInt());
            }

            Collections.sort(digit);
            int result = 0;
            while (!digit.isEmpty()) {
                int d = digit.remove(digit.size() - 1);
                result += d;
                if (digit.contains(d - 1)) {
                    int position = Collections.binarySearch(digit, d - 1);
                    digit.remove(position);
                }
            }
            System.out.println(result);

            numbers--;
        }
    }
}
