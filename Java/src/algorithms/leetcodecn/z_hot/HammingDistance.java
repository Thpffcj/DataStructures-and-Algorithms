package algorithms.leetcodecn.z_hot;

/**
 * Created by thpffcj on 2020/3/1.
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 2^31.
 *
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int digit = x ^ y;
        int result = 0;
        while (digit > 0) {
            if ((digit & 1) != 0) {
                result++;
            }
            digit >>= 1;
        }
        return result;
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
