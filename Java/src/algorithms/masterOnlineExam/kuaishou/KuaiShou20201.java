package algorithms.masterOnlineExam.kuaishou;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by thpffcj on 2020/3/22.
 */
public class KuaiShou20201 {

    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     */
    public int[] DistanceToHigher (int[] height) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : i - stack.peek();
            stack.push(i);
        }
        return result;
    }
}
