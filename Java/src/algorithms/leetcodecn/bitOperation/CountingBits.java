package algorithms.leetcodecn.bitOperation;

/**
 * Created by thpffcj on 2020/2/4.
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            ans[i] = popcount(i);
        }
        return ans;
    }

    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; count++) {
            x &= x - 1;
        }
        return count;
    }

    /**
     * x=(1001011101)2=(605)10
     * x′=(100101110)2=(302)10
     * ​可以发现 x'与 x 只有一位不同，这是因为 x' 可以看做 x 移除最低有效位的结果。
     * P(x)=P(x/2)+(xmod2)​
     */
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    /**
     * 与上述方法思路相同，我们可以利用最后设置位。
     * 最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0，就可以得到以下状态转移函数：
     * P(x)=P(x&(x−1))+1;
     */
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}
