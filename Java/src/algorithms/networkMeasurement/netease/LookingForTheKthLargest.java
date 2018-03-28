package algorithms.networkMeasurement.netease;

/**
 * Created by Thpffcj on 2018/3/24.
 */

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */
public class LookingForTheKthLargest {

    public int findKth(int[] a, int n, int K) {
        return findKth(a, K, 0, n - 1);
    }

    public int findKth(int[] a, int k, int l, int r) {
        int part = partition(a, l, r);

        if (k == part - l + 1) {
            return a[part];
        } else if (k > part - l + 1) {
            return findKth(a, k - part + l - 1, part + 1, r);
        } else {
            return findKth(a, k, l, part -1);
        }
    }

    public int partition(int[] a, int low, int high) {
        int key = a[low];
        // 大的元素在前
        while (low < high) {
            while (low < high && a[high] <= key) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] >= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
}
