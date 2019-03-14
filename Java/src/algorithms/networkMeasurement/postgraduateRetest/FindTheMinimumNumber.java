package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-14.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 题目描述
 * 第一行输入一个数n，1 <= n <= 1000，下面输入n行数据，每一行有两个数，分别是x y。输出一组x y，该组数据是所有数据中x最小，且
 * 在x相等的情况下y最小的。
 * 输入描述:
 * 输入有多组数据。
 * 每组输入n，然后输入n个整数对。
 * 输出描述:
 * 输出最小的整数对。
 *
 * 示例1
 * 输入
 * 5
 * 3 3
 * 2 2
 * 5 5
 * 2 1
 * 3 6
 * 输出
 * 2 1
 */
public class FindTheMinimumNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            ArrayList list = new ArrayList();
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }
}
