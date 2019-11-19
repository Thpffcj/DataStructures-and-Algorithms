package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.Scanner;

/**
 * Description
 * 对给定的点集合构造KD树，要求如下：将方差最大的维度作为当前的分割维度，将数据集在分割维度上排序后的中位数作为分割点。程序
 * 要检索给定点对应的最近的K个点的坐标。
 *
 * Input
 * 输入第一行为测试用例个数，后面为测试用例，每一个用例包含三行，第一行为点集合（点之间用逗号隔开，两个坐标用空格隔开），第二
 * 行为检索的点，第三行为K值。
 *
 * Output
 * 输出每一个用例的最近K个点，按照距离从小到大的顺序打印。
 *
 * Sample Input 1
 * 1
 * 3 5,6 2,5 8,9 3,8 6,1 1,2 9
 * 8.2 4.6
 * 2
 *
 * Sample Output 1
 * 8 6,9 3
 */
public class KDTreeConstructionAndLookup {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            int n = sc.nextInt();


            numbers--;
        }
    }
}
