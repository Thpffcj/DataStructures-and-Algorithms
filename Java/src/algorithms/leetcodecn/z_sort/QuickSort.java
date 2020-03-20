package algorithms.leetcodecn.z_sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by thpffcj on 2020/3/5.
 *
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整
 * 个数组排序了。
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    /**
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，再从数组的右端向左扫描找到第一个小于
     * 它的元素，交换这两个元素。不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小
     * 于切分元素。当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     */
    private int partition(T[] nums, int l, int h) {
        int i = l;
        int j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private int partition(int[] nums, int l, int h) {
        int i = l + 1;
        int j = h;
        int v = nums[l];
        while (i <= j) {
            while (nums[i] <= v && i != h) {
                i++;
            }
            while (v < nums[j] && j != l) {
                j--;
            }
            if (i >= j) {
                break;
            }
//            swap(nums, i, j);
        }
//        swap(nums, l, j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public void sort2(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort2(nums, l, lt - 1);
        sort2(nums, gt + 1, h);
    }

    /**
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时
     * a[j] 就是数组的第 j 大元素。
     * 可以利用这个特性找出数组的第 k 个元素。
     */
    public T select(T[] nums, int k) {
        int l = 0;
        int h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == k) {
                return nums[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        Integer[] digit = new Integer[]{1, 3, 2, 5, 4};
        System.out.println(q.select(digit, 2));
    }
}
