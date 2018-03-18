package algorithms.networkMeasurement.NiuKeNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/16.
 */

/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
 * 如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 */
public class DeleteNumber {

    // 我的垃圾解法，虽然也能得到答案
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int number = Integer.parseInt(sc.nextLine());
//            if (number > 1000) {
//                number = 1000;
//            }
//            int[] num = new int[number];
//            for (int i = 0; i < number; i++) {
//                num[i] = i;
//            }
//            boolean[] delete = new boolean[number];
//            for (int i = 0; i < number; i++) {
//                delete[i] = true;
//            }
//            int pos = 0;
//            for (int i = 0; i < number - 1; i++) {
//                for (int j = 0; j < 2; j++) {
//                    while (delete[pos] == false) {
//                        pos++;
//                        if (pos > number - 1) {
//                            pos = pos % number;
//                        }
//                    }
//                    pos++;
//                    if (pos > number - 1) {
//                        pos = pos % number;
//                    }
//                }
//                while (delete[pos] == false) {
//                    pos++;
//                    if (pos > number - 1) {
//                        pos = pos % number;
//                    }
//                }
//                delete[pos] = false;
//            }
//            for (int i = 0; i < number; i++) {
//                if (delete[i] == true) {
//                    System.out.println(i);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n > 1000) {
                n = 999;
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int i = 0;
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
