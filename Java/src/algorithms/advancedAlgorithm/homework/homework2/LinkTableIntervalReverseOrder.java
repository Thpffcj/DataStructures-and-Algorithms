package algorithms.advancedAlgorithm.homework.homework2;

/**
 * Created by thpffcj on 2019/10/26.
 */

import java.util.Scanner;

/**
 * Description
 * 将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个表示链表长度，中间为节点值，最后代表K。
 *
 * Output
 * 输出的每一行为新的链表，节点值用空格隔开，末尾不要空格。
 *
 * 2
 * 8 1 2 3 4 5 6 7 8 3
 * 8 a b c d e f g h 4
 *
 * 3 2 1 6 5 4 7 8
 * d c b a h g f e
 */
public class LinkTableIntervalReverseOrder {

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

            int k = sc.nextInt();

            ListNode result = reverseKGroup(guard.next, k);
            StringBuilder sb = new StringBuilder();
            while (result != null) {
                sb.append(result.val).append(" ");
                result = result.next;
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k ==0){
                pre = reverse(pre, head.next);
                head = pre.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;//where first will be doomed "last"
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    static class ListNode<T> {

        public T val;
        public ListNode next;
        public ListNode(T x) { val = x; }
    }
}


