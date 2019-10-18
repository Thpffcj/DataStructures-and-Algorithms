package algorithms.leetcodecn.linkedList;

/**
 * Created by thpffcj on 2019/10/17.
 */

import algorithms.leetcodecn.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode next = node.next;
        head.next = null;
        while (next != null) {
            node.next = head;
            head = node;
            node = next;
            next = next.next;
        }
        node.next = head;
        return node;
    }
}
