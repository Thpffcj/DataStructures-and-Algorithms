package algorithms.networkMeasurement.netease;

/**
 * Created by Thpffcj on 2018/3/24.
 */

/**
 * 有一棵二叉树，树上每个点标有权值，权值各不相同，请设计一个算法算出权值最大的叶节点到权值最小的叶节点的距离。
 * 二叉树每条边的距离为1，一个节点经过多少条边到达另一个节点为这两个节点之间的距离。
 * 给定二叉树的根节点root，请返回所求距离。
 */

public class BinaryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public int getDis(TreeNode root) {
//        // write code here
//    }
}
