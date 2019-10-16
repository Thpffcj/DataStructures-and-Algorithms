package algorithms.leetcodecn.breadthFirstSearch;

/**
 * Created by thpffcj on 2019/10/16.
 */

import algorithms.leetcodecn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class HierarchicalTraversalOfBinaryTrees {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        queue.add(root);
        layers.add(0);

        TreeNode node;
        int layer;
        int lastLayer = -1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {

            node = queue.poll();
            layer = layers.poll();

            if (layer != lastLayer) {
                list = new ArrayList<>();
                list.add(node.val);
                result.add(list);
            } else {
                list.add(node.val);
            }

            if (node.left != null) {
                queue.add(node.left);
                layers.add(layer + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                layers.add(layer + 1);
            }

            lastLayer = layer;
        }

        return result;
    }
}
