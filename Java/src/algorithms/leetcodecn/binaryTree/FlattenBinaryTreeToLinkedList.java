package algorithms.leetcodecn.binaryTree;

/**
 * Created by thpffcj on 2019/12/24.
 */

import algorithms.leetcodecn.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {

    // 未通过
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode current = root.right;
        if (root.left != null) {
            root.right = root.left;
        }
        if (root.right != null) {
            root.right.right = current;
        }
    }

    public void flatten2(TreeNode root) {

        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

}
