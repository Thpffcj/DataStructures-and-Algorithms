package algorithms.networkMeasurement.aiqiyi;

/**
 * Created by Thpffcj on 2018/4/5.
 */

import java.util.Scanner;

/**
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,
 * repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 *
 *  输入描述:
 * 输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 * 输出描述:
 * 如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 *
 * 输入例子1:
 * 1010 3 101010 2
 * 输出例子1:
 * Equal
 */
public class CycleNumberComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int k1 = Integer.parseInt(line[1]);
            int k2 = Integer.parseInt(line[3]);
            String x1 = "";
            String x2 = "";
            for (int i = 0; i < k1; i++) {
                x1 = x1 + line[0];
            }
            for (int i = 0; i < k2; i++) {
                x2 = x2 + line[2];
            }
            if (x1.length() < x2.length()) {
                System.out.println("Less");
            } else if (x1.length() > x2.length()) {
                System.out.println("Greater");
            } else {
                boolean isEqual = true;
                for (int i = 0; i < x1.length(); i++) {
                    if (x1.charAt(i) > x2.charAt(i)) {
                        System.out.println("Greater");
                        isEqual = false;
                        break;
                    } else if (x1.charAt(i) < x2.charAt(i)) {
                        System.out.println("Less");
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    System.out.println("Equal");
                }
            }
        }
    }
}
