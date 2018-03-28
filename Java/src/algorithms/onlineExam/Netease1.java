package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/27.
 */

/**
 * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己
 * 面向哪个方向，请你帮帮他。
 *
 * 输入描述：
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
 * 接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
 * 输出描述：
 * 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
 */
public class Netease1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos = 0;
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            for (int i = 0; i < n; i++) {
                if (line.charAt(i) == 'L') {
                    pos--;
                    if (pos == -1) {
                        pos = 3;
                    }
                } else {
                    pos++;
                    if (pos == 4) {
                        pos = 0;
                    }
                }
            }
            if (pos == 0) {
                System.out.println("N");
            } else if (pos == 1) {
                System.out.println("E");
            } else if (pos == 2) {
                System.out.println("S");
            } else {
                System.out.println("W");
            }
        }
    }
}
