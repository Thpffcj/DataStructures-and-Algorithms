package algorithms.leetcodecn.linkedList;

import algorithms.leetcodecn.ListNode;

/**
 * Created by thpffcj on 2020/1/31.
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode guard = new ListNode(-1);
        guard.next = head;

        ListNode pre = guard;
        ListNode last = head.next;
        while (last != null) {
            pre.next = last;
            last = last.next;
            pre.next.next = head;
            head.next = last;

            pre = head;
            head = head.next;
            if (last != null) {
                last = last.next;
            }
        }

        return guard.next;
    }

    public ListNode swapPairs2(ListNode head) {

        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next  = swapPairs2(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    public ListNode swapPairs3(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }
}
