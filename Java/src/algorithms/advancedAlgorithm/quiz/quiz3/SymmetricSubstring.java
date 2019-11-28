package algorithms.advancedAlgorithm.quiz.quiz3;

/**
 * Created by thpffcj on 2019/10/31.
 */

import java.util.Scanner;

/**
 * Description A班
 * Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the
 * substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 *
 * Input
 * 输入第一行是测试用例的个数，后面每一行表示一个数字组成的字符串，例如："123123"
 *
 * Output
 * 输出找到的满足要求的最长子串的长度。例如，给定的例子长度应该是 6。每行对应一个用例的结果。
 *
 * Sample Input 1
 * 1
 * 1538023
 *
 * Sample Output 1
 * 4
 */
public class SymmetricSubstring {

    // TODO 考试
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            int result = findLength(sc.nextLine());
            System.out.println(result);
        }
    }

    public static int findLength(String str) {

        int n = str.length();
        int maxlen = 0; // Initialize result

        // A 2D table where sum[i][j] stores
        // sum of digits from str[i] to str[j].
        // Only filled entries are the entries
        // where j >= i
        int sum[][] = new int[n][n];

        // Fill the diagonal values for
        // substrings of length 1
        for (int i = 0; i < n; i++) {
            sum[i][i] = str.charAt(i) - '0';
        }

        // Fill entries for substrings of
        // length 2 to n
        for (int len = 2; len <= n; len++) {
            // Pick i and j for current substring
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                int k = len/2;

                // Calculate value of sum[i][j]
                sum[i][j] = sum[i][j-k] + sum[j-k+1][j];

                // Update result if 'len' is even,
                // left and right sums are same
                // and len is more than maxlen
                if (len % 2 == 0 && sum[i][j-k] ==
                        sum[(j-k+1)][j] && len > maxlen)
                    maxlen = len;
            }
        }
        return maxlen;
    }
}
