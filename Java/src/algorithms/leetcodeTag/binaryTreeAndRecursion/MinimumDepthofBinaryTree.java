package algorithms.leetcodeTag.binaryTreeAndRecursion;

/**
 * Created by Thpffcj on 2017/11/19.
 */

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest
 * leaf node.
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
