package algorithms.leetcodecn.binaryTree;

/**
 * Created by thpffcj on 2019/10/20.
 */

import algorithms.leetcodecn.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class IntermediateOrderTraversalOfBinaryTrees {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.add(current);
                stack.add(current.left);
            } else {
                result.add(current.val);
                if (!stack.isEmpty()) {
                    TreeNode temp = stack.pop();
                    temp.left = null;
                    stack.add(temp);
                }
                if (current.right != null) {
                    stack.add(current.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IntermediateOrderTraversalOfBinaryTrees i = new IntermediateOrderTraversalOfBinaryTrees();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        root.left = node1;
        node1.left = node2;
        i.inorderTraversal(root);
    }
}
