package algorithms.sort;

/**
 * Created by Thpffcj on 2017/10/8.
 */
public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素arr[i]的合适的插入位置
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                swap(arr, j, j-1);
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("algorithms.sort.InsertionSort", arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
