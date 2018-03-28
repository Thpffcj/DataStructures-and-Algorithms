package algorithms.networkMeasurement.netease;

/**
 * Created by Thpffcj on 2018/3/27.
 */

import java.util.Scanner;

/**
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 *
 * 输入描述:
 * 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。
 * 输出描述:
 * 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在这样的整数A，B，C，则输出No
 *
 * 输入例子1:
 * 1 -2 3 4
 * 输出例子1:
 * 2 1 3
 */
public class CalculateCandy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] numbers = new int[4];
            for (int i = 0; i  < 4; i++) {
                numbers[i] = sc.nextInt();
            }
            int a = numbers[0] + numbers[2];
            int b = numbers[1] + numbers[3];
            int c = numbers[3] - numbers[1];
            if (2 * numbers[2] == a + b && 2 * numbers[3] == b + c) {
                System.out.println(a / 2 + " " + b / 2 + " " + c / 2);
            } else {
                System.out.println("No");
            }
        }
    }
}
