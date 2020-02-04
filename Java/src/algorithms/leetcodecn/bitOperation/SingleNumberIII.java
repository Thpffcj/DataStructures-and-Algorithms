package algorithms.leetcodecn.bitOperation;

/**
 * Created by thpffcj on 2020/2/3.
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *
 * 注意：
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];

        int bit = 0;
        for (int i = 0; i < nums.length; i++) {
            bit ^= nums[i];
        }

        int bitPosition = findPosition(bit);
        for (int i = 0; i < nums.length; i++) {
            if (bitIsOne(nums[i], bitPosition)) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }

        return result;
    }

    public int findPosition(int bit) {
        int position = 0;
        while ((bit & 1) == 0) {
            bit >>= 1;
            position++;
        }
        return position;
    }

    public boolean bitIsOne(int num, int position) {
        return ((num >>= position) & 1) == 1;
    }

    public static void main(String[] args) {
        SingleNumberIII s = new SingleNumberIII();
        int[] nums = new int[]{1,2,1,3,2,5};
        s.singleNumber(nums);
    }
}
