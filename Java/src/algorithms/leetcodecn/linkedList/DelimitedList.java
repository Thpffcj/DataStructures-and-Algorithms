package algorithms.leetcodecn.linkedList;

/**
 * Created by thpffcj on 2019/12/19.
 */

import algorithms.leetcodecn.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class DelimitedList {

    public ListNode partition(ListNode head, int x) {

        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode curFirst = first;
        ListNode curSecond = second;

        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.val < x) {
                curFirst.next = head;
                curFirst = curFirst.next;
            } else {
                curSecond.next = head;
                curSecond = curSecond.next;
            }
            head = head.next;
        }
        // TODO 否则可能会出现环
        curSecond.next = null;

        curFirst.next = second.next;
        return first.next;
    }

    public static void main(String[] args) {
        DelimitedList d = new DelimitedList();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        d.partition(head, 3);
    }
}
