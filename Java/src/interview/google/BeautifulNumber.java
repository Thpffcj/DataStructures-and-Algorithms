package interview.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Thpffcj on 2017/9/30.
 */
public class BeautifulNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            long n = in.nextLong();
            System.out.println("Case #" + i + ": "
                    + beautiful(n));
        }
    }

    private static int beautiful(long n) {
        for (int radix = 2; radix < n; radix++) {
            if (isBeautiful(n, radix)) {
                return radix;
            }
        }

        throw new IllegalStateException("Should not reach here.");
    }

    private static boolean isBeautiful(long n, int radix) {
        while (n > 0) {
            if (n % radix != 1) {
                return false;
            }
            n /= radix;
        }
        return true;
    }
}
