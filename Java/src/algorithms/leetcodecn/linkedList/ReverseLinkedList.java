package algorithms.leetcodecn.linkedList;

import algorithms.leetcodecn.ListNode;

/**
 * Created by thpffcj on 2019/10/17.
 *
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            // 记录当前节点的下一个节点
            next = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            // pre和cur节点都前进一位
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
