package algorithms.networkMeasurement.netease;

/**
 * Created by thpffcj on 2019/12/30.
 */

import java.util.Scanner;

/**
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 *
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 *
 * 输入例子1:
 * 5 2
 *
 * 输出例子1:
 * 7
 *
 * 例子说明1:
 * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 */
public class NumberPairs {

    // 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
    // case通过率为20.00%
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int k = sc.nextInt();
//
//            long result = 0;
//            for (int i = k; i <= n; i++) {
//                for (int j = k; j <= n; j++) {
//                    if (i < j) {
//                        if (i >= k) {
//                            result += n - i;
//                            break;
//                        }
//                    }
//
//                    if (i % j >= k) {
//                       result++;
//                    }
//                }
//            }
//            System.out.println(result);
//        }
//    }

    // TODO
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long count = 0;

        // k为0的话直接就是n的平方
        if (k == 0) { {
            System.out.println(n * n);
        }} else{
            for (long i = k + 1; i <= n; i++) {
                // 找前(n / i * i)个数里面有几个循环节，每一个节有(i - k)个数
                count += (n / i) * (i - k);
                if (n % i >= k) {
                    // 剩下的数不足一个循环节，找第(n / i * i + 1 , n)里面有几个数满足题
                    count += n % i - k + 1;
                }
            }
            System.out.println(count);
        }
    }
}
