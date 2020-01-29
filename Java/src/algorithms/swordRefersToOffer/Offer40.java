package algorithms.swordRefersToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by thpffcj on 2020/1/14.
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Offer40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (k <= 0 || input.length < k) {
            return result;
        }

        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }

        return result;
    }
}
