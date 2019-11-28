package algorithms.advancedAlgorithm.homework.homework1;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.Scanner;

/**
 * Description
 * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的第一行为N。
 * Output
 * 移动步数。
 *
 * Sample Input 1
 * 1
 * 2
 *
 * Sample Output 1
 * 8
 */
public class Hannota {

    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";

    /**
     * 总结来说我们要做的有两个步骤：
     * 1、当只要一个圆盘时：
     * 1)如果起点或者终点中有一个为中间柱子，直接把圆盘从起始柱子移动到目标柱子。
     * 2)如果起点和终点都不为中间的柱子，则需要两步，首先把圆盘从起始柱子移动到中间柱子，在从中间柱子移动到目标柱子。
     * 2、当有n(n>1)个圆盘时，需要把1—n-1圆盘从左边移动到右边，再将最底下的圆盘n移动到中间，把1—n-1圆盘从右边移动到左边，
     * 把圆盘n从中间移动到右边，1—n-1圆盘从左边移动到右边。
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            int n = sc.nextInt();
            int result = hannota(n, A, C);
            System.out.println(result);
        }
    }

    public static int hannota(int n, String from, String to) {

        if (n == 1) {
            if (from.equals(B) || to.equals("B")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            int num1 = hannota(n - 1, A, C);
            int num2 = hannota(n - 1, C, A);
            int num3 = hannota(n - 1, A, C);
            return num1 + 1 + num2 + 1 + num3;
        }
    }
}
