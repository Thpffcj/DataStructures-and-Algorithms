package algorithms.leetcodecn.binaryTree;

import algorithms.leetcodecn.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thpffcj on 2020/3/6.
 *
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。
 * 你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为
 * 空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 *
 * 示例 1:
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 *
 * 示例 2:
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 *
 * 示例 3:
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        // 1.求出root的高度
        int maxDepth = getDepth(root);
        //2.求出输出List的宽度
        int width = 0;
        int count = maxDepth;
        while (count-- > 0) {
            width = width * 2 + 1;
        }

        // 对结果集初始化
        List<List<String>> res = new ArrayList<>(maxDepth);
        for (int i = 0; i < maxDepth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            res.add(list);
        }
        // 3.前序遍历，首先在结果集中填充左子树，然后填充右子树
        helper(root, 1, 0, width, res);
        return res;
    }

    private void helper(TreeNode root, int depth, int start, int end, List<List<String>> res) {
        if (root == null || start > end) {
            return;
        }
        // 获取当前节点需要插入List的位置
        int insert = start + (end - start) / 2;
        // 根据当前层数获得对应的List
        // 插入根节点
        res.get(depth - 1).set(insert, root.val + "");
        // 递归打印左子树
        helper(root.left, depth + 1, start, insert - 1, res);
        helper(root.right, depth + 1, insert + 1, end, res);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
