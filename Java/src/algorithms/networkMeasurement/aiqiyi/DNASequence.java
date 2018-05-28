package algorithms.networkMeasurement.aiqiyi;

/**
 * Created by Thpffcj on 2018/4/19.
 */

import java.util.HashSet;
import java.util.Scanner;

/**
 * 牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 * 例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
 * <p>
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
 * 输出描述:
 * 输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
 * <p>
 * 输入例子1:
 * AGGTCTA
 * 输出例子1:
 * 2
 */
public class DNASequence {

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String line = sc.nextLine();
//            int res = DNALength(line);
//            System.out.println(res);
//        }
//    }
//
//    private static int DNALength(String line) {
//        int min = Integer.MAX_VALUE;
//        String a = "";
//        String c = "";
//        String g = "";
//        String t = "";
//        for (int i = 0; i < line.length(); i++) {
//            a = a + "A";
//            c = c + "C";
//            g = g + "G";
//            t = t + "T";
//            if (!(line.contains(a) && line.contains(c) && line.contains(g) && line.contains(t))) {
//                if (i < min) {
//                    return i + 1;
//                }
//            }
//        }
//        return -1;
//    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int i, j, n = input.length();
        for (i = 1; i <= n; i++) {
            HashSet<String> set = new HashSet<String>();
            for (j = 0; j < n - i; j++) {
                set.add(input.substring(j, j + i));
            }
            if (set.size() < Math.pow(4, i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
