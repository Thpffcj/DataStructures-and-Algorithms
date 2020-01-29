package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/12.
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Offer22 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode end = head;
        while (k >= 1 && end != null) {
            end = end.next;
            k--;
        }

        if (k > 0) {
            return null;
        }

        while (end != null) {
            head = head.next;
            end = end.next;
        }

        return head;
    }
}
