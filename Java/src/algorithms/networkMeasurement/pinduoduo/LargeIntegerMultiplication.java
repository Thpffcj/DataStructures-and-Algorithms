package algorithms.networkMeasurement.pinduoduo;

/**
 * Created by Thpffcj on 2018/3/28.
 */

import java.util.Scanner;

/**
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 *
 * 输入描述:
 * 空格分隔的两个字符串，代表输入的两个大整数
 * 输出描述:
 * 输入的乘积，用字符串表示
 *
 * 输入例子1:
 * 72106547548473106236 982161082972751393
 * 输出例子1:
 * 70820244829634538040848656466105986748
 */
public class LargeIntegerMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] numbers = sc.nextLine().split(" ");
            String n1 = numbers[0];
            String n2 = numbers[1];
            int[] res = new int[n1.length() + n2.length()];
            for (int i = n1.length() - 1; i >= 0; i--) {
                int m = n1.charAt(i) - '0';
                for (int j = n2.length() - 1; j >= 0; j--) {
                    int n = n2.charAt(j) - '0';
                    res[i + j] = res[i + j] + (res[i + j + 1] + m * n) / 10;
                    res[i + j + 1] = (res[i + j + 1] + m * n) % 10;
                }
            }
            String s = "";
            for (int i = 0; i < res.length; i++) {
                if (i == 0 && res[i] == 0) {
                    continue;
                }
                s = s + res[i];
            }
            System.out.println(s);
        }
    }
}
