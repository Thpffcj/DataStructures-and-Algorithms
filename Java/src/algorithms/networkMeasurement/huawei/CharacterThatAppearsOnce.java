package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/4/3.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 * 输入描述:
 * 输入一个非空字符串
 * 输出描述:
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 * 输入
 * asdfasdfo
 * 输出
 * o
 */
public class CharacterThatAppearsOnce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int[] res = new int[128];
            Arrays.fill(res, 0);
            for (int i = 0; i < line.length(); i++) {
                res[line.charAt(i)] += 1;
            }
            boolean flag = true;
            for (int i = 0; i < line.length(); i++) {
                if (res[line.charAt(i)] == 1) {
                    System.out.println(line.charAt(i));
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(-1);
            }
        }
    }
}
