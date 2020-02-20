package algorithms.leetcodecn.design;

import algorithms.leetcodecn.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by thpffcj on 2020/2/16.
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 * 提示：
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 */
class BSTIterator {

    // 提前保存
//    List<Integer> list;
//    public BSTIterator(TreeNode root) {
//        list = new ArrayList<>();
//        inOrder(root);
//    }
//
//    public void inOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inOrder(root.left);
//        list.add(root.val);
//        inOrder(root.right);
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return list.remove(0);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return list.size() != 0;
//    }


    // 一次迭代
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }

    public void push(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            push(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
