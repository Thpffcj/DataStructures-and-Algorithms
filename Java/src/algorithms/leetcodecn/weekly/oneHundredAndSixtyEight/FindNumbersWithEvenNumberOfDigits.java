package algorithms.leetcodecn.weekly.oneHundredAndSixtyEight;

/**
 * Created by thpffcj on 2019/12/22.
 */

/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 * 示例 1：
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 *
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 *
 * 示例 2：
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 *
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 *
 * 提示：
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */
public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int digit = nums[i];

            if (findNumbers(digit) % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    private int findNumbers(int digit) {

        int result = 0;
        while (digit > 0) {
            result++;
            digit = digit / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits f = new FindNumbersWithEvenNumberOfDigits();
        int[] nums = new int[]{555,901,482,1771};
        f.findNumbers(nums);
    }
}
