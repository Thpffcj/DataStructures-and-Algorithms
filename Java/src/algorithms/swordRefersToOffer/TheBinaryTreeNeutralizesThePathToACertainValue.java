package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/18.
 */

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点
 * 所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class TheBinaryTreeNeutralizesThePathToACertainValue {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        findPath(root, 0, target);
        return result;
    }

    public void findPath(TreeNode root, int current, int target) {
        if (root == null) {
            return;
        }
        current += root.val;
        path.add(root.val);
        if (current == target && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        findPath(root.left, current, target);
        findPath(root.right, current, target);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TheBinaryTreeNeutralizesThePathToACertainValue t = new TheBinaryTreeNeutralizesThePathToACertainValue();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        t.FindPath(node1, 22);
    }
}
