package algorithms.leetcodecn.linkedList;

import algorithms.leetcodecn.ListNode;

/**
 * Created by thpffcj on 2020/1/19.
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(0);
        ListNode result = pre;
        pre.next = head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode first = sortList(pre.next);
        ListNode second = sortList(tmp);

        while (first != null && second != null) {
            if (first.val <= second.val) {
                pre.next = first;
                first = first.next;
            } else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }

        if (first != null) {
            pre.next = first;
        } else {
            pre.next = second;
        }

        return result.next;
    }

    // 从底至顶直接合并
    public ListNode sortList2(ListNode head) {

        // 增加头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preNode = pre;

        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }

        for (int len = 1; len < length; len *= 2){
            while (preNode != null){
                preNode = sortSubList(preNode, len);
            }
            preNode = pre;
        }

        return pre.next;
    }

    // 返回排序后的链表的最后一个节点
    ListNode sortSubList(ListNode pre, int len){
        // 当前指针位置
        int fstnum = 0, lstnum = 0;
        // 当前节点
        ListNode fst = pre.next, lst = fst;

        // 找到lst节点位置
        for (int i = 0; i < len; i++){
            // fst长度不够，直接返回null，此时子链表已经是排好序的
            if (lst == null)
                return null;
            lst = lst.next;
        }

        // 比较，终止条件为fstnum或lastnum大于子链表长度，或者lsatnum到达链表末尾
        while (fstnum < len && lstnum < len && lst != null){
            if (fst.val <= lst.val){
                pre.next = fst;
                fst = fst.next;
                fstnum++;
            }
            else{
                pre.next = lst;
                lst = lst.next;
                lstnum++;
            }
            pre = pre.next;
        }

        // 如果fst子链表还有剩余节点，接到当前节点后面
        if (fstnum < len){
            pre.next = fst;
            // 让当前节点走到子链表末尾
            for (; fstnum < len; fstnum++) {
                pre = pre.next;
            }
            // 接上后面的链表
            pre.next = lst;
        }

        // 和上面类似，此时还需考虑last子链表长度小于num的情况
        if (lstnum < len && lst != null){
            pre.next = lst;
            for (; lstnum < len && pre != null; lstnum++) {
                pre = pre.next;
            }
        }

        // 返回最后一个节点，作为下次排序的pre
        return pre;
    }
}
