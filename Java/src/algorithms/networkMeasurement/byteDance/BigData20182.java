package algorithms.networkMeasurement.byteDance;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/17.
 *
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到
 * 所有可以选定各个区间的计算值:
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 *
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 * 区间内的所有数字都在[0, 100]的范围内;
 *
 * 输入描述:
 * 第一行输入数组序列长度n，第二行输入数组序列。
 * 对于 50%的数据,  1 <= n <= 10000;
 * 对于 100%的数据, 1 <= n <= 500000;
 *
 * 输出描述:
 * 输出数组经过计算后的最大值。
 *
 * 输入例子1:
 * 3
 * 6 2 1
 *
 * 输出例子1:
 * 36
 */
public class BigData20182 {

    /**
     * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     * case通过率为60.00%
     */
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] digit = new int[n];
//            for (int i = 0; i < n; i++) {
//                digit[i] = sc.nextInt();
//            }
//
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < digit.length; i++) {
//                int min = digit[i];
//                int sum = 0;
//                for (int j = i; j < digit.length; j++) {
//                    if (digit[j] < min) {
//                        min = digit[j];
//                    }
//                    sum += digit[j];
//                    int number = min * sum;
//                    if (number > max) {
//                        max = number;
//                    }
//                }
//            }
//
//            System.out.println(max);
//        }
//    }

    /**
     * 最大值区间的最小值必定是数组的某个数。对于数组的第 i 个数，以该数为中心，分别向左右两边探测直到遇到比该数小的数停止，探测过程中
     * 可同时累加探测到的数，探测结束后累加得到的和乘以该数便得到了以该数为最小值所能得到的区间的最大值。依次遍历数组的每个数，更新得
     * 到的最大值即可。
     */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i = 0; i < arr.length;i++){
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int count = arr[i];
            int j = i + 1;
            while(j < arr.length && arr[j] >= arr[i]){
                count += arr[j];
                j++;
            }

            j = i - 1;
            while(j >= 0 && arr[j] >= arr[i]){
                count += arr[j];
                j--;
            }

            count *= arr[i];
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
