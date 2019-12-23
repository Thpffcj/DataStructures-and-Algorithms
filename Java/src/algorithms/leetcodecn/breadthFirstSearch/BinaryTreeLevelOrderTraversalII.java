package algorithms.leetcodecn.breadthFirstSearch;

/**
 * Created by thpffcj on 2019/12/23.
 */

import algorithms.leetcodecn.TreeNode;

import java.util.*;

/**
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
        Queue<Integer> levels = new LinkedList<>();
        node.offer(root);
        levels.offer(0);
        int lastLevel = -1;

        List<Integer> list = new ArrayList<>();
        while (!node.isEmpty()) {
            TreeNode curNode = node.poll();
            int level = levels.poll();

            if (level > lastLevel) {
                list = new ArrayList<>();
                result.add(list);
            }
            list.add(curNode.val);

            if (curNode.left != null) {
                node.offer(curNode.left);
                levels.offer(level + 1);
            }
            if (curNode.right != null) {
                node.offer(curNode.right);
                levels.offer(level + 1);
            }
            lastLevel = level;
        }

        Collections.reverse(result);
        return result;
    }
}
