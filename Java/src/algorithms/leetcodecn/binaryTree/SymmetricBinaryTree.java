package algorithms.leetcodecn.binaryTree;

/**
 * Created by thpffcj on 2019/10/12.
 */

import algorithms.leetcodecn.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val == r2.val) {
            return symmetric(r1.left, r2.right) & symmetric(r1.right, r2.left);
        }
        return false;
    }
}
