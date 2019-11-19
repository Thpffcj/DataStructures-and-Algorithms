package algorithms.advancedAlgorithm.homework.homework3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/11/18.
 */

/**
 * Description
 * 给定有向无环图中所有边，计算图的拓扑排序解的个数。
 *
 * Input
 * 输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。
 *
 * Output
 * 输出拓扑排序解的个数。
 *
 * Sample Input 1
 * 1
 * a c,b c,c d,d e,d f,e g,f g
 *
 * Sample Output 1
 * 4
 */
public class NumberOfTopologicallyOrderedSolutions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            String[] lines = sc.nextLine().split(",");
            int m = lines.length;
            int n = 0;


            numbers--;
        }
    }
}
