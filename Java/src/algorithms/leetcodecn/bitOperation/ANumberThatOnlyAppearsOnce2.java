package algorithms.leetcodecn.bitOperation;

/**
 * Created by thpffcj on 2019/10/10.
 */

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class ANumberThatOnlyAppearsOnce2 {

    public int singleNumber(int[] nums) {
        int one = 0, two = 0, temp = 0;
        for (int num : nums) {
            temp = (two & num) | (one & ~num);
            two = (~one & ~two & num) | (two & ~num);
            one = temp;
        }
        return two;
        // 这里return two的原因是第二个状态为 01，one 为 0，two 为 1
    }
}
