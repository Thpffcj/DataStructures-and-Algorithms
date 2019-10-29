package algorithms.advancedAlgorithm.homework.homework2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by thpffcj on 2019/10/27.
 */
public class NonRecursiveFastRow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int[] digits = new int[line.length];

            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(line[i]);
            }

            digits = generalQuickSort(digits, 0, digits.length - 1);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                sb.append(digits[i]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    public static int[] generalQuickSort(int[] nums, int left, int right) {

        // 定义一个栈
        Stack<Integer> stack = new Stack<>();

        // 前提条件就是left < right
        if (left < right) {
            stack.push(left);
            stack.push(right);
            while (!stack.isEmpty()) {
                int high = stack.pop();
                int low = stack.pop();

                int index = partition(nums, low, high);

                if (index - 1 > low) {
                    stack.push(low);
                    stack.push(index - 1);
                }

                if (index + 1 < high) {
                    stack.push(index + 1);
                    stack.push(high);
                }
            }
        }

        return nums;
    }

    private static int partition(int[] nums, int left, int right) {

        if (left > right || nums == null) {
            return -1;
        }

        int i = left;
        int j = right;

        int value = nums[left];
        while (left < right) {
            while (left < j && nums[left] <= value) {
                left++;
            }
            while (right > i && nums[right] > value) {
                right--;
            }

            if (left > right) {
                break;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        int temp = nums[right];
        nums[right] = nums[i];
        nums[i] = temp;

        return right;
    }
}
