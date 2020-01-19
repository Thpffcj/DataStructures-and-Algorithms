package algorithms.leetcodecn.breadthFirstSearch;

import algorithms.leetcodecn.TreeNode;

import java.util.*;

/**
 * Created by thpffcj on 2020/1/18.
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 *
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(root);
        levels.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levels.poll();

            if (!visited.contains(level)) {
                result.add(node.val);
                visited.add(level);
            }

            if (node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }

            if (node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
        }

        return result;
    }

    // 题目求解的是右视图，那么BFS层次遍历时保存每层的最右一个节点即可
    public List<Integer> rightSideView2(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right !=null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }
}
