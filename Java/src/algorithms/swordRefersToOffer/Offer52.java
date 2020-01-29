package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/28.
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Offer52 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode first;
        ListNode second;
        if (p1 != null) {
            first = pHead1;
            second = pHead2;
        } else {
            p2 = p1;
            first = pHead2;
            second = pHead1;
        }

        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            count++;
        }

        while (count > 0) {
            first = first.next;
            count--;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
