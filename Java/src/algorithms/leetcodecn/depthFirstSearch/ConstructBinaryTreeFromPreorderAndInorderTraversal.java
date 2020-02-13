package algorithms.leetcodecn.depthFirstSearch;

import algorithms.leetcodecn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thpffcj on 2020/2/12.
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    // 两个指针指向的数组范围是包括左边界，不包括右边界
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
                                     int[] inorder, int i_start, int i_end,
                                     Map<Integer, Integer> map) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;

        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1,
                inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end,
                inorder, i_root_index + 1, i_end, map);
        return root;
    }
}
