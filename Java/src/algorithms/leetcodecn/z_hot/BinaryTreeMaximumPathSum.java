package algorithms.leetcodecn.z_hot;

import algorithms.leetcodecn.TreeNode;

/**
 * Created by thpffcj on 2020/3/3.
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 */
public class BinaryTreeMaximumPathSum {

    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    public int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        int price_newpath = node.val + left_gain + right_gain;

        max_sum = Math.max(max_sum, price_newpath);

        // 这个是自底向上求的，对于某节点来说，它这点的最大值是left + right + node.val。
        // 再考虑到该节点的父节点，父节点直接能选择子节点中相对大的一个，因为不能走回头路
        return node.val + Math.max(left_gain, right_gain);
    }

}
