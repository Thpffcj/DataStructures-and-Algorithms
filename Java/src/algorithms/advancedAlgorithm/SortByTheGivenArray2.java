package algorithms.advancedAlgorithm;

/**
 * Created by thpffcj on 2019/9/26.
 */

import java.util.*;

public class SortByTheGivenArray2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lengh = sc.nextInt();
        while (lengh > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] nums = new int[m];
            int[] B = new int[n];
            for (int i = 0; i < m; i++) {
                nums[i] = sc.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                B[i] = sc.nextInt();
                if (set.contains(B[i]) == false) {
                    set.add(B[i]);
                    map.put(B[i], 0);
                }
            }
            int lenBinA = 0;
            for (int i = 0; i < m; i++) {
                if (set.contains(nums[i])) {
                    lenBinA++;
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            }
            int temp[] = new int[m - lenBinA];
            int k = 0;
            for (int i = 0; i < m; i++) {
                if (set.contains(nums[i]) == false) {
                    temp[k] = nums[i];
                    k++;
                }
            }
            Arrays.sort(temp);
            boolean begin = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < map.get(B[i]); j++) {
                    if (begin == true) {
                        System.out.print(B[i]);
                        begin = false;
                    } else {
                        System.out.print(" ");
                        System.out.print(B[i]);
                    }
                }
            }
            for (int i = 0; i < k; i++) {
                System.out.print(" ");
                System.out.print(temp[i]);
            }
            System.out.println();
            lengh = lengh - 1;
        }
    }
}
