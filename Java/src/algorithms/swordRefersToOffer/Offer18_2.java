package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/10/20.
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Offer18_2 {

    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode guard = new ListNode(-1);
        ListNode result = guard;
        guard.next = pHead;
        ListNode slow = pHead;
        ListNode fast = pHead.next;

        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
                slow = slow.next;
                guard.next = fast;
            } else {
                fast = fast.next;
                slow = slow.next;
                if (guard.next != slow) {
                    guard = guard.next;
                }
            }
        }
        return result.next;
    }
}
