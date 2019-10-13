package algorithms.advancedAlgorithm.homework.homework1;

/**
 * Created by thpffcj on 2019/10/10.
 */

import java.util.*;

/**
 * 数组和窗口
 * Description
 * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个元素使用空格隔开；第二行为窗口大小。
 * Output
 * 输出每个测试用例结果。
 *
 * 1
 * 4 3 5 4 3 3 6 7
 * 3
 *
 * 32
 */
public class ArraysAndWindows {

    /**
     * 对新来的元素k，将其与双端队列中的元素相比较
     * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     * 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     * 队列的第一个元素是滑动窗口中的最大值
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            int[] digit = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int size = Integer.parseInt(sc.nextLine());

            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < size - 1 && i < digit.length; i++) {
                while (!queue.isEmpty() && digit[i] >= digit[queue.getLast()]) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }

            int result = 0;
            // 窗口满了
            for (int i = size - 1; i < digit.length; i++) {
                while (!queue.isEmpty() && digit[i] >= digit[queue.getLast()]) {
                    queue.removeLast();
                }
                queue.addLast(i);
                // 删除队列中已经滑出窗口的数据对应的下标
                if (!queue.isEmpty() && queue.getFirst() <= (i - size)) {
                    queue.removeFirst();
                }
//                System.out.println(digit[queue.getFirst()]);
                result += digit[queue.getFirst()];
            }
//            System.out.println(result);
        }
    }
}
