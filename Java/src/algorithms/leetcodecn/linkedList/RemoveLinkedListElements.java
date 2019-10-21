package algorithms.leetcodecn.linkedList;

/**
 * Created by thpffcj on 2019/10/19.
 */

import algorithms.leetcodecn.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode guard = new ListNode(-1);
        guard.next = head;

        head = guard;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return guard.next;
    }
}
