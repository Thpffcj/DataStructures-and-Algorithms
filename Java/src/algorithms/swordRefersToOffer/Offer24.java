package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/12.
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Offer24 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while(pNode != null){
            ListNode pNext = pNode.next;
            if(pNext == null) {
                newHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return newHead;
    }
}
