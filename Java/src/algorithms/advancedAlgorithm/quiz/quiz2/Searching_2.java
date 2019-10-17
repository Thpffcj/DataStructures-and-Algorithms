package algorithms.advancedAlgorithm.quiz.quiz2;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/17.
 */
public class Searching_2 {

    public static final int top = 1000000;
    public static List<Integer> list = new ArrayList<Integer>();
    public static int[] isPrime = new int[1000001];
    static List<Long> result = new ArrayList<Long>();

    static {
        Arrays.fill(isPrime, 1);
        isPrime[0] = 0;
        isPrime[1] = 0;
        for (int i = 2; i * i <= top; i++) {
            int j = i + i;
            while (j <= top) {
                isPrime[j] = 0;
                j += i;
            }
        }
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == 1) list.add(i);
        }
        Collections.sort(list);
    }

    public static void prime() {
        int i, j;
        for (i = 0; i < list.size(); i++)
            for (j = i + 1; j < list.size(); j++) {
                if (i == j) continue;
                if ((long) list.get(i) * (long) list.get(j) > top) break;
                result.add((long) list.get(i) * (long) list.get(j));
            }

        for (i = 0; i < list.size(); i++) {
            long a = ((long) list.get(i) * (long) list.get(i));

            if (a <= 1000)
                result.add((long) (a * a));
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        prime();
        for (int i = 0; i < cases; i++) {
            long n = scan.nextLong();
            int count = 0;
            for (Long tt : result) {
                if (tt * tt <= n) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
