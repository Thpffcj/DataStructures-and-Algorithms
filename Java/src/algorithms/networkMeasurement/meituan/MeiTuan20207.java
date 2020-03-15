package algorithms.networkMeasurement.meituan;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/9.
 *
 * 打车派单场景, 假定有N个订单， 待分配给N个司机。每个订单在匹配司机前，会对候选司机进行打分，打分的结果保存在N*N的矩阵A， 其
 * 中Aij 代表订单i司机j匹配的分值。
 * 假定每个订单只能派给一位司机，司机只能分配到一个订单。求最终的派单结果，使得匹配的订单和司机的分值累加起来最大，并且所有订单
 * 得到分配。
 *
 * 输入描述:
 * 第一行包含一个整数N，2≤N≤10。
 * 第二行至第N+1行包含N*N的矩阵。
 *
 * 输出描述:
 * 输出分值累加结果和匹配列表，结果四舍五入保留小数点后两位
 * （注意如果有多组派单方式得到的结果相同，则有限为编号小的司机分配编号小的订单，比如：司机1得到1号单，司机2得到2号单，就比司
 * 机1得到2号单，司机2得到1号单要好）
 *
 * 输入例子1:
 * 3
 * 1.08 1.25 1.5
 * 1.5 1.35  1.75
 * 1.22 1.48 2.5
 *
 * 输出例子1:
 * 5.25
 * 1 2
 * 2 1
 * 3 3
 *
 * 例子说明1:
 * 第一行代表得到的最大分值累加结果5.25，四舍五入保留两位小数；
 * 第二行至第四行代表匹配的结果[i j],其中i按行递增：
 * 订单1被派给司机2，订单2被派给司机1，订单3被派给司机3。使得A12+ A21+ A33= 1.25 + 1.5 + 2.5 = 5.25在所有的组合中最大。
 */
public class MeiTuan20207 {

    public static double sum = Integer.MIN_VALUE;
    public static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[][] digit = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                digit[i][j] = sc.nextDouble();
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        int[] order = new int[N];
        boolean[] visited = new boolean[N];
        arrange(digit, order, visited, 0, 0);

        System.out.println(df.format(sum));
        for (int i = 1; i <= N; i++) {
            System.out.println(i + " " + result[i - 1]);
        }
    }

    public static void arrange(double[][] digit, int[] order, boolean[] visited, int start, double cur) {
        if (start == order.length) {
            if (cur > sum) {
                sum = cur;
                result = order.clone();
            }
            return;
        }

        for (int i = 0; i < order.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[start] = i + 1;
                arrange(digit, order, visited, start + 1, cur + digit[start][i]);
                visited[i] = false;
            }
        }
    }
}
