package algorithms.leetcodeTag.aboutLinkedList;

/**
 * Created by Thpffcj on 2018/3/13.
 */

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

    // 存在bug
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode current = head;
//        if (head == null) {
//            return null;
//        }
//        while (current != null && current.next != null) {
//            while (current.val == current.next.val) {
//                current.next = current.next.next;
//            }
//            current = current.next;
//        }
//        return head;
//    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                break;
            }
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
