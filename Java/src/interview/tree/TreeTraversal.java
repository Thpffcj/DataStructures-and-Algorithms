package interview.tree;

/**
 * Created by Thpffcj on 2017/9/19.
 */
public class TreeTraversal {

    public void preOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }

    public void postOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }
}
