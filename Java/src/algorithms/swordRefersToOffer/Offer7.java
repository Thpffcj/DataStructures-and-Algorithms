package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-08-04.
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Offer7 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length) {
            return null;
        }
        return constructCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode constructCore(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
        // 前序遍历序列的第一个数字是根节点的值
        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;

        if (startPre == endPre) {
            if (startIn == endIn) {
                return root;
            } else {
                // TODO 出错
                return null;
            }
        }

        // 在中序遍历中找到根节点的值
        int rootIn = startIn;
        while (rootIn <= endIn && in[rootIn] != rootValue) {
            rootIn++;
        }

        if (rootIn == endIn && in[rootIn] !=  rootValue) {
            // TODO 出错
            return null;
        }

        int leftLength = rootIn - startIn;
        int leftPreEnd = startPre + leftLength;

        // 构建左子树
        if (leftLength > 0) {
            root.left = constructCore(pre, in, startPre + 1, leftPreEnd, startIn, rootIn - 1);
        }

        // 构建右子树
        if (endPre - startPre > leftLength) {
            root.right = constructCore(pre, in, leftPreEnd + 1, endPre, rootIn + 1, endIn);
        }

        return root;
    }

    public static void main(String[] args) {
        Offer7 reconstructTheBinaryTree = new Offer7();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        reconstructTheBinaryTree.reConstructBinaryTree(pre, in);
    }
}
