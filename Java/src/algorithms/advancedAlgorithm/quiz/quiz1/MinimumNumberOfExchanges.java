package algorithms.advancedAlgorithm.quiz.quiz1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/26.
 */

/**
 * Description
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are
 * required to complete the function which returns an integer denoting the minimum number of swaps, required to
 * sort the array.
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each
 * test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space
 * separated values of the array A[ ] .(1<=T<=100;1<=N<=100;1<=A[] <=1000)
 *
 * Output
 * For each test case in a new line output will be an integer denoting minimum umber of swaps that are required to
 * sort the array.
 *
 * Sample Input 1
 * 2
 * 4
 * 4 3 2 1
 * 5
 * 1 5 4 3 2
 *
 * Sample Output 1
 * 2
 * 2
 */
public class MinimumNumberOfExchanges {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int j = 0; j < n; j++) {
                digit[j] = sc.nextInt();
            }
            int result = getMinSwaps2(digit);
            System.out.println(result);
            numbers--;
        }
    }

    public static int getMinSwaps2(int[] nums) {

        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        // 建立每个元素与其应放位置的映射关系
        for (int i = 0; i < len; i++){
            map.put(nums1[i], i);
        }

        int result = 0;
        int position = 0;
        while (position < nums.length) {
            int digit = nums[position];
            if (position == map.get(digit)) {
                position++;
            } else {
                int temp = nums[map.get(digit)];
                nums[map.get(digit)] = digit;
                nums[position] = temp;
                result++;
            }
        }
        return result;
    }

    public static int getMinSwaps(int[] nums) {

        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        // 建立每个元素与其应放位置的映射关系
        for (int i = 0; i < len; i++){
            map.put(nums1[i], i);
        }

        // 循环节个数
        int loops = 0;
        boolean[] flag = new boolean[len];
        // 找出循环节的个数
        for (int i = 0; i < len; i++){
            // 已经访问过的位置不再访问
            if (!flag[i]){
                int j = i;
                while (!flag[j]){
                    flag[j] = true;
                    // 原序列中j位置的元素在有序序列中的位置
                    j = map.get(nums[j]);
                }
                loops++;
            }
        }
        return len - loops;
    }
}
