package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.Scanner;

/**
 * Description
 * Given an array, the task is to complete the function which finds the maximum sum subarray, where you
 * may remove at most one element to get the maximum sum.
 *
 * Input
 * 第一行为测试用例个数T；后面每两行表示一个用例，第一行为用例中数组长度N，第二行为数组具体内容。
 *
 * Output
 * 每一行表示对应用例的结果。
 *
 * Sample Input 1
 * 1
 * 5
 * 1 2 3 -4 5
 *
 * Sample Output 1
 * 11
 */
public class BatchQuery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        while (nums > 0) {
            nums--;
            int inputLen = sc.nextInt();
            int[] arr = new int[inputLen];
            for (int i = 0; i < inputLen; i++) {
                arr[i] = sc.nextInt();
            }
            int[] f = new int[inputLen];
            int[] g = new int[inputLen];
            f[0] = arr[0];
            g[0] = -20001;//此处有点问题
            for (int i = 1; i < inputLen ; i++) {
                f[i] = Math.max(f[i - 1] + arr[i], arr[i]);
                g[i] = Math.max(g[i - 1] + arr[i], f[i - 1]);
            }
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < inputLen ; i++) {
                res = Math.max(res,Math.max(f[i], g[i]));
            }
            System.out.println(res);
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int numbers = sc.nextInt();
//        while (numbers > 0) {
//            int n = sc.nextInt();
//            int[] digit = new int[n];
//            for (int i = 0; i < n; i++) {
//                digit[i] = sc.nextInt();
//            }
//
//            System.out.println(maxSumSubarrayRemovingOneEle(digit, n));
//            numbers--;
//        }
//    }
//
//    static int maxSumSubarrayRemovingOneEle(int arr[], int n) {
//
//        // Maximum sum subarrays in forward and
//        // backward directions
//        int fw[] = new int[n];
//        int bw[] = new int[n];
//
//        // Initialize current max and max so far.
//        int cur_max = arr[0], max_so_far = arr[0];
//
//        // calculating maximum sum subarrays in forward
//        // direction
//        fw[0] = arr[0];
//
//        for (int i = 1; i < n; i++) {
//
//            cur_max = Math.max(arr[i], cur_max + arr[i]);
//            max_so_far = Math.max(max_so_far, cur_max);
//
//            // storing current maximum till ith, in
//            // forward array
//            fw[i] = cur_max;
//        }
//
//        // calculating maximum sum subarrays in backward
//        // direction
//        cur_max = max_so_far = bw[n - 1] = arr[n - 1];
//
//        for (int i = n - 2; i >= 0; i--) {
//
//            cur_max = Math.max(arr[i], cur_max + arr[i]);
//            max_so_far = Math.max(max_so_far, cur_max);
//
//            // storing current maximum from ith, in
//            // backward array
//            bw[i] = cur_max;
//        }
//
//        /* Initializing final ans by max_so_far so that,
//        case when no element is removed to get max sum
//        subarray is also handled */
//        int fans = max_so_far;
//
//        // choosing maximum ignoring ith element
//        for (int i = 1; i < n - 1; i++)
//            fans = Math.max(fans, fw[i - 1] + bw[i + 1]);
//
//        return fans;
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int caseNum = Integer.parseInt(sc.nextLine());
//        while (caseNum > 0){
//            int length = Integer.parseInt(sc.nextLine());
//            String[] strArray = sc.nextLine().split(" ");
//            int[] caseArray = new int[length];
//
//            for(int i = 0;i<length;i++){
//                caseArray[i] = Integer.parseInt(strArray[i]);
//            }
//
//
//            int sum = Integer.MIN_VALUE;
//            for(int i = 0;i<length;i++){
//                for(int j = i;j<length;j++){
//                    int temp = setMin(caseArray,i,j);
//                    if(temp>sum){
//                        sum=temp;
//                    }
//                }
//            }
//
//
//            System.out.println(sum);
//            caseNum --;
//        }
//    }
//
//    public static int setMin(int[] a,int m,int n){
//        int minNum = m;
//        boolean temp = false;
//        for(int i=m+1;i<n+1;i++){
//            if(a[i]<a[minNum]){
//                minNum = i;
//                if(a[minNum]<0){
//                    temp = true;
//                }
//            }
//        }
//
//        int sum = 0;
//        for(int i = m;i<n+1;i++){
//            if(i==minNum && temp) {
//                sum += 0;
//            }else {
//                sum += a[i];
//            }
//        }
//        return sum;
//    }
}
