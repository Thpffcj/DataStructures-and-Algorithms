package algorithms.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by thpffcj on 2020/1/11.
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他
 * 行以此类推。
 */
public class PrintBinaryTreeInZigzagOrder {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        int level = 0;
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();

        even.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        result.add(list);
        while (!(odd.isEmpty() && even.isEmpty())) {
            if (level % 2 == 0) {
                TreeNode current = even.pop();
                list.add(current.val);
                if (even.isEmpty()) {
                    list = new ArrayList<>();
                    result.add(list);
                    level++;
                }

                if (current.left != null) {
                    odd.push(current.left);
                }
                if (current.right != null) {
                    odd.push(current.right);
                }

            } else {
                TreeNode current = odd.pop();
                list.add(current.val);
                if (odd.isEmpty()) {
                    list = new ArrayList<>();
                    result.add(list);
                    level++;
                }

                if (current.right != null) {
                    even.push(current.right);
                }
                if (current.left != null) {
                    even.push(current.left);
                }
            }
        }

        result.remove(result.size() - 1);
        return result;
    }
}
