package algorithms.networkMeasurement.aiqiyi;

/**
 * Created by Thpffcj on 2018/4/19.
 */

import java.util.Scanner;

/**
 * 牛牛举办了一场数字游戏,有n个玩家参加这个游戏,游戏开始每个玩家选定一个数,然后将这个数写在纸上(十进制数,无前缀零),然后接下
 * 来对于每一个数字将其数位按照非递减顺序排列,得到新的数,新数的前缀零将被忽略。得到最大数字的玩家赢得这个游戏。
 *
 *  输入描述:
 * 输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 50),即玩家的人数
 * 第二行n个整数x[i](0 ≤ x[i] ≤ 100000),即每个玩家写下的整数。
 * 输出描述:
 * 输出一个整数,表示赢得游戏的那个玩家获得的最大数字是多少。
 *
 * 输入例子1:
 * 3
 * 9638 8210 331
 * 输出例子1:
 * 3689
 */
public class NumbersGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] numbers = sc.nextLine().split(" ");
            int max = -1;
            for (int i = 0; i < numbers.length; i++) {
                int cur = transform(numbers[i]);
                if (cur > max) {
                    max = cur;
                }
            }
            System.out.println(max);
        }
    }

    private static int transform(String s) {
        int[] n = new int[10];
        for (int i = 0; i < s.length(); i++) {
            n[s.charAt(i) - '0']++;
        }
        String res = "";
        for (int i = 1; i< n.length; i++) {
            for (int j = 0; j < n[i]; j++) {
                res += i;
            }
        }
        return Integer.parseInt(res);
    }
}
