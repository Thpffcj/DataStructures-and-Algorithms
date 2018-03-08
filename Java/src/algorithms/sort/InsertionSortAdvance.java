package algorithms.sort;

/**
 * Created by Thpffcj on 2018/1/2.
 */
public class InsertionSortAdvance {

    private InsertionSortAdvance(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable min = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1].compareTo(min) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = min;
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
        SortTestHelper.testSort("algorithms.sort.InsertionSortAdvance", arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
