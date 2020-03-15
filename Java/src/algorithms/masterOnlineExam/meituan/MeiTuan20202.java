package algorithms.masterOnlineExam.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/12.
 */
public class MeiTuan20202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] digit = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            digit[i] = sc.nextInt();
            if (map.containsKey(digit[i])) {
                map.put(digit[i], map.get(digit[i]) + 1);
            } else {
                map.put(digit[i], 1);
            }
            if (map.get(digit[i]) > max) {
                max = map.get(digit[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            digit[i] |= x;
            if (map2.containsKey(digit[i])) {
                map2.put(digit[i], map2.get(digit[i]) + 1);
            } else {
                map2.put(digit[i], 1);
            }
            if (map2.get(digit[i]) > max) {
                max = map2.get(digit[i]);
            }
        }
        System.out.println(max);
    }
}
