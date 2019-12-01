package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description B班
 * Archana is very fond of strings. She likes to solve many questions related to strings. She comes across a
 * problem which she is unable to solve. Help her to solve. The problem is as follows: Given is a string of
 * length L. Her task is to find the longest string from the given string with characters arranged in descending
 * order of their ASCII code and in arithmetic progression. She wants the common difference should be as low as
 * possible(at least 1) and the characters of the string to be of higher ASCII value.
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Each test contains a string
 * s of lengthL.
 *
 * 1<= T <= 100
 * 3<= L <=1000
 * A<=s[i]<=Z
 * The string contains minimum three different characters.
 *
 * Output
 * For each test case print the longest string.Case 1:Two strings of maximum length are possible- “CBA” and “RPQ”.
 * But he wants the string to be of higher ASCII value therefore, the output is “RPQ”.Case 2:The String of maximum
 * length is “JGDA”.
 *
 * Sample Input 1
 * 2
 * ABCPQR
 * ADGJPRT
 *
 * Sample Output 1
 * RQP
 * JGDA
 */
public class TheLargestSumOfContinuousDescendingCharacter {

    // TODO String
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String s = sc.nextLine();
            System.out.println(getMaxDescending(s));
            numbers--;
        }
    }

    public static String getMaxDescending(String s) {

        boolean[] appear = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            appear[s.charAt(i) - 'A'] = true;
        }

        String result = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 25; j >= 0; j--) {
                String temp = "";
                if (appear[j]) {
                    temp += (char)('A' + j);

                    for (int k = j - i; k >= 0; k -= i) {
                        if (appear[k]) {
                            temp += (char)('A' + k);
                        } else {
                            break;
                        }
                    }

                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }
}
