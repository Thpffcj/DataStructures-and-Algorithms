package algorithms.swordRefersToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thpffcj on 2019/10/21.
 *
 * 上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Offer32_2 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.add(pRoot);
        level.add(1);

        TreeNode current;
        int lastLevel = 0;
        int currentLevel = 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            current = queue.poll();
            currentLevel = level.poll();

            if (currentLevel != lastLevel) {
                list = new ArrayList<>();
                result.add(list);
            }

            list.add(current.val);

            if (current.left != null) {
                queue.add(current.left);
                level.add(currentLevel + 1);
            }
            if (current.right != null) {
                queue.add(current.right);
                level.add(currentLevel + 1);
            }

            lastLevel = currentLevel;
        }

        return result;
    }
}
