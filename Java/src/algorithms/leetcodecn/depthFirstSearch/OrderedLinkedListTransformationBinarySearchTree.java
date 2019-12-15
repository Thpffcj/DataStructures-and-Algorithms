package algorithms.leetcodecn.depthFirstSearch;

/**
 * Created by thpffcj on 2019/12/12.
 */

import algorithms.leetcodecn.ListNode;
import algorithms.leetcodecn.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class OrderedLinkedListTransformationBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode mid = findHead(head);
        TreeNode node = new TreeNode(mid.val);

        if (head == mid) {
            return node;
        }

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);

        return node;
    }

    public ListNode findHead(ListNode node) {

        ListNode last = node;
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        last.next = null;

        return slow;
    }

    public static void main(String[] args) {
        OrderedLinkedListTransformationBinarySearchTree o = new OrderedLinkedListTransformationBinarySearchTree();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        o.sortedListToBST(head);
    }
}
