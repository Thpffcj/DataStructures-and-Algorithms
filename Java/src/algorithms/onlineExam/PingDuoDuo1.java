package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */

/**
 * 给出n个气温采样(左闭右闭区间)，输出气温的可信最大值与可信最小值。可信的条件是该温度值被至少k个采样覆盖。
 *
 * 输出描述：
 * 第一行包含2个正整数n和k，意思与题目描述中相同。
 * 接下来是n行。每行分别有2个整数low_i和high_i(之间用一个空格隔开)，分别表示第i个采样点的最低温度和最高温度。
 * 数据范围：
 * 0 < k <= n <= 1000
 * -50 <= low_i <= high_i <= 50
 * 输出描述：
 * 输出一行包含两个整数Tmin和Tmax(之间用一个空格隔开)，分别表示可信最小值与可信最大值。
 * 若不存在可信最小值与可信最大值，则输出字符串"error"。
 *
 * 输入：
 * 4 2
 * 0 1
 * 1 3
 * 2 4
 * 3 5
 * 输出：
 * 1 4
 */
public class PingDuoDuo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int[] res = new int[100];
            for (int i = 0; i < n; i++) {
                int low = sc.nextInt();
                int high = sc.nextInt();
                for (int j = low + 50; j <= high + 50; j++) {
                    res[j]++;
                }
            }
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < res.length; i++) {
                if (res[i] >= k) {
                    min = i - 50;
                    break;
                }
            }
            for (int i = res.length - 1; i >= 0; i--) {
                if (res[i] >= k) {
                    max = i - 50;
                    break;
                }
            }
            if (min == Integer.MIN_VALUE) {
                System.out.println("error");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
