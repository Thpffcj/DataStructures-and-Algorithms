package algorithms.leetcodecn.linkedList;

/**
 * Created by thpffcj on 2019/10/8.
 */

import algorithms.leetcodecn.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddingTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode current = result;
        int digit = 0;
        int carry = 0;

        while (l1 != null && l2 != null) {
            digit = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            carry = 0;
            if (digit >= 10) {
                digit -= 10;
                carry = 1;
            }
            current.next = new ListNode(digit);
            current = current.next;
        }

        digit = 0;
        while (l1 != null) {
            if (carry == 0) {
                current.next = l1;
                break;
            } else {
                digit = l1.val + carry;
                carry = 0;
                if (digit >= 10) {
                    digit -= 10;
                    carry = 1;
                }
                current.next = new ListNode(digit);
                l1 = l1.next;
                current = current.next;
            }
        }
        while (l2 != null) {
            if (carry == 0) {
                current.next = l2;
                break;
            } else {
                digit = l2.val + carry;
                carry = 0;
                if (digit >= 10) {
                    digit -= 10;
                    carry = 1;
                }
                current.next = new ListNode(digit);
                l2 = l2.next;
                current = current.next;
            }
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return result.next;
    }
}
