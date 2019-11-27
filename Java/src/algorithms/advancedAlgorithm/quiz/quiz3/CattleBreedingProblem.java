package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */
public class CattleBreedingProblem {

    private static Map<Long, Long> map = new HashMap<Long, Long>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            System.out.println(fib(sc.nextLong() + 1));
            numbers--;
        }
    }

    public static long fib(long n) {

        if (n == 0) {
            return 0;
        }

        if (n == 2 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n % 2 != 0) {
            long k = (n + 1) / 2;
            map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
        } else {
            long k = n / 2;
            map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k))) % 1000000007);
        }
        return map.get(n);
    }
}
