package algorithms.leetcodecn.linkedList;

import algorithms.leetcodecn.ListNode;

/**
 * Created by thpffcj on 2020/1/20.
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode guard = new ListNode(0);
        guard.next = head;

        ListNode pre = guard;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode last = cur.next;
        for (int i = 0; i < n - m; i++) {
            last = last.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = last;
        }

        return guard.next;
    }

    // 递归
    private boolean stop;
    private ListNode left;

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    public void recurseAndReverse(ListNode right, int m, int n) {

        if (n == 1) {
            return;
        }

        right = right.next;

        if (m > 1) {
            this.left = this.left.next;
        }

        this.recurseAndReverse(right, m - 1, n - 1);

        // 如果两个指针相互交叉或相等，我们将停止，即不再交换数据。至此我们完成了反转
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // 直到布尔停止为假，在两个指针之间交换数据
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // 向左移动右一步。 右指针通过回溯向后移动了一步
            this.left = this.left.next;
        }
    }

    // 迭代链接反转
    public ListNode reverseBetween3(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // 将固定最终连接的两个指针
        ListNode con = prev, tail = cur;

        // 迭代地反转节点，直到n变为0
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
