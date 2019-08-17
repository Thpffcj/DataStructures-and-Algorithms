package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-08-11.
 */

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class RotateTheSmallestNumberOfArrays {

    public int minNumberInRotateArray(int [] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int i = 0;
        int j = array.length - 1;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            int head = array[i];
            int end = array[j];
            int current = array[mid];
            if (current == head && current == end) {
                return minInOrder(array);
            }
            if (current >= head && current <= end) {
                return head;
            } else if (current <= head && current >= end) {
                return end;
            } else if (current < head && current < end) {
                j = mid;
            } else if (current > head && current > end) {
                i = mid;
            }
        }
        return 0;
    }

    private int minInOrder(int [] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }
}
