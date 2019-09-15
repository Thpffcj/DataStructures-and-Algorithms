package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/14.
 */

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class CombineTwoSortedLinkedLists {

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return result.next;
    }
}
