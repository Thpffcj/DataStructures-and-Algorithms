package algorithms.onlineExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/9.
 */
public class JingDong2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                List<Long> list = isSuccess(sc.nextLong());
                if (null == list) {
                    System.out.println("No");
                } else {
                    System.out.println(list.get(0) + " " + list.get(1));
                }
            }
        }
    }

    private static List<Long> isSuccess(Long number) {
        List<Long> list = new ArrayList<>();
        for (Long i = 2L; i < number; i += 2) {
            if (number % i == 0) {
                Long odd = number / i;
                if (odd % 2 != 0) {
                    list.add(odd);
                    list.add(i);
                    return list;
                }
            }
        }
        return null;
    }
}
