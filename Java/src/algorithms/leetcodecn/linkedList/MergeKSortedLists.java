package algorithms.leetcodecn.linkedList;

import algorithms.leetcodecn.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by thpffcj on 2020/1/22.
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }

        ListNode guard = new ListNode(0);
        ListNode head = guard;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll());
            head.next = node;
            head = head.next;
        }

        return guard.next;
    }

    // 典型的归并分治思想，自底向上，依次合并(可结合归并排序理解，将每个链表理解成排序的值)
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length - 1);
    }

    private ListNode solve(ListNode[] arr, int left, int right){
        if(left == right) {
            return arr[left];
        }

        int mid = (left + right) >> 1;
        ListNode lNode = solve(arr, left, mid);
        ListNode rNode = solve(arr, mid + 1, right);

        return merge(lNode, rNode);
    }

    private ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null) {
            return node2;
        }
        if(node2 == null) {
            return node1;
        }

        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
