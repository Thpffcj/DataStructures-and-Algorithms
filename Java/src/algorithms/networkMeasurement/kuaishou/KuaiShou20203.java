package algorithms.networkMeasurement.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/19.
 *
 * 给定两个版本号，只有在版本号更高的时候，才可以升级。「.」号作为分割符使用，版本号中只有数和.号。
 * 例如：0.1<1.1
 * 1.2<13.37
 *
 * 输入描述:
 * 第一行为m(1<=m<=100000)，表示测试组数，接下来m行，表示m次查询。
 * 每行两个版本号，空格分隔。一个版本号中最多只会出现3个「.」。每个版本号中数字1<=x<=100。
 *
 * 输出描述:
 * 对于每一次查询，输出是否可以升级，是则输出"true"，否则输出"false" (引号不要输出)
 *
 * 输入例子1:
 * 2
 * 6.6.6 6.6.7
 * 1 1.0
 *
 * 输出例子1:
 * true
 * false
 *
 * 例子说明1:
 * 1和1.0被认为是相同的版本号
 *
 * 输入例子2:
 * 1
 * 1 1.0.0.2
 *
 * 输出例子2:
 * true
 */
public class KuaiShou20203 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        while (m > 0) {
            String[] version = sc.nextLine().split(" ");
            String[] version1 = version[0].split("\\.");
            String[] version2 = version[1].split("\\.");
            int length = Math.max(version1.length, version2.length);

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (i < version1.length) {
                    list1.add(Integer.parseInt(version1[i]));
                } else {
                    list1.add(0);
                }
                if (i < version2.length) {
                    list2.add(Integer.parseInt(version2[i]));
                } else {
                    list2.add(0);
                }
            }

            boolean flag = false;
            for (int i = 0; i < length; i++) {
                if (list1.get(i) > list2.get(i)) {
                    break;
                }
                if (list1.get(i) < list2.get(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            m--;
        }
    }
}
