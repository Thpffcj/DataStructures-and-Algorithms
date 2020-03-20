package algorithms.leetcodecn.z_sort;

/**
 * Created by thpffcj on 2020/3/5.
 *
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 *
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isSorted = false;
        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public void bubble(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 1 ; j--) {
                if (nums[j] > nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] nums = new int[]{4, 1, 3, 2};
        b.bubble(nums);
        for (Integer i : nums) {
            System.out.println(i);
        }
    }
}
