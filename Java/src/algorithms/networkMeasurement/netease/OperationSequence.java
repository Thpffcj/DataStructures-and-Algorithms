package algorithms.networkMeasurement.netease;

/**
 * Created by Thpffcj on 2018/3/23.
 */

import java.util.Scanner;

/**
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
 * 输出描述:
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 *
 * 输入例子1:
 * 4
 * 1 2 3 4
 * 输出例子1:
 * 4 2 1 3
 */
public class OperationSequence {

    // TODO 过50% 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] numbers = sc.nextLine().split(" ");
            String[] res = new String[n];
            int i = 0;
            int j = n - 1;
            while (i <= j) {
                res[i] = numbers[n - 1 - 2 * i];
                if (i != j) {
                    res[j] = numbers[n - 2 - 2 * i];
                }
                i++;
                j--;
            }
            String result = "";
            for (int k = 0; k < n - 1; k++) {
                result = result + res[k] + " ";
            }
            result = result + res[n - 1];
            System.out.println(result);
        }
    }
}
