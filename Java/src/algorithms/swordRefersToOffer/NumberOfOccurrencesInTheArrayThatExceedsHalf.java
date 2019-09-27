package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/26.
 */

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class NumberOfOccurrencesInTheArrayThatExceedsHalf {

    public int MoreThanHalfNum_Solution(int [] array) {

        if (array == null || array.length <= 0) {
            return 0;
        }
        int n = array.length;
        int half = n / 2;
        int[] bucket = new int[n + 1];
        for (int i = 0; i < n; i++) {
            bucket[array[i]]++;
            if (bucket[array[i]] > half) {
                return array[i];
            }
        }
        return 0;
    }
}
