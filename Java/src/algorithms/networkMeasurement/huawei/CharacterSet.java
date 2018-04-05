package algorithms.networkMeasurement.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Thpffcj on 2018/3/16.
 */

/**
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入例子1:
 * abcqweracb
 *
 * 输出例子1:
 * abcqwer
 */
public class CharacterSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Set<Character> set = new HashSet<Character>();
            String line = sc.nextLine();
            String result = "";
            int n = line.length();
            for (int i = 0; i < n; i++) {
                if (!set.contains(line.charAt(i))) {
                    result = result + line.charAt(i);
                    set.add(line.charAt(i));
                }
            }
            System.out.println(result);
        }
    }
}
