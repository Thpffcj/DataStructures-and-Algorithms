package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/28.
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对
 * 1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class Offer51 {

    public int InversePairs(int [] array) {

        if (array == null || array.length < 2) {
            return 0;
        }

        return (int) mergeCore(array, 0, array.length - 1) % 1000000007;
    }

    public long mergeCore(int[] array, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = ((right - left) >> 1) + left;
        long leftReverse = mergeCore(array, left, mid) % 1000000007;
        long rightReverse = mergeCore(array, mid + 1, right) % 1000000007;

        return leftReverse + rightReverse + merge(array, left, mid, right);
    }

    public long merge(int[] array, int left, int mid, int right) {
        long count = 0;
        int p1 = left;
        int p2 = mid + 1;
        int[] temp = new int[right - left + 1];
        int p = 0;
        while (p1 <= mid && p2 <= right) {
            if (array[p1] > array[p2]) {
                count += mid - p1 + 1;
                temp[p] = array[p2];
                p++;
                p2++;
            } else{
                temp[p] = array[p1];
                p++;
                p1++;
            }
        }
        while (p1 <= mid) {
            temp[p++] = array[p1++];
        }
        while (p2 <= right) {
            temp[p++] = array[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            array[left++] = temp[i];
        }
        return count % 1000000007;
    }
}
