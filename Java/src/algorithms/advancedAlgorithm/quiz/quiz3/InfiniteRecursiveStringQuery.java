package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */

/**
 * Description A班
 * Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively.
 * In i-th step, A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A),
 * where | denotes concatenation.
 *
 * Constraints:1<=Q<=10^5, 1<=POS<=10^12
 *
 * Input
 * 输入第一行为查询次数，后面为每次查询的具体字符位置。
 *
 * Output
 * 输出每一次查询位置上的字符。
 *
 * Sample Input 1
 * 2
 * 3
 * 10
 *
 * Sample Output 1
 * 3
 * 2
 */
public class InfiniteRecursiveStringQuery {

    // TODO
    public static char[] digits =  new char[]{'1', '2', '3', '4', '5', '$', '5', '4', '3', '2', '1'};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            long n = sc.nextLong();

            boolean isDollar = false;
            long end = 11;
            int round = 1;
            while (n > end) {
                round++;
                if (n < end + round) {
                    System.out.println("$");
                    isDollar = true;
                }
                end = end * 2 + round;
            }

            if (!isDollar) {
                while (n > 11) {
                    n = (int) (n - ((n - round) / 2 + round));
                    round--;
                }
                System.out.println(digits[(int) (n - 1)]);
            }
        }
    }

}
