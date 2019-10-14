package algorithms.leetcodecn.linkedList;

/**
 * Created by thpffcj on 2019/10/13.
 */

import algorithms.leetcodecn.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergingTwoOrderedLinkedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode current = head;
        if (l1 == null && l2 == null) {
            return head.next;
        }

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                break;
            } else if (l2 == null) {
                current.next = l1;
                break;
            } else {
                int v1 = l1.val;
                int v2 = l2.val;
                if (v1 <= v2) {
                    current.next = l1;
                    current = current.next;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    current = current.next;
                    l2 = l2.next;
                }
            }
        }
        return head.next;
    }
}
