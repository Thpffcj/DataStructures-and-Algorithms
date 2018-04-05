package algorithms.networkMeasurement.aiqiyi;

/**
 * Created by Thpffcj on 2018/4/5.
 */

import java.util.Scanner;

/**
 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
 * 例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
 * 牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
 *
 * 输入描述:
 * 输入包括两行,第一行一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),其中只包含小写字母('a'-'z')。
 * 第二行包含一个整数k(0 ≤ k ≤ length),即允许移除的字符个数。
 * 输出描述:
 * 输出一个整数,表示得到的最小价值
 *
 * 输入例子1:
 * aba
 * 1
 * 输出例子1:
 * 2
 */
public class StringValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            int[] numbers = new int[26];
            for (int i = 0; i < line.length(); i++) {
                numbers[line.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n; i++) {
                int pos = getMost(numbers);
                numbers[pos]--;
            }
            int res = 0;
            for (int i = 0; i < numbers.length; i++) {
                res += numbers[i] * numbers[i];
            }
            System.out.println(res);
        }
    }

    public static int getMost(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                pos = i;
            }
        }
        return pos;
    }
}
