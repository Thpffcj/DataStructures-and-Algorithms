package algorithms.networkMeasurement.byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/1.
 *
 * 有一个仅包含’a’和’b’两种字符的字符串s，长度为n，每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，或者把一个’b’置成’a’)；但是
 * 操作的次数有上限m，问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。
 *
 * 输入描述:
 * 第一行两个整数 n , m (1<=m<=n<=50000)，第二行为长度为n且只包含’a’和’b’的字符串s。
 *
 * 输出描述:
 * 输出在操作次数不超过 m 的情况下，能够得到的 最大连续 全’a’子串或全’b’子串的长度。
 *
 * 输入例子1:
 * 8 1
 * aabaabaa
 *
 * 输出例子1:
 * 5
 *
 * 例子说明1:
 * 把第一个 'b' 或者第二个 'b' 置成 'a'，可得到长度为 5 的全 'a' 子串。
 */
public class BigData201811 {

    /**
     * 利用前缀和数组
     * 例如：
     * n=10, m=1, s=baabaabaab
     * b a a b a a b a a b
     * 0 1 2 3 4 5 6 7 8 9
     *
     * 将 b-->a
     * b 的前缀和数组为
     *   sums={ 0, 3, 6, 9, 10}//10 为字符串长度
     * 计算长度分别为:
     *         3  6-0-1=5   9-3-1=5  10-6-1=3
     *    ==>>max = max{ max, sums[i]-sum[i-m-1]-1}
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        System.out.println(Math.max(maxLength(n, m, s, 'a'), maxLength(n, m, s, 'b')));
    }

    public static int maxLength(int n, int m, String s, char k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == k) {
                list.add(i);
            }
        }
        list.add(n);

        if (list.size() < m) {
            return n;
        }

        int max = list.get(m);
        for (int i = m + 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) - list.get(i - m - 1) - 1);
        }
        return max;
    }

}
