package algorithms.leetcodecn.binaryTree;

/**
 * Created by thpffcj on 2019/10/10.
 */

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class DifferentBinarySearchTrees {

    /**
     * 思路:
     * 动态规划
     *
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数
     * 即有:G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
     * n为根节点，当i为根节点时，其左子树节点个数为[1,2,3,...,i-1]，右子树节点个数为[i+1,i+2,...n]，所以当i为根节点时，
     * 其左子树节点个数为i-1个，右子树节点为n-i，即f(i) = G(i-1)*G(n-i),
     * 上面两式可得:G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        if (n < 1) {
            return -1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        // G(2) = G(0) * G(1) + G(1) * G(0)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
