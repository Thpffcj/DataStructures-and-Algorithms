package algorithms.bachelorOnlineExam;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */
public class PingDuoDuo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(1);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(":");
            int hour = Integer.parseInt(line[0]);
            int minute = Integer.parseInt(line[1]);
            if (hour >= 12) {
                hour = hour - 12;
            }
            double mAngle = 6 * minute;
            double hAngle = 30 * hour + mAngle * 1.0 / 12.0;
            if (mAngle > hAngle) {
                double res = mAngle - hAngle;
                if (res > 180) {
                    res = 360 - res;
                }
                if (mAngle % 12 == 0) {
                    System.out.println((int) res);
                } else {
                    System.out.println(nf.format(res));
                }
            } else {
                double res = hAngle - mAngle;
                if (res > 180) {
                    res = 360 - res;
                }
                if (mAngle % 12 == 0) {
                    System.out.println((int) res);
                } else {
                    System.out.println(nf.format(res));
                }
            }
        }
    }
}
