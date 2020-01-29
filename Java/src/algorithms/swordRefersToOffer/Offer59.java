package algorithms.swordRefersToOffer;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/10.
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Offer59 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || size <= 0) {
            return result;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size - 1 && i < num.length; i++) {
            while (!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        // 窗口满了
        for (int i = size - 1; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            // 删除队列中已经滑出窗口的数据对应的下标
            if (!queue.isEmpty() && queue.getFirst() <= (i - size)) {
                queue.removeFirst();
            }
            result.add(num[queue.getFirst()]);
        }
        return result;
    }

}
