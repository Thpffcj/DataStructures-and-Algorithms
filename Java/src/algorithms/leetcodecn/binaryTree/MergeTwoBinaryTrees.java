package algorithms.leetcodecn.binaryTree;

import algorithms.leetcodecn.TreeNode;

import java.util.LinkedList;

/**
 * Created by thpffcj on 2020/2/3.
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为
 * 新二叉树的节点。
 *
 * 示例 1:
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        TreeNode head;
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
           return t2;
        } else if (t2 == null) {
           return t1;
        } else {
            head = new TreeNode(t1.val + t2.val);
            head.left = mergeTrees(t1.left, t2.left);
            head.right = mergeTrees(t1.right, t2.right);
        }

        return head;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(t1);
        queue2.add(t2);

        // 按层遍历t2，同步遍历t1，对比相同位置的节点差异。
        // t2有而t1没有的节点，则给t1创建一个。
        // t2有t1也有的节点，值相加更新t1的节点值。
        while (!queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            // t2与t1对应节点的值，累计到t1的节点
            node1.val += node2.val;

            if (node2.left != null) {
                // t1左孩子节点不存在，则创建一个，节点值为0（t2有的节点，t1也要有）
                if (node1.left == null) {
                    node1.left = new TreeNode(0);
                }
                queue1.add(node1.left);
                queue2.add(node2.left);
            }

            if (node2.right != null) {
                // t1右孩子节点不存在，则创建一个，节点值为0（t2有的节点，t1也要有）
                if (node1.right == null) {
                    node1.right = new TreeNode(0);
                }
                queue1.add(node1.right);
                queue2.add(node2.right);
            }
        }

        return t1;
    }
}
