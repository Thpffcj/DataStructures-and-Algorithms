package algorithms.leetcodeTag.stackAndQueue;

/**
 * Created by Thpffcj on 2018/3/19.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    // DFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new LinkedList<List<Integer>>();
//        levelOrder(res, root, 0);
//        return res;
//    }
//
//    public void levelOrder(List<List<Integer>> res, TreeNode node, int height) {
//        if (node == null) {
//            return;
//        }
//        if (height >= res.size()) {
//            res.add(new LinkedList<>());
//        }
//        res.get(height).add(node.val);
//        levelOrder(res, node.left, height + 1);
//        levelOrder(res, node.right, height + 1);
//    }

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if (root == null) {
            return res;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
