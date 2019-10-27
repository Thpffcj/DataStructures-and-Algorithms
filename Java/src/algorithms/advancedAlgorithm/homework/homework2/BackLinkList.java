package algorithms.advancedAlgorithm.homework.homework2;

/**
 * Created by thpffcj on 2019/10/26.
 */

import java.util.Scanner;

/**
 * Description
 * 判断一个单向链表是否为回文结构。自定义链表数据结构，要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个值为节点个数，后面为每一个节点值
 *
 * Output
 * 是回文则输出true，不是则输出false，一行表示一个链表的结果。
 *
 * 4
 * 3 1 2 1
 * 4 1 2 2 1
 * 3 3 5 3
 * 6 a b c d c a
 *
 * true
 * true
 * true
 * false
 */
public class BackLinkList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        for (int number = 0; number < numbers; number++) {
            int n = sc.nextInt();
            ListNode guard = new ListNode(-1);
            ListNode current = guard;

            for (int i = 0; i < n; i++) {
                ListNode listNode = new ListNode(sc.next());
                current.next = listNode;
                current = current.next;
            }

            ListNode slow = guard;
            ListNode fast = guard;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode second = slow.next;

            current = guard.next;
            ListNode head = current;
            ListNode pre = current.next;
            current.next = null;
            while (pre != slow) {
                head = pre;
                pre = pre.next;
                head.next = current;
                current = head;
            }

            ListNode first = null;
            // 奇数节点
            if (fast == null) {
                first = current;
            } else {
                pre.next = head;
                first = pre;
            }

            while (first != null) {
                if (!first.val.equals(second.val)) {
                    System.out.println(false);
                    break;
                }
                first = first.next;
                second = second.next;
            }
            if (first == null) {
                System.out.println(true);
            }
        }
    }

    static class ListNode<T> {

        public T val;
        public ListNode next;
        public ListNode(T x) { val = x; }
    }
}



