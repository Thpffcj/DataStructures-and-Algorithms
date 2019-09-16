package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/16.
 */

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricBinaryTree {

    boolean isSymmetrical(TreeNode pRoot) {
        return symmetricalTree(pRoot, pRoot);
    }

    boolean symmetricalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return symmetricalTree(root1.left, root2.right) && symmetricalTree(root1.right, root2.left);
    }
}
