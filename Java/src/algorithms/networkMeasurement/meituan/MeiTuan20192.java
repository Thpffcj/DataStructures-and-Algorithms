package algorithms.networkMeasurement.meituan;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/21.
 *
 * 给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，每次机会可以将串中的某个0改成1，现在问最大的可能答案
 *
 * 输入描述:
 * 输入第一行两个整数N,K，表示字符串长度和机会次数
 * 第二行输入N个整数，表示该字符串的元素
 * ( 1 <= N <= 300000
 * , 0 <= K <= N )
 *
 * 输出描述:
 * 输出一行表示答案
 *
 * 输入例子1:
 * 10 2
 * 1 0 0 1 0 1 0 1 0 1
 *
 * 输出例子1:
 * 5
 */
public class MeiTuan20192 {

    /**
     * 请检查是否存在数组越界等非法访问情况
     * case通过率为33.33%
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * at algorithms.networkMeasurement.meituan.MeiTuan20192.main(MeiTuan20192.java:44)
     */
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] digit = new int[n];
//        for (int i = 0; i < n; i++) {
//            digit[i] = sc.nextInt();
//        }

////        int n = 300000;
////        int k = 300000;
////        int[] digit = new int[n];
////        for (int i = 0; i < n; i++) {
////            digit[i] = 1;
////        }
//
//        int[][] dp = new int[n][n];
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            int number = 0;
//            for (int j = i; j < n; j++) {
//                if (digit[j] == 0) {
//                    if (number == k) {
//                        break;
//                    }
//                    number++;
//                }
//
//                if (j == 0) {
//                    dp[i][j] = 1;
//                } else {
//                    dp[i][j] = dp[i][j - 1] + 1;
//                }
//                result = Math.max(result, dp[i][j]);
//            }
//        }
//        System.out.println(result);
//    }

    /**
     * 用 l 代表左指针, r 代表右指针。当 k 非 0 时，我们就让右指针一直右移，遇到 1 就直接右移，遇到 0 时从 k 中选一个来填充该位，k
     * 就变成了 k−1。当 k 为 0 时，右指针遇到 1 依旧右移，遇到 0 时，需要停下来，因为此时的 k 不够用了，左指针要动了。左指针一定要遇
     * 到首个 0 时再停下来，此时左指针和右指针之间的数字长度就是指针 j 的最长全1子串 。记录此时的结果后，我们接着右移右指针，重复上述
     * 过程即可
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            if (nums[right] == 1) {
                right++;
            } else if (k > 0) {
                right++;
                k--;
            } else {
                max = Math.max(max, right - left);
                while (left < right && nums[left] == 1) {
                    left++;
                }
                left++;
                k++;
            }
        }

        System.out.println(Math.max(max, right - left));
    }
}
