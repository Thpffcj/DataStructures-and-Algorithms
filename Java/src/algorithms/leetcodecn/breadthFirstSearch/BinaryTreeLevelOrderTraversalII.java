package algorithms.leetcodecn.breadthFirstSearch;

import algorithms.leetcodecn.TreeNode;

import java.util.*;

/**
 * Created by thpffcj on 2019/12/23.
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> node = new LinkedList<>();
        node.offer(root);

        while (!node.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = node.size();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = node.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    node.offer(curNode.left);
                }
                if (curNode.right != null) {
                    node.offer(curNode.right);
                }
            }
            result.add(0, list);
        }

        return result;
    }
}
