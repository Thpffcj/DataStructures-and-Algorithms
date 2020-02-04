package algorithms.leetcodecn.binaryTree;

import algorithms.leetcodecn.TreeNode;

/**
 * Created by thpffcj on 2020/2/3.
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 提示：
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = findMax(nums, left, right);
        TreeNode node = new TreeNode(nums[mid]);

        node.left = construct(nums, left, mid - 1);
        node.right = construct(nums, mid + 1, right);

        return node;
    }

    public int findMax(int[] nums, int start, int end) {
        int max = nums[start];
        int position = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                position = i;
            }
        }
        return position;
    }
}
