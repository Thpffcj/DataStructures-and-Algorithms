package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/4.
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇
 * 数，偶数和偶数之间的相对位置不变。
 */
public class AdjustTheOrderOfTheArray {

    public void reOrderArray(int[] array) {
        // 相对位置不变，稳定性
        // 插入排序的思想
        int m = array.length;
        // 记录已经摆好位置的奇数的个数
        int k = 0;
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {  // j >= k+1
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }

//    public void reOrderArray(int [] array) {
//
//        if (array == null || array.length == 0) {
//            return;
//        }
//
//        int start = 0;
//        int end = array.length - 1;
//        while (start < end) {
//            while (start < end && isEven(start)) {
//                start++;
//            }
//            while (end > start && !isEven(end)) {
//                end--;
//            }
//            if (start < end) {
//                int temp = array[start];
//                array[start] = array[end];
//                array[end] = temp;
//                start++;
//                end--;
//            }
//        }
//    }
//
//    private boolean isEven(int number) {
//        if (number % 2 == 0) {
//            return true;
//        }
//        return false;
//    }
}
