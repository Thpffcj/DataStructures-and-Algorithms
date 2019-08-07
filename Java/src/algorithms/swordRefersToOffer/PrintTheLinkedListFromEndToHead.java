package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-08-03.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintTheLinkedListFromEndToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            if (listNode.next == null) {
                break;
            } else {
                listNode = listNode.next;
            }
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
