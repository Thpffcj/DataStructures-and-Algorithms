package algorithms.onlineExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */
/**
 * 题目描述
 * 华为应用市场举办安装应用奖励金币活动，不同的应用下载、试玩需要的流量大小不同，奖励的金币数量也不同，同一个应用多次下载只奖励一次金币，小华月末有一定的余量，计算下载哪些应用可以获取的金币最多？ 相同金币情况下，优先下排名靠前的应用。
 *
 * 输入描述:
 * 输入分三行
 * 第一行： 流量数，单位MB，整数，
 * 第二行：应用排名顺序，下载、试玩需要流量数，单位MB，整数
 * 第三行：应用奖励的金币数
 * 输出描述:
 * 输出应用列表：建议下载的应用顺序号，用一个空格分隔
 * 示例1
 * 输入
 * 40
 * 12 13 23 36
 * 11 11 20 30
 * 输出
 * 1 3
 * 说明
 * 注意输出： 开头、末尾没有空格
  */
public class HuaWei3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] d = sc.nextLine().split(" ");
            String[] b = sc.nextLine().split(" ");
            int[] download = new int[d.length];
            int[] bonus = new int[b.length];
            for (int i = 0; i < d.length; i++) {
                download[i] = Integer.parseInt(d[i]);
            }
            for (int i = 0; i < b.length; i++) {
                bonus[i] = Integer.parseInt(b[i]);
            }
            List<Integer> res = new ArrayList<>();
            res = money(download, bonus, n);
            for (int i = res.size() - 1; i >= 1; i--) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println(res.get(0));
        }
    }

    public static List<Integer> money(int[] download, int[] bonus, int C) {
        int n = download.length;
        int[][] dp = new int[n][C + 1];
        int[][] path = new int[n][C + 1];
        for (int i = 1; i < n; i++) {
            int d = download[i];
            int b = bonus[i];
            for (int j = 1; j <= C; j++) {
                if (j >= d) {
                    if (dp[i - 1][j] > dp[i - 1][j - d] + b) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j - d] + b;
                        path[i][j] = 1;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int i = n - 1;
        int j = C;
        List<Integer> list = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                list.add(i + 1);
                j = j - download[i];
            }
            i--;
        }
        return list;
    }
}
