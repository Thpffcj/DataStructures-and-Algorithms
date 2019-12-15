package algorithms.leetcodeTag.stackAndQueue;

/**
 * Created by Thpffcj on 2018/3/19.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * <p>
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        levelOrderBottom(res, root, 0);
        return res;
    }

    public void levelOrderBottom(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(0, new LinkedList<Integer>());
        }
        levelOrderBottom(res, root.left, level + 1);
        levelOrderBottom(res, root.right, level + 1);
        /*
          val 9
          val 15
          val 7
          val 20
          val 3
         */
//        System.out.println("val " + root.val);
        res.get(res.size() - level - 1).add(root.val);
    }
}
