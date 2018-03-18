package algorithms.algorithmInterview.binaryTreeAndRecursion;

/**
 * Created by Thpffcj on 2018/3/18.
 */

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeft(root)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    public boolean isLeft(TreeNode node) {
        if (node.left != null && node.left.left == null && node.left.right == null) {
            return true;
        }
        return false;
    }
}
