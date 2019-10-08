package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/18.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后
 * 复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ReplicationOfComplexLinkedLists {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode result = head;
        RandomListNode pNode = pHead;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(pHead, head);
        while (head != null) {
            RandomListNode oldNode = pHead.next;
            RandomListNode newNode = null;
            if (oldNode != null) {
                newNode = new RandomListNode(oldNode.label);
                map.put(oldNode, newNode);
            }
            head.next = newNode;
            pHead = pHead.next;
            head = newNode;
        }

        head = result;
        while (head != null) {
            head.random = map.get(pNode.random);
            pNode = pNode.next;
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ReplicationOfComplexLinkedLists r = new ReplicationOfComplexLinkedLists();
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r1.random = r3;
        r2.random = r5;
        r4.random = r2;
        r.Clone(r1);
    }
}
