package algorithms.networkMeasurement.postgraduateRetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019-03-02.
 */

/**
 * 题目描述
 * 对于一个字符串，将其后缀子串进行排序，例如grain 其子串有： grain rain ain in n 然后对各子串按字典顺序排序，即：
 * ain,grain,in,n,rain
 *
 * 输入描述:
 * 每个案例为一行字符串。
 *
 * 输出描述:
 * 将子串排序输出
 *
 * 示例1
 * 输入
 * grain
 *
 * 输出
 * ain
 * grain
 * in
 * n
 * rain
 */
public class SuffixSubstringSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.nextLine();
            ArrayList<String> list = new ArrayList<>();
            int n = word.length();
            for (int i = 1; i <= n; i++) {
                list.add(word);
                word = word.substring(1);
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
