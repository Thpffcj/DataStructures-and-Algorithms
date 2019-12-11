package algorithms.leetcodecn.hashTable;

/**
 * Created by thpffcj on 2019/12/9.
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 
 * 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperature {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {  // 遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 我们按逆序遍历列表，对于每个 T[i]，我们要知道 (T[i],100] 温度所出现的位置，为此我们用一个 next 数组记录该数据，若当前位置出
     * 现 T[i]=100，则我们将该索引记录在 next[100]。
     * warmer_index 记录比当前温度高的索引位置，它等于 next[T[i]+1], next[T[i]+2], ..., next[100] 的最小值。
     */
    public int[] dailyTemperatures3(int[] T) {

        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);

        for (int i = T.length - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            // 从后往前找，就不用担心高的温度出现在前面
            for (int t = T[i] + 1; t <= 100; t++) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[T[i]] = i;
        }
        return ans;
    }

    /**
     * 我们需要找到比当前 T[i] 温度更高的位置，那么必须要记录哪些信息？
     * 我们试着找到 T[0] 过后温度升高的位置。如果知道 T[10]=50，则 T[20]=50 是无效信息，因为 T[i] 在 T[20] 以前已经到达了 50。
     * 如果 t[20]=100 将是有用的信息，因为如果 t[0]=80，那么 T[20] 将有可能是它的下一个温度升高的位置，而 T[10] 则不可能是。
     * 因此，我们需要记住一个索引的列表，索引代表的温度严格递增。我们可以利用栈来实现这样的效果。
     */
    public int[] dailyTemperatures4(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
