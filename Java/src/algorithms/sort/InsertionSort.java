package algorithms.sort;

/**
 * Created by Thpffcj on 2017/10/8.
 */
public class InsertionSort {

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr);

        return;
    }
}
