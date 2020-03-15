package algorithms.leetcodecn.z_hot;

import algorithms.leetcodecn.TreeNode;

import java.util.Stack;

/**
 * Created by thpffcj on 2020/3/2.
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点
 * 值之和。
 *
 * 例如：
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBstToGreaterTree {

    private int sum;
    public TreeNode convertBST(TreeNode root) {
        add(root);
        return root;
    }

    public void add(TreeNode root) {
        if (root == null) {
            return;
        }

        add(root.right);
        sum += root.val;
        root.val = sum;
        add(root.left);
    }

    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }

        return root;
    }
}
