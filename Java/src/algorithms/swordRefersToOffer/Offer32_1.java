package algorithms.swordRefersToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thpffcj on 2019/9/16.
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Offer32_1 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode = null;

        queue.add(root);
        while (!queue.isEmpty()) {
            currentNode =  queue.poll();
            result.add(currentNode.val);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }
}
