package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/16.
 *
 * 作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Offer27 {

    public void Mirror(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        mirrorTree(root);
    }

    public void mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }
}
