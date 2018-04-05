package algorithms.networkMeasurement.jingdong;

/**
 * Created by Thpffcj on 2018/3/28.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。
 *
 * 输入描述:
 * 每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。后两行分别表示集合A和集合B。
 * 每个元素为不超过int范围的整数,每个元素之间有个空格隔开。
 * 输出描述:
 * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开,行末无空格。
 *
 * 输入例子1:
 * 3 3
 * 1 3 5
 * 2 4 6
 * 输出例子1:
 * 1 2 3 4 5 6
 */
public class Sets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            int max = Integer.MIN_VALUE;
            int cur = 0;
            for (int i = 0; i < m; i++) {
                cur = sc.nextInt();
                if (cur > max) {
                    max = cur;
                }
                set.add(cur);
            }
            for (int i = 0; i < n; i++) {
                cur = sc.nextInt();
                if (cur > max) {
                    max = cur;
                }
                set.add(cur);
            }
            for (int i = 0; i < max; i++) {
                if (set.contains(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(max);
        }
    }
}
