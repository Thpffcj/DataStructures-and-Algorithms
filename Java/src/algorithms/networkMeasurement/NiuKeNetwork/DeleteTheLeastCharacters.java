package algorithms.networkMeasurement.NiuKeNetwork;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/20.
 */

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 */
public class DeleteTheLeastCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int[] num = new int[26];
            for (int i = 0; i < line.length(); i++) {
                num[line.charAt(i) - 'a']++;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if(num[i] != 0 && num[i] < min) {
                    min = num[i];
                }
            }
            for (int i = 0; i < line.length(); i++) {
                if (num[line.charAt(i) - 'a'] != min) {
                    System.out.print(line.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
