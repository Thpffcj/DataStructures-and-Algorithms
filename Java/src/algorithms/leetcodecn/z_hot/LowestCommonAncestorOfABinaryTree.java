package algorithms.leetcodecn.z_hot;

import algorithms.leetcodecn.TreeNode;

import java.util.Stack;

/**
 * Created by thpffcj on 2020/2/26.
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能
 * 大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q ) {
            return root;
        }

        TreeNode leftCommonAncestor =  lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor =  lowestCommonAncestor(root.right, p, q);
        // 在左子树中没有找到，那一定在右子树中
        if(leftCommonAncestor == null){
            return rightCommonAncestor;
        }
        // 在右子树中没有找到，那一定在左子树中
        if(rightCommonAncestor == null){
            return leftCommonAncestor;
        }
        // 不在左子树，也不在右子树，那说明是根节点
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 中序遍历判断两个节点是否在左子树
        TreeNode cur = root.left;
        boolean pLeft = false;
        boolean qLeft = false;
        while (cur != null || !stack.isEmpty()) {
            // 节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; // 考虑左子树
            }
            // 节点为空，就出栈
            cur = stack.pop();
            // 判断是否等于 p 节点
            if (cur == p) {
                pLeft = true;
            }
            // 判断是否等于 q 节点
            if (cur == q) {
                qLeft = true;
            }

            if(pLeft && qLeft){
                break;
            }
            // 考虑右子树
            cur = cur.right;
        }

        // 两个节点都在左子树
        if (pLeft && qLeft) {
            return lowestCommonAncestor2(root.left, p, q);
            // 两个节点都在右子树
        } else if (!pLeft && !qLeft) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        // 一左一右
        return root;
    }
}
