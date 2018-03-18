package algorithms.networkMeasurement.netease;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/3/17.
 */

public class MagicCurrency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int coinCount = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while (coinCount > 0) {
                if (coinCount % 2 == 0) {
                    //偶数
                    coinCount = (coinCount - 2) / 2;
                    sb.append("2");
                } else {
                    //奇数
                    coinCount = (coinCount - 1) / 2;
                    sb.append("1");
                }
            }
            System.out.println(sb.reverse().toString());
        }
    }
}