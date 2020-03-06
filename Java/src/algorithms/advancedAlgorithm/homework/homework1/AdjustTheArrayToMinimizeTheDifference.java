package algorithms.advancedAlgorithm.homework.homework1;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/10.
 *
 * Description
 * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与
 * [序列 b 元素的和]之间的差最小。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入为两行，分别为两个数组，每个值用空格隔开。
 * Output
 * 输出变化之后的两个数组内元素和的差绝对值。
 *
 * Sample Input 1
 * 1
 * 100 99 98 1 2 3
 * 1 2 3 4 5 40
 *
 * Sample Output 1
 * 48
 */
public class AdjustTheArrayToMinimizeTheDifference {

    // TODO 容量限制？
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers-- > 0) {
            String[] line1 = sc.nextLine().split(" ");
            String[] line2 = sc.nextLine().split(" ");

            int[] digit = new int[line1.length * 2];
            for (int i = 0; i < line1.length; i++) {
                digit[i] = Integer.parseInt(line1[i]);
            }
            for (int i = line1.length; i < line1.length + line2.length; i++) {
                digit[i] = Integer.parseInt(line2[i - line1.length]);
            }

            int sum = 0;
            for (int i = 0; i < digit.length; i++) {
                sum += digit[i];
            }
            int x = sum / 2;
            int n = digit.length /2;

            // dp[i][j][v]表示在前i个物体中将j个物体放入到容量为v的背包中所获得的最大价值。
            // 其中dp[2n][n][sum(array)/2]便是其中一个划分部分的和。
//            int[][][] dp = new int[2 * n + 1][n + 1][x + 1];
//            for (int i = 1; i <= 2 * n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    for(int v = digit[i - 1]; v <= x; v++) {
//                        dp[i][j][v] = Math.max(dp[i - 1][j][v], dp[i - 1][j - 1][v - digit[i - 1]] + digit[i - 1]);
//                    }
//                }
//            }
//
//            System.out.println(Math.abs(sum - dp[2 * n][n][x] - dp[2 * n][n][x]));

            int[][] dp = new int[n + 1][x + 1];
            for (int i = 1; i <= 2 * n; i++) {
                for (int j = n; j >= 1; j--) {
                    for (int v = x; v >= digit[i - 1]; v--) {
                        dp[j][v] = Math.max(dp[j][v], dp[j - 1][v - digit[i - 1]] + digit[i - 1]);
                    }
                }
            }
            System.out.println(Math.abs(sum - dp[n][x] - dp[n][x]));
        }
    }


    static List<List<Integer>> result;

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int numbers = Integer.parseInt(sc.nextLine());
//        for (int number = 0; number < numbers; number++) {
//            result = new ArrayList<>();
//            String[] line1 = sc.nextLine().split(" ");
//            String[] line2 = sc.nextLine().split(" ");
//
//            int[] digit = new int[line1.length + line2.length];
//            boolean[] flag = new boolean[line1.length + line2.length];
//            int sum = 0;
//            for (int i = 0; i < line1.length; i++) {
//                digit[i] = Integer.parseInt(line1[i]);
//                sum += digit[i];
//            }
//            for (int i = line1.length; i < line1.length + line2.length; i++) {
//                digit[i] = Integer.parseInt(line2[i - line1.length]);
//                sum += digit[i];
//            }
//
//            List<Integer> list = new ArrayList<>();
//            permutation(list, digit, flag, 0, line1.length);
//
//            int min = Integer.MAX_VALUE;
//            list = new ArrayList<>();
//            for (int i = 0; i < result.size(); i++) {
//                list = result.get(i);
//                int current = 0;
//                for (int j = 0; j < list.size(); j++) {
//                    current += list.get(j);
//                }
//                if (Math.abs(sum - current - current) < min) {
//                    min = Math.abs(sum - current - current);
//                }
//            }
//            System.out.println(min);
//        }
//    }

    public static void permutation(List<Integer> list, int[] digit, boolean[] flag, int pos, int n) {
        if (list.size() > n) {
            return;
        }
        if (list.size() == n) {
            List<Integer> newList = new ArrayList<>(list);
            result.add(newList);
            return;
        }
        for (int i = pos; i < digit.length; i++) {
            if (flag[i] != true) {
                list.add(digit[i]);
                flag[i] = true;
                permutation(list, digit, flag, i + 1, n);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
}

//1
//100 99 98 1 2 3
//1 2 3 4 5 40