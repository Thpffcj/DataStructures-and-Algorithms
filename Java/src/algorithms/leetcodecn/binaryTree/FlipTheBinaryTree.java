package algorithms.leetcodecn.binaryTree;

/**
 * Created by thpffcj on 2019/10/12.
 */

import algorithms.leetcodecn.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class FlipTheBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        invert(root);
        return root;
    }

    public void invert(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);
        }
    }
}