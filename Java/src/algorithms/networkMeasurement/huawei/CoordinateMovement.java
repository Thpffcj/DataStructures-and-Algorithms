package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/4/2.
 */


import java.util.Scanner;

/**
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一
 * 些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 *
 * 输入描述:
 * 一行字符串
 * 输出描述:
 * 最终坐标，以,分隔
 *
 * 示例1
 * 输入
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出
 * 10,-10
 */
public class CoordinateMovement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(";");
            int n = input.length;
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                String op = input[i];
                if (op.length() == 0) {
                    continue;
                }
                char direction = op.charAt(0);
                String distance = op.substring(1);
                if (isDigit(distance)) {
                    switch (direction) {
                        case 'W':
                            y = y + Integer.parseInt(distance);
                            break;
                        case 'A':
                            x = x - Integer.parseInt(distance);
                            break;
                        case 'S':
                            y = y - Integer.parseInt(distance);
                            break;
                        case 'D':
                            x = x + Integer.parseInt(distance);
                            break;
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }

    public static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }
}
