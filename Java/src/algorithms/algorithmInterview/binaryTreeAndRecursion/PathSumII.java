package algorithms.algorithmInterview.binaryTreeAndRecursion;

/**
 * Created by Thpffcj on 2018/3/18.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 *
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, path);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(path));
        } else {
            pathSum(root.left, sum - root.val, path);
            pathSum(root.right, sum - root.val, path);
        }
        path.remove(path.size() - 1);
    }
}
