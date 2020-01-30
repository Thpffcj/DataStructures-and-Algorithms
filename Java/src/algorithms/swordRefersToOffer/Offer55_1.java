package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/12.
 *
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Offer55_1 {

    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
