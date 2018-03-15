package algorithms.algorithmInterview.binaryTreeAndRecursion;

/**
 * Created by Thpffcj on 2018/3/13.
 */

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *   \   \
 *   3    3
 */
public class SymmetricTree {

    /**
     * 判断二叉树是否是平衡树，比如有两个节点n1, n2，我们需要比较n1的左子节点的值和n2的右子节点的值是否相等，
     * 同时还要比较n1的右子节点的值和n2的左子结点的值是否相等，以此类推比较完所有的左右两个节点。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
