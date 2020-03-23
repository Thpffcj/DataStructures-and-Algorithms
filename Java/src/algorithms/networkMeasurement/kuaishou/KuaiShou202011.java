package algorithms.networkMeasurement.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/20.
 *
 * 给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
 * 1. 如果x==y，碰撞结果为两个石头消失
 * 2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
 * 最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
 *
 * 输入描述:
 * 第一行输入石头个数(<=100)
 * 第二行输入石头质量，以空格分割，石头质量总和<=10000
 *
 * 输出描述:
 * 最终的石头质量
 *
 * 输入例子1:
 * 6
 * 2 7 4 1 8 1
 *
 * 输出例子1:
 * 1
 */
public class KuaiShou202011 {

    // 答案错误:您提交的程序没有通过所有的测试用例
    // case通过率为41.18%
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] digit = new int[n];
//        for (int i = 0; i < n; i++) {
//            digit[i] = sc.nextInt();
//        }
//
//        int[][] dp = new int[n + 1][n + 1];
//        for (int i = 1; i <= n; i++){
//            Arrays.fill(dp[i], 10000);
//        }
//
//        for (int len = 0; len <= n; len++) {
//            for (int i = 1; i <= n - len; i++) {
//                int j = i + len;
//                if (len == 0) {
//                    dp[i][j] = 0;
//                }
//                for (int k = i; k < j; k++) {
//                    dp[i][j] = Math.min(dp[i][j],
//                            Math.abs(Math.abs(dp[i][k] - Math.abs(digit[j - 1] - digit[i - 1])) - dp[k + 1][j]));
//                }
//            }
//        }
//        System.out.println(dp[1][n]);
//    }

    // 利用0-1背包方法求出能将石头合并成2堆的情况，dp[j]代表是否能将石头分成其中一堆为j，另一堆为(sum-j)，其中一堆的最小值
    // 肯定不超过总和的一半，最后最接近的两堆即为最小值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int result = 0;
        int[] nums = new int[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j=sum/2;j>=nums[i];j--) {
                dp[j]|=dp[j-nums[i]];
            }
        }

        for(int j=sum/2;j>=0;j--) {
            if(dp[j]) {
                result=Math.abs(j-(sum-j));
                break;
            }
        }
        System.out.println(result);
    }
}
