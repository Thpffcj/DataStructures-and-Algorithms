package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/29.
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Offer54 {

    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k <= 0) {
            return null;
        }

        return inOrder(pRoot, k);
    }

    TreeNode inOrder(TreeNode root, int k) {

        if (root == null) {
            return null;
        }

        TreeNode node = inOrder(root.left, k);
        if(node != null) {
            return node;
        }

        count++;
        if (count == k) {
            return root;
        }

        node = inOrder(root.right, k);
        if(node != null) {
            return node;
        }

        return null;
    }
}
