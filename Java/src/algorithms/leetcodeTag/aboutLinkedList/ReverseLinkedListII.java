package algorithms.leetcodeTag.aboutLinkedList;

/**
 * Created by Thpffcj on 2017/11/19.
 */


/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

//        ListNode sentinel = new ListNode(-1);
//        sentinel.next = head;
//        ListNode begin = sentinel;
//        ListNode end = sentinel;
//        ListNode temp = new ListNode(-1);
//        temp.next = new ListNode(-1);
//
//        // 反转开始的前一个节点
//        for (int i = 1; i < m; i++) {
//            begin = begin.next;
//        }
//        // 反转结束的后一个节点
//        for (int i = 0; i <= n; i++) {
//            end = end.next;
//        }
//
//        ListNode l = begin;
//        ListNode e = begin.next;
//        for (int i = m; i < n; i++) {
//            l = l.next;
//            ListNode current = l;
//            current.next = temp.next;
//            temp.next = current;
//        }
//        begin.next = temp.next;
//        e.next = end;
//        return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = m; i < n; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }

}

