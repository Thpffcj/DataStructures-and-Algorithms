package algorithms.networkMeasurement.netease;

/**
 * Created by Thpffcj on 2018/3/27.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法
 * 计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 *
 * 输入描述:
 * 输入为一个整数，即为圆半径的平方,范围在32位int范围内。
 * 输出描述:
 * 输出为一个整数，即为优雅的点的个数
 *
 * 输入例子1:
 * 25
 * 输出例子1:
 * 12
 */
public class ElegantPoint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int r2 = sc.nextInt();
            int r = (int) Math.sqrt(r2);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i <= r; i++) {
                set.add(i * i);
            }
            int res = 0;
            for (int i = 0; i <= r; i++) {
                int k = r2 - i * i;
                if (set.contains(k)) {
                    res++;
                }
            }
            if (r * r == r2) {
                res--;
            }
            System.out.println(4 * res);
        }
    }
}
