package algorithms.leetcodeTag.binaryTreeAndRecursion;

/**
 * Created by Thpffcj on 2018/3/13.
 */

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h
 * nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {

    // 会超时
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = countNodes(root.left);
//        int right = countNodes(root.right);
//        return left + right + 1;
//    }

    public int countNodes(TreeNode root) {
        int lHeight = leftHeight(root);
        int rHeight = rightHeight(root);
        if (lHeight == rHeight) {
            return (1 << lHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int leftHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + leftHeight(node.left);
    }

    public int rightHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + rightHeight(node.right);
    }
}
