package algorithms.networkMeasurement.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/8.
 *
 * 给定一组个字符串，为每个字符串找出能够唯一识别该字符串的最小前缀。
 *
 * 输入描述:
 * 第一行输入一个整数 n 表示字符串个数
 * 后面n行，每行一个字符串，一共n串互不相同的字符串。（2 <= n <= 100，字符串长度不超过100）
 *
 * 输出描述:
 * 输出n行，每行一个字符串，依次是每个字符串的最小可唯一识别前缀
 *
 * 输入例子1:
 * 5
 * meituanapp
 * meituanwaimai
 * dianpingliren
 * dianpingjiehun
 * mt
 *
 * 输出例子1:
 * meituana
 * meituanw
 * dianpingl
 * dianpingj
 * mt
 */
public class MeiTuan20204 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        int[] minS = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int index = 0;
                while (index < strs[i].length() && index < strs[j].length()
                        && strs[i].charAt(index) == strs[j].charAt(index)) {
                    index++;
                }
                if (index == strs[i].length()) {
                    if (minS[i] < index) {
                        minS[i] = index - 1;
                    }
                    if (minS[j] < index) {
                        minS[j] = index;
                    }
                } else if (index == strs[j].length()) {
                    if (minS[i] < index) {
                        minS[i] = index;
                    }
                    if (minS[j] < index) {
                        minS[j] = index - 1;
                    }
                } else {
                    if (minS[i] < index) {
                        minS[i] = index;
                    }
                    if (minS[j] < index) {
                        minS[j] = index;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(strs[i].substring(0, minS[i] + 1));
        }
    }
}
