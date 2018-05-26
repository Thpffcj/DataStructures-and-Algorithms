package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/24.
 */

import java.math.BigInteger;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuffer res1 = new StringBuffer();
        while (l1 != null) {
            res1.append(l1.val);
            l1 = l1.next;
        }
        res1.reverse();

        StringBuffer res2 = new StringBuffer();
        while (l2 != null) {
            res2.append(l2.val);
            l2 = l2.next;
        }
        res2.reverse();

        BigInteger bigInteger1 = new BigInteger(res1.toString());
        BigInteger bigInteger2 = new BigInteger(res2.toString());
        BigInteger sum = bigInteger1.add(bigInteger2);

        StringBuffer res = new StringBuffer(sum.toString());
        res.reverse();

        char[] c = res.toString().toCharArray();
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int i = 0; i < c.length; i++) {
            curr.next = new ListNode(Integer.parseInt(c[i] + ""));
            curr = curr.next;
        }
        return dummyHead.next;
    }

    // 会溢出
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        int pos = 0;
//        int res1 = 0;
//        while (l1 != null) {
//            int digit = l1.val;
//            res1 += digit * Math.pow(10, pos);
//            pos++;
//            l1 = l1.next;
//        }
//
//        pos = 0;
//        int res2 = 0;
//        while (l2 != null) {
//            int digit = l2.val;
//            res2 += digit * Math.pow(10, pos);
//            pos++;
//            l2 = l2.next;
//        }
//
//        int res = res1 + res2;
//        ListNode dummyHead = new ListNode(0);
//        ListNode curr = dummyHead;
//        if (res == 0) {
//            return dummyHead;
//        }
//        while (res != 0) {
//            int digit = res % 10;
//            res = res / 10;
//            curr.next = new ListNode(digit);
//            curr = curr.next;
//        }
//        return dummyHead.next;
//    }
}
