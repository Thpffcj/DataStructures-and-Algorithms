package algorithms.advancedAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/9/26.
 */
public class MinimumNumberOfExchanges {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            for (int i = 0; i < number; i++) {
                int n = scanner.nextInt();
                int[] digit = new int[n];
                for (int j = 0; j < n; j++) {
                    digit[j] = scanner.nextInt();
                }
                int result = getMinSwaps(digit);
                System.out.println(result);
            }
        }
    }

    public static int getMinSwaps(int[] nums) {

        int[] nums1 = new int[nums.length];
        nums1 = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums1);

        Map<Integer, Integer> m = new HashMap<>();

        int len = nums.length;

        for (int i = 0; i < len; i++){
            m.put(nums1[i], i); // 建立每个元素与其应放位置的映射关系
        }

        int loops = 0; // 循环节个数
        boolean[] flag = new boolean[len];
        // 找出循环节的个数
        for (int i = 0; i < len; i++){
            if (!flag[i]){ //已经访问过的位置不再访问
                int j = i;
                while (!flag[j]){
                    flag[j] = true;
                    j = m.get(nums[j]);// 原序列中j位置的元素在有序序列中的位置
                }
                loops++;
            }
        }
        return len - loops;
    }
}
