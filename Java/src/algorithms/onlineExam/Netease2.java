package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/27.
 */

/**
 * 牛牛以前在老师那里得到了一个正整数数对(x,y)，牛牛忘记他们具体是多少了。
 * 但是牛牛记得老师告诉过他x和y均不大于n，并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * 输入描述：
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述：
 * 对于每个测试用例，输出一个正整数表示可能的数对数量。
 */
public class Netease2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j == i) {
                        continue;
                    }
                    if (i%j >= k) {
//                        System.out.println(i + " " + j);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
