package algorithms.algorithmInterview.binaryTreeAndRecursion;

/**
 * Created by Thpffcj on 2018/3/19.
 */

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *   1
 *  / \
 * 2   3
 *
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {

    public int res = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return res;
    }

    public void sumNumbers(TreeNode root, int number) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res = res + 10 * number + root.val;
        }
        number = 10 * number + root.val;
        sumNumbers(root.left, number);
        sumNumbers(root.right, number);
    }
}
