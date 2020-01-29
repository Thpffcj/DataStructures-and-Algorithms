package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/27.
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer53 {

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int start = 0;
        int end = array.length;
        int result = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == k) {
                int m = mid;
                while (mid < array.length && array[mid] == k) {
                    result++;
                    mid++;
                }
                mid = m;
                while (mid >= 0 && array[mid] == k ) {
                    result++;
                    mid--;
                }
                result--;
                break;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
