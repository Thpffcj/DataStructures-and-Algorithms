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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int case_num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < case_num; i++) {
            long query = Long.parseLong(sc.nextLine());
            System.out.println(solution(query));
        }
    }

    private static char solution(long pos) {
        if (pos <= 0) {
            return '\0';
        }
        long k = 1;
        long len = 11;
        String str = "112345$54321";
        while (len < pos) {
            k++;
            len = 2 * len + k;
        }
        while (pos > 11) {
            long cur = (len - k) / 2;
            if (pos > cur) {
                pos = pos - cur;
                if (pos <= k) {
                    return '$';
                }
                pos = pos - k;
            }
            len = cur;
            k--;
        }
        return str.charAt((int) (pos % 11));
    }
}
