package algorithms.swordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by thpffcj on 2019/9/28.
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 */
public class Offer57_1 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return result;
        }

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                result.add(array[start]);
                result.add(array[end]);
                break;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}
