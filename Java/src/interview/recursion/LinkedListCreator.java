package interview.recursion;

import interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thpffcj on 2017/9/17.
 */
public class LinkedListCreator {

    /**
     * Creates a linked list.
     *
     * @param data the data to create the list
     * @return head of the linked list. The returned linked list
     * ends with last node with getNext() == null.
     */
    public <T> Node<T> createLinkedList(List<T> data) {

        if (data.isEmpty()) {
            return null;
        }

        Node<T> firstNode = new Node<>(data.get(0));
        Node headOfSublist = createLinkedList(data.subList(1, data.size()));
        firstNode.setNext(headOfSublist);

        return firstNode;
    }

    public Node<Integer> createLargeLinkedList(int size) {

        Node<Integer> prev = null;
        Node<Integer> head = null;
        for (int i = 1; i <= size; i++) {
            Node<Integer> node = new Node<>(i);
            if (prev != null) {
                prev.setNext(node);
            } else {
                head = node;
            }
            prev = node;
        }
        return head;
    }

    public static void main(String[] args) {

        LinkedListCreator creator = new LinkedListCreator();

        Node.printLinkedList(
                creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(
                creator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(
                creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
