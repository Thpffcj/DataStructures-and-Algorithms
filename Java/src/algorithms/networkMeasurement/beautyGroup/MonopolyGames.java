package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

import java.util.Scanner;

/**
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，点数为n时可以走n步。
 * 求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * <p>
 * 输入描述:
 * 输入包括一个整数n,(1 ≤ n ≤ 6)
 * <p>
 * 输出描述:
 * 输出一个整数,表示投骰子的方法
 * <p>
 * 输入例子1:
 * 6
 * 输出例子1:
 * 32
 */
public class MonopolyGames {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            int[] step;
            if (number < 6) {
                step = new int[7];
            } else {
                step = new int[number + 1];
            }
            step[0] = 1;
            step[1] = 1;
            step[2] = step[1] + step[0];
            step[3] = step[2] + step[1] + step[0];
            step[4] = step[3] + step[2] + step[1] + step[0];
            step[5] = step[4] + step[3] + step[2] + step[1] + step[0];
            step[6] = step[5] + step[4] + step[3] + step[2] + step[1] + step[0];

            for (int i = 7; i < number; i++) {
                step[i] = step[i - 1] + step[i - 2] + step[i - 3] + step[i - 4] + step[i - 5] + step[i - 6];
            }
            System.out.println(step[number]);
        }
    }
}
