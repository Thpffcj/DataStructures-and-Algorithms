package algorithms.algorithmInterview.aboutLinkedList;

/**
 * Created by Thpffcj on 2017/11/19.
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static void printNode(ListNode head) {
        while (null != head) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
